package com.br.blueticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.blueticket.domain.model.User;
import com.br.blueticket.domain.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	public List<Vehicle> findByUser(User user);
}
