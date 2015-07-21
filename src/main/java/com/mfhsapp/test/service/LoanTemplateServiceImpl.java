package com.mfhsapp.test.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfhsapp.test.dao.LoanTemplateDAO;
import com.mfhsapp.test.model.LoanTemplate;

@Service("loanTemplateService")
public class LoanTemplateServiceImpl implements LoanTemplateService{

	@Autowired
	LoanTemplateDAO loanTemplateDAO;


	@Transactional
	public void persistCriteria(LoanTemplate loanTemplate) {
		loanTemplateDAO.persistCriteria(loanTemplate);

	}

	@Transactional
	public void updateCriteria(LoanTemplate loanTemplate) {
		loanTemplateDAO.updateCriteria(loanTemplate);

	}

	@Transactional
	public LoanTemplate findCriteriaById(BigInteger id) {
		return loanTemplateDAO.findCriteriaById(id);
	}

	@Transactional
	public void deleteCriteria(LoanTemplate loanTemplate) {
		loanTemplateDAO.deleteCriteria(loanTemplate);

	}


}