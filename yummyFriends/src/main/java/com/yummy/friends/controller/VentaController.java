package com.yummy.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.friends.domain.Venta;
import com.yummy.friends.service.VentaService;

@RestController
@CrossOrigin("*")
public class VentaController {
	
	@Autowired
	public VentaService ventaService;
	
	//método que al entrar a la app nos carga un listado de ventas que se filtaran por precio/ubicacion lo q se defina	
	@GetMapping("/ventasHome")
	public List<Venta> getVentas(){
		return this.ventaService.ventasHome();
	}
	
	@PostMapping("/crearVenta")
	public Venta crearEncuentro(@RequestBody Venta v) {
		return this.ventaService.crearVenta(v);
	}
	
	@GetMapping("/detalleVenta/{id}")
	public Venta detalleVenta(@PathVariable Integer id) {
		return this.ventaService.detalleVenta(id);
	}
	
	@GetMapping("/filtrarVentas/{busqueda}")
	public List<Venta> filtrarVentas(@PathVariable String busqueda){
		return this.ventaService.filtrarVentas(busqueda);
	}
	
	@GetMapping("/ventasRealizadas/{idUsuario}")
	public List<Venta> ventasRealizadas(@PathVariable Integer idUsuario){
		return this.ventaService.ventasRealizadas(idUsuario);
	}
	
	@GetMapping("/ventasEnPublicacion/{idUsuario}")
	public List<Venta> ventasEnPublicacion(@PathVariable Integer idUsuario){
		return this.ventaService.ventasEnPublicacion(idUsuario);
	}
	
}
