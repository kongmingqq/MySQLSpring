package msi.dao;

import msi.domain.Installment;
import msi.domain.Subscriber;
import msi.domain.Subscription;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UtilityDaoImpl extends SqlMapClientDaoSupport implements UtilityDao {
	private static Logger log = Logger.getLogger(UtilityDaoImpl.class);
	private static String utilityNamespace = "utility.";
	
	public int testQuery()
			throws Exception {
			int rv = (Integer) getSqlMapClientTemplate().queryForObject(utilityNamespace+"testQuery");
			return rv;
	}

	@Override
	public int insertInstallment(Installment installment) throws Exception {
		int rv = (Integer) getSqlMapClientTemplate().insert(utilityNamespace+"insertInstallment", installment);
		return rv;
	}

	@Override
	public void insertSubscriber(Subscriber subscriber) throws Exception {
		getSqlMapClientTemplate().insert(utilityNamespace+"insertSubscriber", subscriber);
	}

	@Override
	public void insertSubscriberInstallment(Subscription subscription)
			throws Exception {
		getSqlMapClientTemplate().insert(utilityNamespace+"insertSubscription", subscription);
	}
	
	@Override
	public void bulkInsertSubscriberInstallment(Subscription subscription)
			throws Exception {
		getSqlMapClientTemplate().insert(utilityNamespace+"bulkInsertSubscription", subscription);
	}

	@Override
	public int hasUserSubscribed(String userId) throws Exception {
		return (Integer) getSqlMapClientTemplate().queryForObject(utilityNamespace+"hasUserSubscribed", userId);
	}


}
