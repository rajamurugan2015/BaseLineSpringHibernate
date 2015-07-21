package com.mfhsapp.test.dao;

import java.math.BigInteger;

import com.mfhsapp.test.model.Lender;

public interface LenderDAO {
	public void persistLender(Lender lender);
	public Lender findLenderById(BigInteger id);
	public void updateLender(Lender lender);
	public void deleteLender(Lender lender);
}

