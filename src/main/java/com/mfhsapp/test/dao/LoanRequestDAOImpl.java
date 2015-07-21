package com.mfhsapp.test.dao;

import java.math.BigInteger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mfhsapp.test.model.LoanRequest;


@Repository("loanRequestDAO")
public class LoanRequestDAOImpl implements LoanRequestDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void persistLoanRequest(LoanRequest loanRequest) {
		sessionFactory.getCurrentSession().persist(loanRequest);
	}

	public LoanRequest findLoanRequestById(BigInteger id) {
		return (LoanRequest) sessionFactory.getCurrentSession().get(LoanRequest.class, id);
	}

	public void updateLoanRequest(LoanRequest loanRequest) {
		sessionFactory.getCurrentSession().update(loanRequest);

	}

	public void deleteLoanRequest(LoanRequest loanRequest) {
		sessionFactory.getCurrentSession().delete(loanRequest);

	}


}
