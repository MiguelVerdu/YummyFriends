package com.yummy.friends.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
	@Id
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
	
	@OneToMany(mappedBy="idComprador")
	private List<Compra> compras;
	
	@OneToMany(mappedBy="idVendedor")
	private List<Venta> ventas;
}
