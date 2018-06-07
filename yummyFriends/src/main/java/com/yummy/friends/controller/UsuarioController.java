package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.domain.Usuario;
import com.yummy.friends.service.Email;
import com.yummy.friends.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	private Email emailService;
	
	@GetMapping("/enviarEmail/{email}")
	public String enviarEmail(@PathVariable String email) {
		
		return this.emailService.sendSimpleMessage(email);
	}
	
	@PostMapping("/crearUsuario")
	public void crearUsuario(@RequestBody Usuario u) {
		this.usuarioService.crearUsuario(u);
	}
	
	@PostMapping("/validarUsuario")
	public String validarUsuario(@RequestBody String email) {
		return this.usuarioService.validarUsuario(email);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Usuario u) {
		return this.usuarioService.login(u.getPassword(), u.getMail());
	}
	
	@GetMapping("/getUsuarios")
	public List<Usuario> getUsuarios(){
		return this.usuarioService.getUsuarios();
	}
	
	@RequestMapping(value="/recuperarPass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String recuperarPass(@RequestBody String email) {
		return this.usuarioService.recuperPass(email);
	}
	
	@PostMapping("/recuperarPass2")
	public String recuperarPass2(@RequestBody Usuario u) {
		return this.usuarioService.recuperPass(u.getMail());
	}
	
	@GetMapping("/getUsuario/{idUsuario}")
	public Usuario getUsuario(@PathVariable Integer idUsuario) {
		return this.usuarioService.getUsuario(idUsuario);
	}
	
	@PutMapping("/actualizarUsuario/{idUsuario}")
	public Usuario actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario u) {
		if (u != null && this.usuarioService.exists(u)) {
			return this.usuarioService.actualizarUsuario(u);
		}
		return null;
	}

}
