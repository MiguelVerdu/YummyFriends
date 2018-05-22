package com.yummy.friends.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
	@Id
	public Integer idUsuario;
	
	public String nombre;
	
	public String apellidos;
	
	public Date fechaNac;
	
	public Integer idCiudad;
	public Integer idCodPostal;
	
	public String password;
	
	public Integer tipoPerfil;
	
	public String fotoPerfil;
	
	public String mail;
	
}
