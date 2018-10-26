package com.test.secret.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "devices")
public class Device {
	
	@Id
	@GeneratedValue
	@Column(name = "device_id")
	private UUID uuid;
	
	@Column(name = "serialNo", nullable = false)
	private String serialNo;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "date")
	private LocalDateTime date;
	
	@OneToOne
	private User owner;
	
	
	public Device(String serialNo, String type, String description, User owner) {
		this.serialNo = serialNo;
		this.type = type;
		this.description = description;
		this.owner = owner;
		date = LocalDateTime.now();
	}
	
	
	public Device() {
	
	}
	
	public String getSerialNo() {
		return serialNo;
	}
	
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
