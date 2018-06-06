package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yummy.friends.domain.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

//	public List<String> findTop2ByidCompradorOrderBycomentariosAsc(Integer idComprador);
	
	@Query("select c.comentarios from Compra c where  c.comprador.idUsuario = ?1 order by c.valoracion desc")
	public List<String> obtComentarios(Integer idComprador);
	
//	public List<String> findTop2ByIdCompradorOrderByValoracion(Integer idComprador);
	
	@Query(value="select avg(valoracion) from Compra c where c.comprador.idUsuario = ?1 group by c.comprador.idUsuario")
	public Float obtVal(Integer idUsuario);

}
