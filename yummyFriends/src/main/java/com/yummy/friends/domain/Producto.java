package com.yummy.friends.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
	
	@Id
	public Integer idProducto;
	
	public String nombre;
	
	public String descripcion;
	
	public String foto; 
	
	public Integer idUsuario;
}
