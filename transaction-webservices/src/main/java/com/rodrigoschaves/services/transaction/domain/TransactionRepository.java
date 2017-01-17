package com.rodrigoschaves.services.transaction.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rodrigo on 04/01/2017.
 */
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
	List<Transaction> findByAccountId(String accountId);
}
