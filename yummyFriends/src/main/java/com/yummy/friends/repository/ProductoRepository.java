package com.yummy.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yummy.friends.domain.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("select p.foto from Producto p where p.idProducto =?1")
	public String obtenerFoto(Integer id);

}
