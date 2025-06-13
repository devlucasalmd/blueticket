package com.br.blueticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.blueticket.domain.model.Inspector;

public interface InspectorRepository extends JpaRepository<Inspector, Long> {

}
