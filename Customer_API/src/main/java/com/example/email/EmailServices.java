package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Configuration
@Service
public class EmailServices {
	
	@Autowired
	private JavaMailSender mailSender;

	
	public Boolean sendEmail(String to, String subject, String body) throws Exception {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body,true);
		mailSender.send(mimeMessage);
		
		return true;
	}
	
}
