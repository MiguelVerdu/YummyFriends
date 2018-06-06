package com.yummy.friends.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioClass {

	private Integer idUsuario;

	private String nombre;

	private String apellidos;

	private Date fechaNac;

	private Integer idCiudad;
	private Integer idCodPostal;

	private String password;

	private String tipoPerfil;

	private String fotoPerfil;

	private String mail;

	public UsuarioClass(Integer idUsuario, String nombre, String apellidos, Date fechaNac, Integer idCiudad,
			Integer idCodPostal, String password, String tipoPerfil, String fotoPerfil, String mail) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.idCiudad = idCiudad;
		this.idCodPostal = idCodPostal;
		this.password = password;
		this.tipoPerfil = tipoPerfil;
		this.fotoPerfil = fotoPerfil;
		this.mail = mail;
	}

}
