package com.yummy.friends.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yummy.friends.domain.Venta;
import com.yummy.friends.repository.VentaRepository;

@Service

public class VentaService {

	@Autowired
	public VentaRepository ventaRepository;

	public List<Venta> ventasHome() {
		return this.ventaRepository.ventasHome();
	}

	public List<Venta> findAll() {
		return this.ventaRepository.findAll();
	}

	public Venta crearVenta(Venta v) {
		if (v.getIdVenta() == null) {
			Integer id = this.ventaRepository.getMaxId();
			v.setIdVenta(id);
		}
		return this.ventaRepository.save(v);
	}

	public Venta detalleVenta(Integer id) {
		return this.ventaRepository.findVentaById(id);
	}

	public List<Venta> filtrarVentas(String busqueda) {
		return this.ventaRepository.filtrarVentas(busqueda);
	}

	public List<Venta> ventasRealizadas(Integer idUsuario) {
		return this.ventaRepository.ventasRealizadas(idUsuario);
	}

	public List<Venta> ventasEnPublicacion(Integer idUsuario) {
		return this.ventaRepository.ventasEnPublicacion(idUsuario);
	}

	public void actualizarProducto(Integer idProducto, Integer idVenta) {
		this.ventaRepository.actualizarProducto(idProducto, idVenta);
	}
	
	public Venta getInfoVentaCompra(Integer idCompra) {
		return this.ventaRepository.getInfoVentaCompra(idCompra);
	}

}
