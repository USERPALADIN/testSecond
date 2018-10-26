package com.test.secret.service.Impl;

import com.test.secret.model.Role;
import com.test.secret.repository.RoleRepository;
import com.test.secret.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role getByName(String role) {
		return roleRepository.getByName(role);
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roles = (List<Role>) roleRepository.findAll();
		return  roles;
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
}
