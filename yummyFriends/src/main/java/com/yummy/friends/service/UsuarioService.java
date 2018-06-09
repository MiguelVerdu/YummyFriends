package com.yummy.friends.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yummy.friends.domain.Producto;
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

	public Usuario actualizarUsuario(Usuario u) {
		return this.usuarioRepository.save(u);
	}

	public Boolean exists(Usuario u) {
		return this.usuarioRepository.existsById(u.getIdUsuario());
	}

	public void create(Usuario u, MultipartFile file) throws IOException {

		String token = UUID.randomUUID().toString();

		File targetFile = new File("C:/Users/migue/Pictures/" + token);

		java.nio.file.Files.copy(file.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		IOUtils.closeQuietly(file.getInputStream());

		u.setFotoPerfil(token);

		this.usuarioRepository.save(u);

	}

	public String obtenerFoto(Integer id) {
		return this.usuarioRepository.obtenerFoto(id);
	}

}
