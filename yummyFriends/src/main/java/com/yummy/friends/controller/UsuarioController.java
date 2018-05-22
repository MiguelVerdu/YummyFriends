package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.domain.Usuario;
import com.yummy.friends.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	@PostMapping("/crearUsuario")
	public void crearEncuentro(@RequestBody Usuario u) {
		this.usuarioService.crearUsuario(u);
	}
	
	@PostMapping("/login/{Usuario}")
	public void login(@RequestBody Usuario u) {
		this.usuarioService.login(u.getPassword(), u.getMail());
	}
	
	@GetMapping("/getUsuarios")
	public List<Usuario> getUsuarios(){
		return this.usuarioService.getUsuarios();
	}
	
	@PostMapping("/recuperarPass")
	public String recuperarPass(@RequestBody Usuario u) {
		return this.usuarioService.recuperPass(u.getMail());
	}

}
