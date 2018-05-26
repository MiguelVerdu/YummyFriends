package com.yummy.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yummy.friends.domain.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

	@Query("select cp.idCodPostal from Ciudad c, CodPostal cp where c.idCiudad = cp.idCiudad and c.idCiudad = ?1")
	public Integer codPostal(Integer idCiudad);

}
