package com.mfhsapp.test.service;

import java.math.BigInteger;

import com.mfhsapp.test.model.Lender;

public interface LenderService {
	void persistLender(Lender lender);

	Lender findLenderById(BigInteger id);

	void updateLender(Lender lender);

	void deleteLender(Lender lender);
}
