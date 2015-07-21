package com.mfhsapp.test.service;

import java.math.BigInteger;

import com.mfhsapp.test.model.BrokerBorrower;

public interface BrokerBorrowerService {
	void persistBrokerBorrower(BrokerBorrower brokerBorrower);

	BrokerBorrower findBrokerBorrowerById(BigInteger id);

	void updateBrokerBorrower(BrokerBorrower brokerBorrower);

	void deleteBrokerBorrower(BrokerBorrower brokerBorrower);
}
