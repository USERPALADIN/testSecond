package com.test.secret.service.Impl;

import com.test.secret.model.Device;
import com.test.secret.model.User;
import com.test.secret.repository.DeviceRepository;
import com.test.secret.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
	
	private final DeviceRepository deviceRepository;
	
	@Autowired
	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}
	
	@Override
	public Device getByLogin(String login) {
		return null;
	}
	
	@Override
	public void saveDevice(Device device) {
			deviceRepository.save(device);
	}
	
	@Override
	public List<Device> getAllDeviceByOwner(User user) {
		return deviceRepository.getAllByOwner(user);
	}
	
	
	@Override
	public void deleteDevice(long id) {
	
	}
	
	@Override
	public Optional<Device> getById(long id) {
		return Optional.empty();
	}
	
	@Override
	public void updateDevice(Device device) {
			deviceRepository.save(device);
	}
	
	@Override
	public List<Device> getLimitedDevices() {
		return deviceRepository.getLimitedDevices();
	}
	
	@Override
	public Map<String,Long> getLimitedUsers() {
		return deviceRepository.getLimitedUsers();
	}
}
