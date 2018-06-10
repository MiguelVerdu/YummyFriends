package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yummy.friends.domain.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{
	
	
	@Query("select v from Venta v where v.idVenta = ?1")
	Venta findVentaById(Integer id);

//	@Query("select v.idVenta, v.rangoHoraDisponibleMin, v.rangoHorarioDisponibleMax, v.idProducto, v.descripcion, v.valoracion, " + 
//	" v.cantidad, v.precio from Venta v where v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()")
	@Query("select v from Venta v where v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()")
	public List<Venta> ventasHome();

	@Query("select v from Venta v where v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()" + 
	" and v.titulo like %:busqueda%")
	public List<Venta> filtrarVentas(@Param("busqueda") String busqueda);
	
	@Query("select v from Venta v where v.vendedor.idUsuario = ?1 and v.rangoHorarioDisponibleMax < now()")
	public List<Venta> ventasRealizadas(Integer idUsuario);
	
	@Query("select v from Venta v where v.vendedor.idUsuario = ?1 and v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()")
	public List<Venta> ventasEnPublicacion(Integer idUsuario);

}
