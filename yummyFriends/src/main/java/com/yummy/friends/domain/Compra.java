package com.yummy.friends.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Compra {

	@Id
	public Integer idCompra;
	
	public Integer idVenta;
	
	public Integer idComprador;
	
	public Integer cantidadProducto;
	
	public Date fechaHora;
	
	public Integer valoracion;
	
	public String comentarios;
	
}
