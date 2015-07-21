package com.mfhsapp.test.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfhsapp.test.dao.LenderDAO;
import com.mfhsapp.test.model.Lender;

@Service("lenderService")
public class LenderServiceImpl implements LenderService{

	@Autowired
	LenderDAO lenderDAO;


	@Transactional
	public void persistLender(Lender lender) {
		lenderDAO.persistLender(lender);

	}

	@Transactional
	public void updateLender(Lender lender) {
		lenderDAO.updateLender(lender);

	}

	@Transactional
	public Lender findLenderById(BigInteger id) {
		return lenderDAO.findLenderById(id);
	}

	@Transactional
	public void deleteLender(Lender lender) {
		lenderDAO.deleteLender(lender);

	}

}
