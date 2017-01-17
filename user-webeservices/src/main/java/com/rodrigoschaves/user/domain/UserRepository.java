package com.rodrigoschaves.user.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rodrigo on 04/01/2017.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByUserId(String userId);
}
