package com.yummy.friends.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venta {

	@Id
	private Integer idVenta;

	@OneToMany(mappedBy = "idCompra")
	private List<Compra> compras;
	
	@ManyToOne
	@JoinColumn(name="idVendedor")
	private Usuario vendedor;
//	private Integer idVendedor;

	private Date fechaCreacion;

	private Date rangoHoraDisponibleMin;

	private Date rangoHorarioDisponibleMax;

	private Integer idProducto;

	private String descripcion;

	private Float valoracion;
	private Integer cantidad;

	private Float precio;

}
