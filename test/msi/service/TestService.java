package msi.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestService {

	@Test
	public void test() throws Exception {
		int rv = ServiceFactory.getInstantNotificationService().testQuery();
		System.out.println(rv);
	}

}
