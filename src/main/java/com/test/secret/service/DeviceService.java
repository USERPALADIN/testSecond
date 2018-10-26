package com.test.secret.service;

import com.test.secret.model.Device;
import com.test.secret.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DeviceService {
	
	Device getByLogin(String login);
	
	void saveDevice(Device device);
	
	List<Device> getAllDeviceByOwner(User user);
	
	void deleteDevice(long id);
	
	Optional<Device> getById(long id);
	
	void updateDevice(Device device);
	
	List<Device> getLimitedDevices();
	
	Map<String, Long> getLimitedUsers();
	
	
}
