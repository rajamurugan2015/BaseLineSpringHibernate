package com.mfhsapp.test.dao;

import java.math.BigInteger;

import com.mfhsapp.test.model.LoanRequest;

public interface LoanRequestDAO {
	public void persistLoanRequest(LoanRequest loanRequest);
	public LoanRequest findLoanRequestById(BigInteger id);
	public void updateLoanRequest(LoanRequest loanRequest);
	public void deleteLoanRequest(LoanRequest loanRequest);
}

