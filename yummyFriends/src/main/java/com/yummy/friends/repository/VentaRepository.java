package com.yummy.friends.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yummy.friends.domain.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{
	
	
	@Query("select v from Venta v where v.idVenta = ?1")
	Venta findVentaById(Integer id);

//	@Query("select v.idVenta, v.rangoHoraDisponibleMin, v.rangoHorarioDisponibleMax, v.idProducto, v.descripcion, v.valoracion, " + 
//	" v.cantidad, v.precio from Venta v where v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()")
	@Query("select v from Venta v where v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()")
	public List<Venta> ventasHome();

}
