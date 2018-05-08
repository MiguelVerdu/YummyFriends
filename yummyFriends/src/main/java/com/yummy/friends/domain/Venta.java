package com.yummy.friends.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venta {

	@Id
	public Integer idVenta;

	public Integer idVendedor;

	public Date fechaCreacion;

	public Date rangoHoraDisponibleMin;

	public Date rangoHorarioDisponibleMax;

	public Integer idProducto;

	public String descripcion;

	public String valoracion;
	public Integer cantidad;

	public Float precio;

}
