package com.mfhsapp.test.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfhsapp.test.dao.UserDAO;
import com.mfhsapp.test.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;


	@Transactional
	public void persistUser(User user) {
		userDAO.persistUser(user);

	}

	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);

	}

	@Transactional
	public User findUserById(BigInteger id) {
		return userDAO.findUserById(id);
	}

	@Transactional
	public void deleteUser(User user) {
		userDAO.deleteUser(user);

	}

}
