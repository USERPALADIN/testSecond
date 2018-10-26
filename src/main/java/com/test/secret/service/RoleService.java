package com.test.secret.service;

import com.test.secret.model.Role;
import java.util.List;

public interface RoleService {

	Role getByName(String role);

	List<Role> getAllRoles();

	void saveRole(Role role);
}
