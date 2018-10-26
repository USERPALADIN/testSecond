package com.test.secret.service.Impl;

import com.test.secret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private  UserService userService;

	

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		UserDetails user = userService.getByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException("User" + login + " not found");
		}
		return user;
	}

}
