package com.mfhsapp.test.service;

import java.math.BigInteger;

import com.mfhsapp.test.model.User;

public interface UserService {
	void persistUser(User user);

	User findUserById(BigInteger id);

	void updateUser(User user);

	void deleteUser(User user);
}
