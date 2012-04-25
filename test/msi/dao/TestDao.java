package msi.dao;

import static org.junit.Assert.*;

import msi.domain.Installment;
import msi.domain.Subscriber;
import msi.domain.Subscription;
import msi.service.InstantNotificationService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {
	UtilityDao dao;
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");
		dao=(UtilityDao)applicationContext.getBean("utilityDao");
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void testInsertInstallment() throws Exception {
		Installment installment = new Installment();
		installment.setInstallmentContent("test content");
		int rv = dao.insertInstallment(installment);
		System.out.println(rv);
	}
	//@Test
	public void testInsertSubscriber() throws Exception {
		Subscriber subscriber = new Subscriber();
		subscriber.setUserId("testUser1");
		dao.insertSubscriber(subscriber);
	}
	//@Test
	public void testInsertSubscrption() throws Exception {
		Subscription subscription = new Subscription();
		subscription.setUserId("testUser1");
		subscription.setInstallmentNumber(5);
		dao.insertSubscriberInstallment(subscription);
	}
	@Test
	public void testHasSubscribed() throws Exception {
		int a = dao.hasUserSubscribed("guid_1001");
		System.out.println(a);
	}
}
