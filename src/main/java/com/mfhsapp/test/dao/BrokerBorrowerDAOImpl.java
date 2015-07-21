package com.mfhsapp.test.dao;

import java.math.BigInteger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mfhsapp.test.model.BrokerBorrower;


@Repository("brokerBorrowerDAO")
public class BrokerBorrowerDAOImpl implements BrokerBorrowerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void persistBrokerBorrower(BrokerBorrower brokerBorrower) {
		sessionFactory.getCurrentSession().persist(brokerBorrower);
	}

	public BrokerBorrower findBrokerBorrowerById(BigInteger id) {
		return (BrokerBorrower) sessionFactory.getCurrentSession().get(BrokerBorrower.class, id);
	}

	public void updateBrokerBorrower(BrokerBorrower brokerBorrower) {
		sessionFactory.getCurrentSession().update(brokerBorrower);

	}

	public void deleteBrokerBorrower(BrokerBorrower brokerBorrower) {
		sessionFactory.getCurrentSession().delete(brokerBorrower);

	}


}
