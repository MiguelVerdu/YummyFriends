package com.yummy.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummy.friends.domain.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	
}
