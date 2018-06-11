package com.yummy.friends.service;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.yummy.friends.domain.Venta;
import com.yummy.friends.repository.CompraRepository;
import com.yummy.friends.repository.UsuarioRepository;

@Service
public class Email{

	@Autowired
    public JavaMailSender emailSender;
 
	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public CompraRepository compraRepository; 
	
	public String sendSimpleMessage(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        
        try {
        	String pass = generarPass(16);
        	
        	MessageDigest m = MessageDigest.getInstance("MD5");
        	m.reset();
        	m.update(pass.getBytes());
        	byte[] digest = m.digest();
        	System.out.println("digest: " + digest + ", digestToString: " + digest.toString());
        	this.usuarioRepository.actualizarPass(digest.toString(), to);
        	
	        message.setTo(to); 
	        message.setSubject("Nueva contraseña"); 
	        message.setText("Esta es tu nueva contraseña " + pass);
	        emailSender.send(message);
        
	        return "{\"ok\":\"ok\"}";
        } catch (Exception e) {
        	return e.getMessage();
        }
    }
	
	public void mensajeCompra(String to, Integer idCompra) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("to:" + to + ", id: " + idCompra);
        try {
        	Venta v =  this.compraRepository.getInfoVenta(idCompra);
        	System.out.println("venta: " + v.getIdVenta());
	        message.setTo(to); 
	        message.setSubject("Compra realizada!"); 
	        message.setText("Le informamos que acaba de realizar una compra a través de la aplicación yummyFriends"+
	        " con los siguientes datos: producto -> " +  v.getTitulo() + ", horario -> desde las " + 
	        v.getRangoHoraDisponibleMin().getHours() + ":" + v.getRangoHoraDisponibleMin().getMinutes() + " hasta las " +
	        v.getRangoHorarioDisponibleMax().getHours() + ":" + v.getRangoHorarioDisponibleMax().getMinutes() + ", por un importe "
	        + "de " + this.compraRepository.totalVenta(v.getIdVenta()));
	        emailSender.send(message);
	        System.out.println(to);
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        }
    }
    
    private String generarPass(int tam) {
        String caracteres = "abcdefghijkmnpqrtuvwxyzABCDEFGHIJKLMNPQRTUVWXYZ";
		String numeros = "12346789";
        String especiales = "@#$%&";
        String pass = "";
        
        for (int i = 0; i < (tam/4); i++) {
        	pass += numeros.charAt((int) Math.floor(Math.random() * numeros.length()));
        }
        
        pass += especiales.charAt((int) Math.floor(Math.random() * especiales.length()));
        
        for (int i = 0; i < (tam/2); i++) {
          pass += caracteres.charAt((int) Math.floor(Math.random() * caracteres.length()));
        }
        
        return pass;
      }
}
