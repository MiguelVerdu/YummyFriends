package com.yummy.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummy.friends.domain.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
