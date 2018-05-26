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

	
}
