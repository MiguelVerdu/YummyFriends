package com.yummy.friends.service;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.yummy.friends.repository.UsuarioRepository;

@Service
public class Email{

	@Autowired
    public JavaMailSender emailSender;
 
	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
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
