package com.test.secret.controller;

import com.test.secret.model.Device;
import com.test.secret.model.User;
import com.test.secret.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/registry")
public class DeviceController {
	
	private final DeviceService deviceService;
	
	@Autowired
	public DeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	@PreAuthorize("hasAnyAuthority('USER')")
	@GetMapping(value = "/devices/add")
	public String getRegistry() {
		return "addDevice";
	}
	
	@PreAuthorize("hasAnyAuthority('USER')")
	@PostMapping(value = "/devices/add")
	public String postRegistry(@RequestParam String serialNo, @RequestParam String type,
							   @RequestParam String description) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Device device = new Device(serialNo, type, description, user);
		deviceService.saveDevice(device);
		return "redirect:/registry/devices";
	}
	
	@PreAuthorize("hasAnyAuthority('USER')")
	@GetMapping(value = "/devices")
	public String getDevices(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("devices", deviceService.getAllDeviceByOwner(user));
		return "all_devices";
	}
	
	
	@GetMapping(value = "/stats")
	public String getStats(Model model) {
		model.addAttribute("devices", deviceService.getLimitedDevices());
		model.addAttribute("users", deviceService.getLimitedUsers());
		return "limited_devices";
	}
}
