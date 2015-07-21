package com.mfhsapp.test.dao;

import java.math.BigInteger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mfhsapp.test.model.Lender;


@Repository("lenderDAO")
public class LenderDAOImpl implements LenderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void persistLender(Lender lender) {
		sessionFactory.getCurrentSession().persist(lender);
	}

	public Lender findLenderById(BigInteger id) {
		return (Lender) sessionFactory.getCurrentSession().get(Lender.class, id);
	}

	public void updateLender(Lender lender) {
		sessionFactory.getCurrentSession().update(lender);

	}

	public void deleteLender(Lender lender) {
		sessionFactory.getCurrentSession().delete(lender);

	}


}
