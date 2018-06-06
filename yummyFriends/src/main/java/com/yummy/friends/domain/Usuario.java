package com.yummy.friends.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

	// @JsonManagedReference
	@OneToMany(mappedBy = "comprador", fetch = FetchType.EAGER)
	// @LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Compra> compras;

	// @JsonManagedReference
	@OneToMany(mappedBy = "vendedor", fetch = FetchType.EAGER)
	// @LazyCollection(LazyCollectionOption.FALSE)
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Venta> ventas;

}
