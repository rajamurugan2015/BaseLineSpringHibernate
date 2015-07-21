package com.mfhsapp.test.dao;

import java.math.BigInteger;

import com.mfhsapp.test.model.User;

public interface UserDAO {
	public void persistUser(User user);
	public User findUserById(BigInteger id);
	public void updateUser(User user);
	public void deleteUser(User user);
}

