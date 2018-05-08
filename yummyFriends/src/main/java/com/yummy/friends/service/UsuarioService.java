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

}
