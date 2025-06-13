package com.br.blueticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.blueticket.domain.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
