package com.mfhsapp.test.dao;

import java.math.BigInteger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mfhsapp.test.model.User;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	public User findUserById(BigInteger id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);

	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);

	}


}
