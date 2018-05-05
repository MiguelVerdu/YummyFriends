package com.yummyFriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummyFriends.domain.Usuario;
import com.yummyFriends.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/crearEncuentro")
	public void crearEncuentro(@RequestBody Usuario u) {
		this.usuarioService.crearUsuario(u);
	}
}
