package com.yummy.friends.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Compra {

	@Id
	private Integer idCompra;
	
	@ManyToOne
	@JoinColumn(name = "idVenta")
	@JsonIgnore
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "idComprador")
	@JsonIgnore
	private Usuario comprador;
	
	private Integer cantidadProducto;
	
	private Date fechaHora;
	
	private Integer valoracion;
	
	private String comentarios;
	
	private String estado;
	
}
