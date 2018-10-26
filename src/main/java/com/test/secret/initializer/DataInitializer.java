package com.test.secret.initializer;


import com.test.secret.model.Device;
import com.test.secret.model.Role;
import com.test.secret.model.User;
import com.test.secret.service.DeviceService;
import com.test.secret.service.RoleService;
import com.test.secret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private DeviceService deviceService;
	

	public void init() {
		Role role1 = new Role("USER");
		roleService.saveRole(role1);
		
		List<Role> roleList = new ArrayList<>();
		roleList.add(role1);
		
		User user = new User("qwer", "qwer", "qwer",roleList);
		User user2 = new User("w", "w", "w",roleList);
		User user3 = new User("s", "s", "s", roleList);
		User user4 = new User("s", "s", "s", new ArrayList<>());
		
		userService.saveUser(user);
		userService.saveUser(user2);
		userService.saveUser(user3);
		
		Device device = new Device("first", "деталь", "как деталь", user3);
		Device device2 = new Device("second", "деталь", "как деталь", user2);
		Device device3 = new Device("3", "деталь", "как деталь", user);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Device device4 = new Device("4", "деталь", "как деталь", user);
		Device device5 = new Device("5", "деталь", "как деталь", user);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Device device6 = new Device("6", "деталь", "как деталь", user2);
		Device device7 = new Device("7", "деталь", "как деталь", user2);
		
		deviceService.saveDevice(device);
		deviceService.saveDevice(device2);
		deviceService.saveDevice(device3);
		deviceService.saveDevice(device4);
		deviceService.saveDevice(device5);
		deviceService.saveDevice(device6);
		deviceService.saveDevice(device7);
		
		
		
		
		
		
		
	}
}
