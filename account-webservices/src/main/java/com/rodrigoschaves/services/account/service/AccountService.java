package com.rodrigoschaves.services.account.service;

import com.rodrigoschaves.services.account.domain.Account;
import com.rodrigoschaves.services.account.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rodrigo on 04/01/2017.
 */
@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	public List<Account> list() {
		return this.repository.findAll();
	}

	public Account findOne(String id) {

		return this.repository.findOne(id);
	}

	public void importData(List<Account> users) {
		this.repository.insert(users);
	}

	public List<Account> findByUser(String userId) {
		Account account = new Account();
		account.setUserId(userId);
		return this.repository.findAll(Example.of(account));
	}
}
