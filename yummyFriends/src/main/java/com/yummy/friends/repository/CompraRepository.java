package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yummy.friends.domain.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

//	public List<String> findTop2ByidCompradorOrderBycomentariosAsc(Integer idComprador);
	
	@Query("select c.comentarios from Compra c inner join c.idVendedor v where v.idVendedor = ?1 order by c.valoracion desc")
	public List<String> obtComentarios(Integer idComprador);
	
	public List<String> findTop2ByIdCompradorOrderByValoracion(Integer idComprador);
	
	@Query("select avg(valoracion) from Compra c where c.idComprador = ?1"
			+ " group by c.idComprador")
	public Float obtVal(Integer idUsuario);

}
