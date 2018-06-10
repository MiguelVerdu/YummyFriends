package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Modifying
	@Transactional
	@Query("update Usuario set password = ?1 where mail = ?2")
	public void actualizarPass(String pass, String email);
	
	@Modifying
	@Transactional
	@Query("update Usuario set fotoPerfil = ?1 where idUsuario = ?2")
	public void actualizarFoto(String token, Integer idUsuario);
	
	@Query("select u.fotoPerfil from Usuario u where u.idUsuario =?1")
	public String obtenerFoto(Integer id);
	
	@Query("select u.nombre from Usuario u inner join u.ventas v where  v.idVenta = ?1")
	public String obtenerVendedor(Integer idVenta);

}
