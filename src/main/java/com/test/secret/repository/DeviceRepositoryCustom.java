package com.test.secret.repository;

import com.test.secret.model.Device;
import com.test.secret.model.User;

import java.util.List;
import java.util.Map;

public interface DeviceRepositoryCustom {
	
	 List<Device> getLimitedDevices();
	
	  Map<String,Long> getLimitedUsers();
	
}
