package com.yummy.friends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummy.friends.domain.Usuario;
import com.yummy.friends.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	public UsuarioRepository usuarioRepository;

	public void crearUsuario(Usuario u) {
		this.usuarioRepository.save(u);
	}

	public String login(String pass, String email) {
		return this.usuarioRepository.login(pass, email);
	}

	public List<Usuario> getUsuarios() {
		return this.usuarioRepository.findAll();
	}

	public String recuperPass(String email) {
		return this.usuarioRepository.recuperarPass(email);
	}

	public String validarUsuario(String email) {
		return this.usuarioRepository.validarUsuario(email);
	}

	public Usuario getUsuario(Integer idUsuario) {
		return this.usuarioRepository.findByidUsuario(idUsuario);
	}

	public Float obtVal(Integer idUsuario) {
		return this.usuarioRepository.obtVal(idUsuario);
	}

	public Usuario actualizarUsuario(Usuario u) {
//		return this.usuarioRepository.actualizarUsuario(u);
		return this.usuarioRepository.save(u);
	}
	
	public Boolean exists(Usuario u) {
		return this.usuarioRepository.existsById(u.getIdUsuario());
	}

}
