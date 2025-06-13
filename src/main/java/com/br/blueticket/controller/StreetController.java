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

import com.br.blueticket.domain.model.Street;
import com.br.blueticket.repository.StreetRepository;
import com.br.blueticket.service.StreetService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/street")
public class StreetController {
	
	@Autowired
	private StreetRepository streetRepository;
	
	@Autowired
	private StreetService streetService;

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_STREET') and #oauth2.hasScope('write')")
	public Street create(@Valid @RequestBody Street street, HttpServletResponse response) {
		return streetRepository.save(street);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_STREET') and #oauth2.hasScope('write')")
	public List<Street> read(){
		return streetRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_STREET') and #oauth2.hasScope('write')")
	public ResponseEntity<Street> findById(@PathVariable Long id){
		Optional<Street> street = streetRepository.findById(id);
		if(street.isPresent()) {
			return ResponseEntity.ok(street.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_STREET') and #oauth2.hasScope('write')")
	public ResponseEntity<Street> update(@PathVariable Long id, @Valid @RequestBody Street street){
		Street streetSaved = streetService.update(id, street);
		return ResponseEntity.ok(streetSaved);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_STREET') and #oauth2.hasScope('write')")
	public void remove(@PathVariable Long id) {
		streetRepository.deleteById(id);
	}
}
