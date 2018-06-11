package com.yummy.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.friends.domain.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("select p.foto from Producto p where p.idProducto =?1")
	public String obtenerFoto(Integer id);

	@Query("select max(idProducto) + 1 from Producto")
	public Integer getMaxId();

	@Modifying
	@Transactional
	@Query("update Producto set nombre = ?1, descricion = ?2 where idProducto = ?3")
	public void actualizarTituloDesc(String titulo, String desc, Integer idProducto);
//	@Query("select p.foto from Venta v inner join Producto where v.idVenta = 1")
//	public String obtenerFotoVenta(Integer idVenta);
}
