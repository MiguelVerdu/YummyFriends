package com.yummy.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.friends.domain.Ciudad;
import com.yummy.friends.domain.Usuario;
import com.yummy.friends.domain.UsuarioClass;

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

	@Query("select new com.yummy.friends.domain.UsuarioClass(u.idUsuario, u.nombre, u.apellidos, u.fechaNac, u.idCiudad, u.idCodPostal, u.password, u.tipoPerfil, " +
	"u.fotoPerfil, u.mail) from Usuario u where u.idUsuario = ?1")
	public UsuarioClass findByidUsuario(Integer idUsuario);
	
//	@Override
	@Query("select new com.yummy.friends.domain.UsuarioClass(u.idUsuario, u.nombre, u.apellidos, u.fechaNac, u.idCiudad, u.idCodPostal, u.password, u.tipoPerfil, " +
			"u.fotoPerfil, u.mail) from Usuario u")
	public List<UsuarioClass> todos();
	
	@Modifying
	@Transactional
	@Query("update Usuario set password = ?1 where mail = ?2")
	public void actualizarPass(String pass, String email);
	//	@Query("select c.comentarios from Compra c where c.idComprador = ?1 order by fechaHora desc")
//	public List<String> obtComentarios(Integer idUsuario, Pageable pageable);

}
