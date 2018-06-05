package com.yummy.friends.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yummy.friends.domain.Producto;
import com.yummy.friends.service.ProductoService;


@RestController
public class ProductoController {
	
	@Autowired
	public ProductoService productoService;
	
	@PostMapping(value = "/createProducto")
    public String create(@RequestPart("producto") String productoStr,
            @RequestPart(name = "file", required = false) MultipartFile file) throws IOException {

        Producto producto = null;
        try {
            ObjectMapper om = new ObjectMapper();
            om.setSerializationInclusion(Include.NON_NULL);
            producto = om.readValue(productoStr, Producto.class);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }

        this.productoService.create(producto, file);

        return "OK";
    }

}
