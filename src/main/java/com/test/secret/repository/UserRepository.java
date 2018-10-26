package com.test.secret.repository;

import com.test.secret.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User getByLogin(String login);
	
}
