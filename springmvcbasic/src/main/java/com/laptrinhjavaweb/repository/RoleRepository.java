package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    //RoleEntity findOneById(long id);
	RoleEntity findByCode(String code);
}
