package com.br.blueticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.blueticket.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByMail(String mail);
}
