package com.yummy.friends.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummy.friends.domain.Ciudad;
import com.yummy.friends.repository.CiudadRepository;

@Service
public class CiudadService {

	@Autowired
	public CiudadRepository ciudadRepository;
	
	public List<Ciudad> getCiudades(){
		return this.ciudadRepository.findAll();
	}
}
