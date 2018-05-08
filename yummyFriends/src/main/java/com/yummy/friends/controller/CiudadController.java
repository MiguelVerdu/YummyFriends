package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.domain.Ciudad;
import com.yummy.friends.service.CiudadService;

@RestController
@CrossOrigin("*")
public class CiudadController {
	@Autowired
	public CiudadService ciudadService;
	
	@GetMapping("/getCiudades")
	public List<Ciudad> getCiudades(){
		return this.ciudadService.getCiudades();
	}
}
