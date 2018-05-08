package com.yummy.friends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.domain.Usuario;
import com.yummy.friends.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	@PostMapping("/crearUsuario")
	public void crearEncuentro(@RequestBody Usuario u) {
		this.usuarioService.crearUsuario(u);
	}

}
