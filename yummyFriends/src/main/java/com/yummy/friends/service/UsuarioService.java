package com.yummy.friends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummy.friends.domain.Ciudad;
import com.yummy.friends.domain.Usuario;
import com.yummy.friends.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	public UsuarioRepository usuarioRepository;

	public void crearUsuario(Usuario u) {
		this.usuarioRepository.save(u);
	}

	public void login(String pass, String email) {

	}

	public List<Usuario> getUsuarios() {
		return this.usuarioRepository.findAll();
	}

	public String recuperPass(String email) {
		return this.usuarioRepository.recuperarPass(email);
	}

}
