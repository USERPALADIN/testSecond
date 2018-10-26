package com.test.secret.service;


import com.test.secret.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

	User getByLogin(String login);

	void saveUser(User user);

	List<User>  getAllUsers();

	void deleteUser(long id);

	Optional<User> getById(long id);

	void updateUser(User user);
}
