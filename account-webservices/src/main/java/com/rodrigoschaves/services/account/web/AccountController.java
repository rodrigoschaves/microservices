package com.rodrigoschaves.services.account.web;

import com.rodrigoschaves.services.account.domain.Account;
import com.rodrigoschaves.services.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by rodrigo on 04/01/2017.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Account> list() {
		List<Account> accounts = service.list();
		for (Account account : accounts) {
			Link selfLink = linkTo(AccountController.class).slash(account.getAccountId()).withSelfRel();
			account.add(selfLink);
		}
		return accounts;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{accountId}")
	public Account userById(@PathVariable("accountId") String id) {
		return service.findOne(id);
	}

	public List<Account> search(@RequestHeader("userId") String userId) {
		return service.findByUser(userId);
	}
}
