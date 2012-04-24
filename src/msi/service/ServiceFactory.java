package msi.service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * ServiceFactory is the entry point for clients
 * @author mkong
 *
 */
public class ServiceFactory {
	private static Logger log = Logger.getLogger(ServiceFactory.class);
	private static InstantNotificationService instantNotificationService;
	static {
		try {
			ClassPathXmlApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");
			instantNotificationService=(InstantNotificationService)applicationContext.getBean("instantNotificationService");
		}catch(Exception e){
			log.error("error loading app context",e);
		}
	}

	public static InstantNotificationService getInstantNotificationService() throws Exception {
		if(instantNotificationService == null) {
			ClassPathXmlApplicationContext	applicationContext = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");
			instantNotificationService=(InstantNotificationService)applicationContext.getBean("instantNotificationService");
		}
		return instantNotificationService;
	}
}
