package com.test.secret.repository;

import com.test.secret.model.Device;
import com.test.secret.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DeviceRepository extends CrudRepository<Device, UUID>, DeviceRepositoryCustom {

		List<Device> getAllByOwner(User user);
 }
