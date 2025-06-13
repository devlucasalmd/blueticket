package com.br.blueticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.blueticket.domain.model.Street;

public interface StreetRepository extends JpaRepository<Street, Long>{

}
