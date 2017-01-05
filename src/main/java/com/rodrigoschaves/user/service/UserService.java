package com.rodrigoschaves.user.service;

import com.rodrigoschaves.user.domain.User;
import com.rodrigoschaves.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rodrigo on 04/01/2017.
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> list() {
		return this.repository.findAll();
	}

	public void importData(List<User> users) {
		this.repository.insert(users);
	}
}
