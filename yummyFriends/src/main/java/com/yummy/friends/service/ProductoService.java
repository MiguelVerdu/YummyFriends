package com.yummy.friends.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yummy.friends.domain.Producto;
import com.yummy.friends.repository.ProductoRepository;


@Service
public class ProductoService {
	

	@Autowired
	public ProductoRepository productoRepository;

	public void create(Producto producto, MultipartFile file) throws IOException {
		
				String token = UUID.randomUUID().toString();
		
			    File targetFile = new File("E:/" + token);
			 
			    java.nio.file.Files.copy(
			      file.getInputStream(), 
			      targetFile.toPath(), 
			      StandardCopyOption.REPLACE_EXISTING);
			 
			    IOUtils.closeQuietly(file.getInputStream());
			    
			    producto.setFoto(token);
		
		 this.productoRepository.save(producto);
		
	}
	

	
}
