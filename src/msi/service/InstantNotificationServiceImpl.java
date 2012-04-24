package msi.service;


import java.util.Date;
import java.util.List;

import msi.dao.UtilityDao;
import msi.domain.Installment;
import msi.domain.Subscriber;
import msi.domain.Subscription;

import org.apache.log4j.Logger;

public class InstantNotificationServiceImpl implements
		InstantNotificationService {
	private static Logger log = Logger.getLogger(InstantNotificationServiceImpl.class);

	private UtilityDao utilityDao;

	public UtilityDao getUtilityDao() {
		return utilityDao;
	}

	public void setUtilityDao(UtilityDao utilityDao) {
		this.utilityDao = utilityDao;
	}
	
	public int testQuery()
			throws InstantNotificationServiceException {
		try {
			return utilityDao.testQuery();
		} catch (Exception e) {
			throw new InstantNotificationServiceException(e);
		}
	}

	@Override
	public int publishContent(String message) throws InstantNotificationServiceException {
		Installment installment = new Installment();
		installment.setInstallmentContent(message);
		int rv;
		try {
			rv = utilityDao.insertInstallment(installment);
		} catch (Exception e) {
			throw new InstantNotificationServiceException(e);
		}
		return rv;
	}

	@Override
	public void subscribeUser(String userId) throws InstantNotificationServiceException {
		Subscriber subscriber = new Subscriber();
		subscriber.setUserId(userId);
		try {
			utilityDao.insertSubscriber(subscriber);
		} catch (Exception e) {
			throw new InstantNotificationServiceException(e);
		}
	}

	@Override
	public void issueSubscription(String userId, int installmentNumber)
			throws InstantNotificationServiceException {
		Subscription subscription = new Subscription();
		subscription.setUserId(userId);
		subscription.setInstallmentNumber(installmentNumber);
		try {
			utilityDao.insertSubscriberInstallment(subscription);
		} catch (Exception e) {
			throw new InstantNotificationServiceException(e);
		}
	}

	@Override
	public void subscribeAndIssue(String userId, int installmentNumber)
			throws InstantNotificationServiceException {
		subscribeUser(userId);
		issueSubscription(userId,installmentNumber);
	}

	@Override
	public void batchSubscribe(List<String> userIds) throws InstantNotificationServiceException {
		System.out.println("batchSubscribe started");
		Date a = new Date();
		//int i=0;
		for(String userId:userIds) {
			//i++;
			//if(i>3000) throw new Exception("failure");
			try {
				//ServiceFactory.getInstantNotificationService().subscribeUser(userId);
				Subscriber subscriber = new Subscriber();
				subscriber.setUserId(userId);
				utilityDao.insertSubscriber(subscriber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("\nerror when processing "+userId);
				//e.printStackTrace();
			} finally {
				System.out.print("... "+userId);
			}
		}
		System.out.println("\nbatchSubscribe ended");
		System.out.println(new Date().getTime()-a.getTime());
	}

	@Override
	public void batchIssue(List<String> userIds, int installmentNumber) throws InstantNotificationServiceException {
		System.out.println("batchIssue started");
		Date a = new Date();
		for(String userId:userIds) {
			try {
				ServiceFactory.getInstantNotificationService().issueSubscription(userId, installmentNumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("\nerror when processing "+userId);
				e.printStackTrace();
			} //finally {
				//System.out.print("... "+userId);
			//}
		}
		System.out.println("batchIssue ended");
		System.out.println(new Date().getTime()-a.getTime());
	}
	
	@Override
	public void bulkIssue(List<String> userIds, int installmentNumber) throws InstantNotificationServiceException {
		System.out.println("bulkIssue started");
		Date a = new Date();

		Subscription subscription = new Subscription();
		subscription.setUserIds(userIds);
		subscription.setInstallmentNumber(installmentNumber);
		try {
			utilityDao.bulkInsertSubscriberInstallment(subscription);
		} catch (Exception e) {
			throw new InstantNotificationServiceException(e);
		}
		
		System.out.println("bulkIssue ended");
		System.out.println(new Date().getTime()-a.getTime());
	}

}
