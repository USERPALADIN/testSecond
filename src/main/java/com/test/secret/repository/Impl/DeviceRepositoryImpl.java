package com.test.secret.repository.Impl;

import com.test.secret.model.Device;
import com.test.secret.model.User;
import com.test.secret.repository.DeviceRepository;
import com.test.secret.repository.DeviceRepositoryCustom;
import com.test.secret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeviceRepositoryImpl implements DeviceRepositoryCustom {
	
	
	private final EntityManager entityManager;
	private final UserRepository userRepository;
	
	@Value("5")
	private int count;
	
	@Autowired
	public DeviceRepositoryImpl(EntityManager entityManager, UserRepository userRepository) {
		this.entityManager = entityManager;
		this.userRepository = userRepository;
	}
	
	
	@Override
	public List<Device> getLimitedDevices() {
		Query query = entityManager.createQuery("SELECT device FROM  Device device ORDER BY  date DESC");
		query.setFirstResult(0);
		query.setMaxResults(count);
		List<Device> deviceList = query.getResultList();
		return deviceList;
	}
	
	@Override
	public Map<String,Long> getLimitedUsers() {
		
		Query query = entityManager.createQuery("SELECT device.owner.login FROM  Device device GROUP BY device.owner.login  ORDER BY COUNT(device.owner.login) DESC ");
		query.setFirstResult(0);
		query.setMaxResults(count);
		
		List<String> list = query.getResultList();
		
		Map<String, Long  >  map = new LinkedHashMap<>();
		
		for (int i = 0; i < list.size(); i++) {
			Long  countDev = entityManager.createQuery("SELECT count(*) FROM Device device WHERE device.owner.login =:login", Long.class)
					.setParameter("login",list.get(i)).getSingleResult();
			map.put(list.get(i), countDev );
		}
		return map;
	}
}
