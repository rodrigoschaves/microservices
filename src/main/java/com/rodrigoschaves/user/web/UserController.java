package com.rodrigoschaves.user.web;

import com.rodrigoschaves.user.domain.User;
import com.rodrigoschaves.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by rodrigo on 04/01/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> list() {
		List<User> users = service.list();
		for (User user : users) {
			Link selfLink = linkTo(UserController.class).slash(user.getUserId()).withSelfRel();
			user.add(selfLink);
		}
		return users;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void importData(@RequestBody List<User> users) {
		service.importData(users);
	}
}
