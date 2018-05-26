package com.yummy.friends.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CodPostal {
	@Id
	private Integer idCodPostal;
	
	private Integer idCiudad;
	
	private String CodPostal;
}
