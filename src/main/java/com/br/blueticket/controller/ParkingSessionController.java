package com.br.blueticket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.blueticket.domain.model.ParkingSession;
import com.br.blueticket.repository.ParkingSessionRepository;
import com.br.blueticket.service.ParkingSessionService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/parking_session")
public class ParkingSessionController {

	@Autowired 
	private ParkingSessionRepository parkingSessionRepository;
	
	@Autowired
	private ParkingSessionService parkingSessionService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_PARKING_SESSION') and #oauth2.hasScope('write')")
	public ParkingSession create(@Valid @RequestBody ParkingSession parkingSession, HttpServletResponse response ) {
		return parkingSessionService.create(parkingSession);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PARKING_SESSION') and #oauth2.hasScope('write')")
	public List<ParkingSession> read(){
		return parkingSessionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PARKING_SESSION') and #oauth2.hasScope('write')")
	public ResponseEntity<ParkingSession> findById(@PathVariable Long id){
		Optional<ParkingSession> parkingSession = parkingSessionRepository.findById(id);
		if(parkingSession.isPresent()) {
			return ResponseEntity.ok(parkingSession.get());
		}
		return ResponseEntity.notFound().build();
	}	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_PARKING_SESSION') and #oauth2.hasScope('write')")
	public ResponseEntity<ParkingSession> update(@PathVariable Long id, @Valid @RequestBody ParkingSession parkingSession){
		ParkingSession parkingSessionSaved = parkingSessionService.update(id, parkingSession);
		return ResponseEntity.ok(parkingSessionSaved);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_PARKING_SESSION') and #oauth2.hasScope('write')")
	public void remove(@PathVariable Long id) {
		parkingSessionRepository.deleteById(id);
	}
	
}
