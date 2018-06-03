package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yummy.friends.domain.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{

	@Query("select v from Venta v where v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()")
	public List<Venta> ventasHome();

}
