package com.Gym.Star.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Gym.Star.Helper.Message;

import jakarta.servlet.http.HttpSession;

@Service
public class SendEmail {

	@Autowired
	private JavaMailSender jms;

	public SendEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void sendEmail(String to, long id) {

		String subject = " Welcome to GymStar - Registration Successful";
		String body = "Congratulations! You have successfully registered with GYMSTAR, your ultimate destination for fitness and well-being.\n\n.Your application number is " + id
				+ "\n\n Thank you for choosing GYMSTAR as your fitness destination. We'll be in touch soon to kick-start your fitness journey!\r\n"
				+ "\n\nBest regards,\n\nGYMSTAR - Where Fitness Meets Flavor"
				+ "\n\n[333 Middle Winchendon Rd, Rindge,\r\n"
				+ "NH 03461]\n\n[125-711-811]\n\n"
				+ "[]Support.gymcenter@gmail.com\n\n"
				+ "WWW.GymStar.com";
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("js5946168@gmail.com");
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		jms.send(mailMessage);

	}
}
