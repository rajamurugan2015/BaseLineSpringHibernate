package com.mfhsapp.test.service;

import java.math.BigInteger;

import com.mfhsapp.test.model.LoanRequest;

public interface LoanRequestService {
	void persistLoanRequest(LoanRequest loanRequest);

	LoanRequest findLoanRequestById(BigInteger id);

	void updateLoanRequest(LoanRequest loanRequest);

	void deleteLoanRequest(LoanRequest loanRequest);
}
