package com.mfhsapp.test.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfhsapp.test.dao.LoanRequestDAO;
import com.mfhsapp.test.model.LoanRequest;

@Service("loanRequestService")
public class LoanRequestServiceImpl implements LoanRequestService{

	@Autowired
	LoanRequestDAO loanRequestDAO;


	@Transactional
	public void persistLoanRequest(LoanRequest loanRequest) {
		loanRequestDAO.persistLoanRequest(loanRequest);

	}

	@Transactional
	public void updateLoanRequest(LoanRequest loanRequest) {
		loanRequestDAO.updateLoanRequest(loanRequest);

	}

	@Transactional
	public LoanRequest findLoanRequestById(BigInteger id) {
		return loanRequestDAO.findLoanRequestById(id);
	}

	@Transactional
	public void deleteLoanRequest(LoanRequest loanRequest) {
		loanRequestDAO.deleteLoanRequest(loanRequest);

	}

}
