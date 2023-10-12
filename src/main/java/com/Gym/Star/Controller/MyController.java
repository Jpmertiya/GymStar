package com.Gym.Star.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;
import com.Gym.Star.Entity.Donation;
import com.Gym.Star.Entity.Gymmers;
import com.Gym.Star.Helper.Message;
import com.Gym.Star.Repository.DonationRepository;
import com.Gym.Star.Service.GymstarImpl;
import com.Gym.Star.Service.SendEmail;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	private GymstarImpl gymstarImpl;

	@Autowired
	private SendEmail email;
	
	@Autowired
	private DonationRepository donationRepository;

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

	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
//		System.out.println("inside server payment");
		System.out.println(data);
		int amount = Integer.parseInt(data.get("amount").toString());
		var client = new RazorpayClient("rzp_test_t9ooowSRh4HzRY", "E5JN3UVkHs2oXgoHYIKANGHd");
		JSONObject ob=new JSONObject();
		ob.put("amount", amount*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txn_235425");
		Order order=client.orders.create(ob);
//		saving donation details to databases
		Donation donation=new Donation();
		donation.setAmount(amount+"");
		donation.setOrder_id(order.get("id"));
		donation.setPayment_id(null);
		donation.setStatus("created");
		donation.setReceipt(order.get("receipt"));
		donationRepository.save(donation);
		
		return order.toString();
	}

	@PostMapping("/update_donation")
	public ResponseEntity<?> updateOrder(@RequestBody Map<String,Object> data){
		
		Donation findByOrderId = donationRepository.findByOrderId(data.get("order_id").toString());
		findByOrderId.setStatus(data.get("status").toString());
		findByOrderId.setPayment_id(data.get("payment_id").toString());
		donationRepository.save(findByOrderId);
		return ResponseEntity.ok(Map.of("msg","payment updated successfully"));
	}
}
