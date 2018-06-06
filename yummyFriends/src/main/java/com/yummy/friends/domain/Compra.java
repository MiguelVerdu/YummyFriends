package com.yummy.friends.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Venta venta;
//	private Integer idVenta;
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idComprador")
	private Usuario comprador;
//	private Integer idComprador;
	private Integer cantidadProducto;
	
	private Date fechaHora;
	
	private Integer valoracion;
	
	private String comentarios;
	
}
