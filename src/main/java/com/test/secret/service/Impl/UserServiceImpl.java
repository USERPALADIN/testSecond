package com.test.secret.service.Impl;

import com.test.secret.model.User;
import com.test.secret.repository.UserRepository;
import com.test.secret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private  PasswordEncoder passwordEncoder;
	private UserRepository userRepository;

	@Override
	public User getByLogin(String login) {
		return  userRepository.getByLogin(login);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> getById(long id) {
		return  userRepository.findById(id);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
