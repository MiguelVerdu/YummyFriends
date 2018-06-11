package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.domain.Compra;
import com.yummy.friends.domain.Venta;
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
	
	@PostMapping("/crearCompra")
	public Compra crearCompra(@RequestBody Compra compra) {
		return this.compraService.crearCompra(compra);
	}
	
	@GetMapping("/obtenerCompras/{tipo}")
	public List<Compra> obtenerCompras(@PathVariable String tipo){
		return this.compraService.obtenerCompras(tipo);
	}
	
	@GetMapping("/getInfoVentaCompra/{idCompra}")
	public Venta getInfoVentaCompra(@PathVariable Integer idCompra) {
		return this.compraService.getInfoVentaCompra(idCompra);
	}
	
	@GetMapping("/actualizarCompra/{idCompra}")
	public void actualizarCompra(@PathVariable Integer idCompra) {
		this.compraService.actualizarCompra(idCompra);
	}
}
