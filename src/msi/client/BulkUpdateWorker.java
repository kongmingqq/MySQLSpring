package msi.client;

import java.util.ArrayList;
import java.util.List;

import msi.service.InstantNotificationServiceException;
import msi.service.ServiceFactory;

public class BulkUpdateWorker extends Thread {
	public static List<String> getUserIds() {
		List<String> userIds = new ArrayList<String>();
		for(int i=1;i<3000;i++) {
			userIds.add("guid_"+i);
		}
		return userIds;
	}
	
	public static List<String> getAnotherUserIds() {
		List<String> userIds = new ArrayList<String>();
		for(int i=1;i<3000;i++) {
			userIds.add("anotherUser_"+i);
		}
		return userIds;
	}
	
	public void run() {
		int n;
		try {
			n = ServiceFactory.getInstantNotificationService().publishContent("my another info");
			List<String> userIds = getAnotherUserIds();
			ServiceFactory.getInstantNotificationService().batchSubscribe(userIds);
			ServiceFactory.getInstantNotificationService().bulkIssue(userIds, n);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws Exception {
		//BulkUpdateWorker thread = new BulkUpdateWorker();
		//thread.start();
		
		int n = ServiceFactory.getInstantNotificationService().publishContent("my this info");
		
		List<String> userIds = getUserIds();
		/*
		for(String id:userIds) {
			try {
				//ServiceFactory.getInstantNotificationService().subscribeUser(id);
				//ServiceFactory.getInstantNotificationService().issueSubscription(id, n);
				ServiceFactory.getInstantNotificationService().subscribeAndIssue(id, n);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("error when processing "+id);
				e.printStackTrace();
			} finally {
				System.out.println("processed "+id);
			}
		}
		*/
		ServiceFactory.getInstantNotificationService().batchSubscribeWithCheck(userIds);
		//ServiceFactory.getInstantNotificationService().batchSubscribe(userIds);
		//ServiceFactory.getInstantNotificationService().bulkIssue(userIds, n);
	}
}
