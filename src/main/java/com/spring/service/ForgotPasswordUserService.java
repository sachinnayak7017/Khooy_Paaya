package com.spring.service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordUserService {
	
	public boolean sendEmail(String subject, String message, String to)
	{
		boolean f = false;
		
		String from = "guruvachanindian@gmail.com";
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
		         
				return new PasswordAuthentication("guruvachanindian@gmail.com", "zibt mftn zlwx qbzv");
			}
			
			
		});
		
	    session.setDebug(true);
	    
	    MimeMessage m = new MimeMessage(session);
	    
	    try {
	    	
	    	 m.setFrom(from);
	    	 m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	 
	    	 m.setSubject(subject);
	    	 
	    	 // m.setText(message);
	    	 m.setContent(message, "text/html");
	    	 
	    	 Transport.send(m);
	    	 
	    	 System.out.println("Message sent successfully...");
			
	    	 f = true;
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return f;
	}

}
