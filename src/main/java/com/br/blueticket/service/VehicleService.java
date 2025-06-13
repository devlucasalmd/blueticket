package com.br.blueticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.blueticket.domain.model.User;
import com.br.blueticket.domain.model.Vehicle;
import com.br.blueticket.repository.UserRepository;
import com.br.blueticket.repository.VehicleRepository;


@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Vehicle update(Long id, Vehicle vehicle) {
		Vehicle vehicleSaved = findVehicleById(id);
		BeanUtils.copyProperties(vehicle, vehicleSaved, "id");
		return vehicleRepository.save(vehicleSaved);
	}
	
	public Vehicle findVehicleById(Long id) {
		Vehicle vehicleSaved = vehicleRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return vehicleSaved;
	}
	
	public List<Vehicle> listByUser(String mail){
		Optional<User> user = userRepository.findByMail(mail);
		if(user.isPresent()) {
			return vehicleRepository.findByUser(user.get());
		}
		return null;
	}
}
