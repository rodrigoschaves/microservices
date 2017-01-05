package com.rodrigoschaves.services.transaction.service;

import com.rodrigoschaves.services.transaction.domain.Transaction;
import com.rodrigoschaves.services.transaction.domain.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rodrigo on 04/01/2017.
 */
@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;

	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}

	public List<Transaction> list() {
		return this.repository.findAll();
	}

	public Transaction findOne(String id){
		return this.repository.findOne(id);
	}

	public void importData(List<Transaction> users) {
		this.repository.insert(users);
	}
}
