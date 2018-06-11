package com.yummy.friends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummy.friends.domain.Compra;
import com.yummy.friends.domain.Usuario;
import com.yummy.friends.domain.Venta;
import com.yummy.friends.repository.CompraRepository;
import com.yummy.friends.repository.UsuarioRepository;
import com.yummy.friends.repository.VentaRepository;

@Service
public class CompraService {

	@Autowired
	public CompraRepository compraRepository;
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public VentaRepository ventaRepository;
	
	@Autowired
	public Email emailService;

	public List<String> obtComentarios(Integer idUsuario) {
		return this.compraRepository.obtComentarios(idUsuario).subList(0, 2);
	}

	public Float obtVal(Integer idUsuario) {
		return this.compraRepository.obtVal(idUsuario);
	}
	
	public Float totalVenta(Integer idVenta) {
		return this.compraRepository.totalVenta(idVenta);
	}

	public Compra crearCompra(Compra compra) {
		if (compra.getIdCompra() == null) {
			compra.setIdCompra(this.compraRepository.getMaxID());
		}
		Usuario u = null;
		if (compra.getComentarios().length() > 0) {
			String datos[] = compra.getComentarios().split("-");
			u = this.usuarioRepository.findByidUsuario(Integer.parseInt(datos[0]));
			Venta v = this.ventaRepository.findVentaById(Integer.parseInt(datos[1]));
			compra.setComprador(u);
			compra.setVenta(v);
			compra.setComentarios(null);
		}
		
		this.emailService.mensajeCompra(u.getMail(), compra.getIdCompra());
		return this.compraRepository.save(compra);
	}

	public List<Compra> obtenerCompras(String tipo) {
		return this.compraRepository.obtenerCompras(tipo);
	}
	
	public Venta getInfoVentaCompra(Integer idCompra) {
		return this.compraRepository.getInfoVenta(idCompra);
	}

	public void actualizarCompra(Integer idCompra) {
		this.compraRepository.actualizarCompra(idCompra);
	}
}
