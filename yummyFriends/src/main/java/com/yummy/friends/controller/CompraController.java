package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.service.CompraService;

@RestController
@CrossOrigin("*")
public class CompraController {
	@Autowired
	public CompraService compraService;
	
	@GetMapping("/obtenerComentarios/{idUsuario}")
	public List<String> obtComentarios(@PathVariable Integer idUsuario) {
		return this.compraService.obtComentarios(idUsuario);
	}
	
	@GetMapping("/obtenerValoracion/{idUsuario}")
	public Float obtVal(@PathVariable Integer idUsuario) {
		return this.compraService.obtVal(idUsuario);
	}
	
	@GetMapping("/totalVentaCompra/{idVenta}")
	public Float totalVenta(@PathVariable Integer idVenta) {
		return this.compraService.totalVenta(idVenta);
	}
}
