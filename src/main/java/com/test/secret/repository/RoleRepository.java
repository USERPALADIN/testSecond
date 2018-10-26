package com.test.secret.repository;

import com.test.secret.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
	
	Role getByName(String role);
	
}
