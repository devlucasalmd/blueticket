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

import com.br.blueticket.domain.model.Inspector;
import com.br.blueticket.repository.InspectorRepository;
import com.br.blueticket.service.InspectorService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/inspector")
public class InspectorController {

	@Autowired
	public InspectorRepository inspectorRepository;
	
	@Autowired
	public InspectorService inspectorService;

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_REGISTER_INSPECTOR') and #oauth2.hasScope('write')")
	public Inspector create(@Valid @RequestBody Inspector inspector, HttpServletResponse response) {
		return inspectorRepository.save(inspector);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_INSPECTOR') and #oauth2.hasScope('write')")
	public List<Inspector> read() {
		return inspectorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_INSPECTOR') and #oauth2.hasScope('write')")
	public ResponseEntity<Inspector> findById(@PathVariable Long id){
		Optional<Inspector> inspector = inspectorRepository.findById(id);
		if(inspector.isPresent()) {
			return ResponseEntity.ok(inspector.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_INSPECTOR') and #oauth2.hasScope('write')")
	public ResponseEntity<Inspector> update(@PathVariable Long id, @Valid @RequestBody Inspector inspector){
		Inspector inspectorSaved = inspectorService.update(id, inspector);
		return ResponseEntity.ok(inspectorSaved);
	}
		
	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_INSPECTOR') and #oauth2.hasScope('write')")
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean active) {
		inspectorService.updateActiveProperty(id, active);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_INSPECTOR') and #oauth2.hasScope('write')")
	public void remove(@PathVariable Long id) {
		inspectorRepository.deleteById(id);
	}
}
