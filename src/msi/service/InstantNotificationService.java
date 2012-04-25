package msi.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * APIs to fetch notifications and confirm delivery. (read and write from installment tables)
 * @author mkong
 *
 */
@Transactional(rollbackFor=InstantNotificationServiceException.class)
public interface InstantNotificationService {
	int testQuery() throws InstantNotificationServiceException;
	boolean hasUserSubscribed(String userId) throws InstantNotificationServiceException;
	int publishContent(String message) throws InstantNotificationServiceException;
	void subscribeUser(String userId) throws InstantNotificationServiceException;
	void issueSubscription(String userId, int installmentNumber) throws InstantNotificationServiceException;
	void subscribeAndIssue(String userId, int installmentNumber) throws InstantNotificationServiceException;
	
	void batchSubscribe(List<String> userIds) throws InstantNotificationServiceException;
	void batchIssue(List<String> userIds, int installmentNumber) throws InstantNotificationServiceException;
	
	void bulkIssue(List<String> userIds, int installmentNumber) throws InstantNotificationServiceException;
	void batchSubscribeWithCheck(List<String> userIds) throws InstantNotificationServiceException;
	
}
