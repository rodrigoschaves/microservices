package com.rodrigoschaves.services.transaction.web;

import com.rodrigoschaves.services.transaction.domain.Transaction;
import com.rodrigoschaves.services.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by rodrigo on 04/01/2017.
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Transaction> list() {
		List<Transaction> transactions = service.list();
		for (Transaction transaction : transactions) {
			Link selfLink = linkTo(TransactionController.class).slash(transaction.getTransactionId()).withSelfRel();
			transaction.add(selfLink);
		}
		return transactions;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{transactionId}")
	public Transaction userById(@PathVariable("transactionId") String id) {
		return service.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search")
	public List<Transaction> search(@RequestHeader("accountId") String id) {
		return service.findByAccount(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void importData(@RequestBody List<Transaction> transactions) {
		service.importData(transactions);
	}
}
