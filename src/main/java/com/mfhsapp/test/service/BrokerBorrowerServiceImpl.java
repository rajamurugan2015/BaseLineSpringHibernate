package com.mfhsapp.test.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfhsapp.test.dao.BrokerBorrowerDAO;
import com.mfhsapp.test.model.BrokerBorrower;

@Service("brokerBorrowerService")
public class BrokerBorrowerServiceImpl implements BrokerBorrowerService{

	@Autowired
	BrokerBorrowerDAO brokerBorrowerDAO;


	@Transactional
	public void persistBrokerBorrower(BrokerBorrower brokerBorrower) {
		brokerBorrowerDAO.persistBrokerBorrower(brokerBorrower);

	}

	@Transactional
	public void updateBrokerBorrower(BrokerBorrower brokerBorrower) {
		brokerBorrowerDAO.updateBrokerBorrower(brokerBorrower);

	}

	@Transactional
	public BrokerBorrower findBrokerBorrowerById(BigInteger id) {
		return brokerBorrowerDAO.findBrokerBorrowerById(id);
	}

	@Transactional
	public void deleteBrokerBorrower(BrokerBorrower brokerBorrower) {
		brokerBorrowerDAO.deleteBrokerBorrower(brokerBorrower);

	}

}
