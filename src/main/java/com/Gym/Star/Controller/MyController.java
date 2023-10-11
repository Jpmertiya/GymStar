package com.Gym.Star.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Gym.Star.Entity.Gymmers;
import com.Gym.Star.Helper.Message;
import com.Gym.Star.Service.GymstarImpl;
import com.Gym.Star.Service.SendEmail;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	private GymstarImpl gymstarImpl;

	@Autowired
	private SendEmail email;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", new Message("Invalid Data", "alert-danger"));
		model.addAttribute("gymmers", new Gymmers());
		return "index";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("gymmers") Gymmers gymmers, BindingResult bindingResult, Model model,
			HttpSession session) {
		boolean errors = bindingResult.hasErrors();
		System.out.println("kya error hai kya isme " + errors);
		if (errors) {
			model.addAttribute("gymmers", gymmers);
			session.setAttribute("message", new Message("Invalid Data", "alert-danger"));
			return "index";
		} else if (gymstarImpl.saveGymmer(gymmers)) {
			email.sendEmail(gymmers.getEmail(), gymmers.getId());
			session.setAttribute("message", new Message("Register successfully", "alert-success"));
		}

		return "index";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("all", gymstarImpl.getAllGymmers());
		model.addAttribute("message", new Message("Welcom back sir,", "alert-success"));
		return "admin";
	}
	
	

}
