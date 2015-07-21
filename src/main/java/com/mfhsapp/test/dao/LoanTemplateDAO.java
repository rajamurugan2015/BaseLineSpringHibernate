package com.mfhsapp.test.dao;

import java.math.BigInteger;

import com.mfhsapp.test.model.LoanTemplate;

public interface LoanTemplateDAO {
	public void persistCriteria(LoanTemplate loanTemplate);
	public LoanTemplate findCriteriaById(BigInteger id);
	public void updateCriteria(LoanTemplate loanTemplate);
	public void deleteCriteria(LoanTemplate loanTemplate);
}

