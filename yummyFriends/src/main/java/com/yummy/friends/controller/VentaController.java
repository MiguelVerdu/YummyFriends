package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.domain.Venta;
import com.yummy.friends.service.Ventaservice;

@RestController
public class VentaController {
	
	@Autowired
	public Ventaservice ventaservice;
	
	//método que al entrar a la app nos carga un listado de ventas que se filtaran por precio/ubicacion lo q se defina	
	@GetMapping("/ventasHome")
	public List<Venta> ventasHome(){
		return this.ventaservice.ventasHome();
	}
}
