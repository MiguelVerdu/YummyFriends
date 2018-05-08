package com.yummy.friends.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ciudad {
	@Id
//	@Column(name="idCiudad")
	private Integer idCiudad;
	
//	@Column(name="nombreCiudad")
	private String nombreCiudad;
}
