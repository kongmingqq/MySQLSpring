package msi.dao;

import msi.domain.*;
import msi.service.InstantNotificationServiceException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(rollbackFor=Exception.class)
public interface UtilityDao {
	int testQuery() throws Exception;
	int insertInstallment(Installment installment) throws Exception;
	//@Transactional(propagation=Propagation.NESTED)
	void insertSubscriber(Subscriber subscriber) throws Exception;
	void insertSubscriberInstallment(Subscription subscription) throws Exception;
	void bulkInsertSubscriberInstallment(Subscription subscription) throws Exception;
}
