package com.mfhsapp.test.service;

import java.math.BigInteger;

import com.mfhsapp.test.model.LoanTemplate;

public interface LoanTemplateService {
	void persistCriteria(LoanTemplate loanTemplate);

	LoanTemplate findCriteriaById(BigInteger id);

	void updateCriteria(LoanTemplate loanTemplate);

	void deleteCriteria(LoanTemplate loanTemplate);
}
