package com.mfhsapp.test.dao;

import java.math.BigInteger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mfhsapp.test.model.LoanTemplate;


@Repository("loanTemplateDAO")
public class LoanTemplateDAOImpl implements LoanTemplateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void persistCriteria(LoanTemplate loanTemplate) {
		sessionFactory.getCurrentSession().persist(loanTemplate);
	}

	public LoanTemplate findCriteriaById(BigInteger id) {
		return (LoanTemplate) sessionFactory.getCurrentSession().get(LoanTemplate.class, id);
	}

	public void updateCriteria(LoanTemplate loanTemplate) {
		sessionFactory.getCurrentSession().update(loanTemplate);

	}

	public void deleteCriteria(LoanTemplate loanTemplate) {
		sessionFactory.getCurrentSession().delete(loanTemplate);

	}


}
