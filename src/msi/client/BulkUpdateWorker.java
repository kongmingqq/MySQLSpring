package msi.client;

import java.util.ArrayList;
import java.util.List;

import msi.service.ServiceFactory;

public class BulkUpdateWorker {
	public static List<String> getUserIds() {
		List<String> userIds = new ArrayList<String>();
		for(int i=1;i<1000;i++) {
			userIds.add("guid_"+i);
		}
		return userIds;
	}
	public static void main(String[] args) throws Exception {
		int n = ServiceFactory.getInstantNotificationService().publishContent("my info");
		
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
		ServiceFactory.getInstantNotificationService().batchSubscribe(userIds);
		//ServiceFactory.getInstantNotificationService().bulkIssue(userIds, n);
	}
}
