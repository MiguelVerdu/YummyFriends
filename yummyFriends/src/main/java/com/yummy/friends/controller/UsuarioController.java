package com.yummy.friends.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yummy.friends.domain.Producto;
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
	
	@PostMapping(value = "/createUsuario")
	public String create(@RequestPart("usuario") String usuarioStr,
			@RequestPart(name = "file", required = false) MultipartFile file) throws IOException {
		System.out.println(usuarioStr);
		Usuario usuario;
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		usuario = om.readValue(usuarioStr, Usuario.class);
		this.usuarioService.create(usuario, file);

		return "OK";
	}

	@GetMapping(value = "/recogerUsuario/{idUsuario}")
	public ResponseEntity<InputStreamResource> getFile(@PathVariable("idUsuario") Integer idUsuario)
			throws FileNotFoundException, IOException {

		String uuid = this.usuarioService.obtenerFoto(idUsuario);
		
		File file = new File("C:/Users/migue/Pictures/" + uuid);

		InputStream targetStream = new FileInputStream(file);

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
				.contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(targetStream));

	}
	
	@GetMapping(value="/fotoUsuario/{id}")
	public String obtenerFoto(@PathVariable Integer id) {
		String foto = "{\"foto\" : \""+this.usuarioService.obtenerFoto(id)+"\"}";
		return foto;
//		return this.productoService.obtenerFoto(id);
	}
	
	@GetMapping("/obtenerVendedor/{idVenta}")
	public String obtenerVendedor(@PathVariable Integer idVenta) {
		String vendedor = "{\"vendedor\" : \""+this.usuarioService.obtenerVendedor(idVenta)+"\"}";
		return vendedor;
	}
}
