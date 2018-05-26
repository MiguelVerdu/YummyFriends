package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@PostMapping("/login")
	public String login(@RequestBody Usuario u) {
		return this.usuarioService.login(u.getPassword(), u.getMail());
	}
	
	@GetMapping("/getUsuarios")
	public List<Usuario> getUsuarios(){
		return this.usuarioService.getUsuarios();
	}
	
//	@PostMapping("/recuperarPass", produces = MediaType.)
	@RequestMapping(value="/recuperarPass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String recuperarPass(@RequestBody String email) {
		return this.usuarioService.recuperPass(email);
	}

}
