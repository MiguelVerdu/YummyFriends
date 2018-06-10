package com.yummy.friends.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yummy.friends.domain.Producto;
import com.yummy.friends.service.ProductoService;

@RestController
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	public ProductoService productoService;

	@PostMapping(value = "/createProducto")
	public String create(@RequestPart("producto") String productoStr,
			@RequestPart(name = "file", required = false) MultipartFile file) throws IOException {

		Producto producto;
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_NULL);
		producto = om.readValue(productoStr, Producto.class);
		this.productoService.create(producto, file);

		return "OK";
	}

	@GetMapping(value = "/recogerProducto/{idProducto}")
	public ResponseEntity<InputStreamResource> getFile(@PathVariable("idProducto") Integer idProducto)
			throws FileNotFoundException, IOException {

		String uuid = this.productoService.obtenerFoto(idProducto);
		
		File file = new File("C:/Users/migue/Pictures/" + uuid);

		InputStream targetStream = new FileInputStream(file);

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
				.contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(targetStream));

	}
	
	@GetMapping(value="/fotoProducto/{id}")
	public String obtenerFoto(@PathVariable Integer id) {
//		String foto = "{\"foto\" : \""+this.productoService.obtenerFoto(id)+"\"}";
//		return foto;
		return this.productoService.obtenerFoto(id);
	}

//	@GetMapping(value="/fotoVenta/{idVenta}")
//	public String obtenerFotoVenta(@PathVariable Integer idVenta) {
//		return this.productoService.obtenerFotoVenta(idVenta);
//	}	
	
}
