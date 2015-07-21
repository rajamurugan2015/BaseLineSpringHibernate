
package com.mfhsapp.test.dao;

import java.math.BigInteger;

import com.mfhsapp.test.model.BrokerBorrower;

public interface BrokerBorrowerDAO {
	public void persistBrokerBorrower(BrokerBorrower brokerBorrower);
	public BrokerBorrower findBrokerBorrowerById(BigInteger id);
	public void updateBrokerBorrower(BrokerBorrower brokerBorrower);
	public void deleteBrokerBorrower(BrokerBorrower brokerBorrower);
}

