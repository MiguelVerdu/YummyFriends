package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yummy.friends.domain.Ciudad;
import com.yummy.friends.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("select c from Ciudad c")
	public List<Ciudad> getCiudades();

	@Query("select case count(*) when 1 then '{\"ok\":\"ok\"}' end " + 
			"from Usuario u " + 
			"where u.mail = ?1")
	public String recuperarPass(String email);

	@Query("select concat('{\"idUsuario\":\"',u.idUsuario,'\"}')" + 
			"from Usuario u " + 
			"where u.password =?1 and u.mail =?2")
	public String login(String pass, String email);

	@Query("select case count(*) " +
			"when 0 then (select concat('{\"idUsuario\":\"',max(usua.idUsuario)+1,'\"}') from Usuario usua) end " + 
			"from Usuario u " + 
			"where u.mail = ?1")
	public String validarUsuario(String email);

	public Usuario findByidUsuario(Integer idUsuario);

	@Query("select avg(valoracion) from Compra c where c.idComprador = ?1"
			+ " group by c.idComprador")
//	@Query("select idUsuario from Usuario where idUsuario = ?1")
	public Float obtVal(Integer idUsuario);

	
//	public Boolean actualizarUsuario(Usuario u);

	
}
