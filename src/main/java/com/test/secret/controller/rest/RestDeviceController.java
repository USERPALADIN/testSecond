package com.test.secret.controller.rest;

import com.test.secret.model.Device;
import com.test.secret.model.User;
import com.test.secret.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/registry/api/devices")
public class RestDeviceController {
	
	private final DeviceService deviceService;
	
	@Autowired
	public RestDeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	@PreAuthorize("hasAnyAuthority('USER')")
	@GetMapping
	public ResponseEntity  getDevices(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  List<Device> devices  = deviceService.getAllDeviceByOwner(user);
		  return  ResponseEntity.ok(devices);
	}
}
