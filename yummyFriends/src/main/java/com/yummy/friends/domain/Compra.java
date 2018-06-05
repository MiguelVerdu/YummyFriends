package com.yummy.friends.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Compra {
	@Id
	private Integer idCompra;
	
	private Venta idVenta;
	private Usuario idComprador;
	private Integer cantidadProducto;
	private Date fechaHora;
	private Integer valoracion;
	private String comentarios;
}
