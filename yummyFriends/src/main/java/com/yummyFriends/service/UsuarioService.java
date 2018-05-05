package com.yummyFriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummyFriends.domain.Usuario;
import com.yummyFriends.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	public void crearUsuario(Usuario u) {
		this.usuarioRepository.save(u);
	}
}
