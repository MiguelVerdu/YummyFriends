package com.yummy.friends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email{

	@Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage(String to) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject("Nueva contraseña"); 
        message.setText("Esta es tu nueva contraseña " + generarPass(16));
        emailSender.send(message);
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
