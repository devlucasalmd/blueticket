package com.br.blueticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.blueticket.domain.model.Vehicle;
import com.br.blueticket.repository.VehicleRepository;
import com.br.blueticket.service.VehicleService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_VEHICLE') and #oauth2.hasScope('write')")
	public Vehicle create(@Valid @RequestBody Vehicle vehicle, HttpServletResponse response) {
		return vehicleRepository.save(vehicle);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_VEHICLE') and #oauth2.hasScope('write')")
	public List<Vehicle> read(){
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_VEHICLE') and #oauth2.hasScope('write')")
	public ResponseEntity<Vehicle> findById(@PathVariable Long id){
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		
		if(vehicle.isPresent()) {
			return ResponseEntity.ok(vehicle.get());			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_VEHICLE') and #oauth2.hasScope('write')")
	public ResponseEntity<Vehicle> update(@PathVariable Long id, @Valid @RequestBody Vehicle vehicle){
		Vehicle vehicleSaved = vehicleService.update(id, vehicle);
		return ResponseEntity.ok(vehicleSaved);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REMOVE_VEHICLE') and #oauth2.hasScope('write')")

	public void remove(@PathVariable Long id) {
		vehicleRepository.deleteById(id);
	}
	
	@GetMapping("/user/{email}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and #oauth2.hasScope('read')")
	public ResponseEntity<List<Vehicle>> listByUser(@PathVariable String mail){
		List<Vehicle> vehicle = vehicleService.listByUser(mail);
		if(!vehicle.isEmpty()) {
			return ResponseEntity.ok(vehicle);
		}
		return ResponseEntity.notFound().build();
	}
	
}
