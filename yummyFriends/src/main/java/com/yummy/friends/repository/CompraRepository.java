package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.friends.domain.Compra;
import com.yummy.friends.domain.Venta;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

//	public List<String> findTop2ByidCompradorOrderBycomentariosAsc(Integer idComprador);
	
	@Query("select c.comentarios from Compra c where  c.comprador.idUsuario = ?1 order by c.valoracion desc")
	public List<String> obtComentarios(Integer idComprador);
	
//	public List<String> findTop2ByIdCompradorOrderByValoracion(Integer idComprador);
	
	@Query(value="select avg(valoracion) from Compra c where c.comprador.idUsuario = ?1 group by c.comprador.idUsuario")
	public Float obtVal(Integer idUsuario);
	
	@Query("select sum(v.precio * c.cantidadProducto) as total from Compra c inner join c.venta v where v.idVenta = ?1")
	public Float totalVenta(Integer idVenta);

	@Query("select max(idCompra) + 1 from Compra")
	public Integer getMaxID();

//	@Query("select v from Venta v where v.rangoHoraDisponibleMin <= now() and v.rangoHorarioDisponibleMax >= now()" + 
//			" and v.titulo like %:busqueda%")
	@Query("select c from Compra c where estado = ?1")
	public List<Compra> obtenerCompras(String tipo);

	@Query("select v from Compra c inner join c.venta v where c.idCompra = ?1")
	public Venta getInfoVenta(Integer idCompra);

	@Modifying
	@Transactional
	@Query("update Compra set estado = 'finalizada' where idCompra = ?1")
	public void actualizarCompra(Integer idCompra);
}
