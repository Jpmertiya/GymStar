package com.Gym.Star.ErrorHandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class errorHandler {
	@ExceptionHandler({ NoHandlerFoundException.class })
	public String handleNoHandlerFoundException(NoHandlerFoundException ex,
			HttpServletRequest httpServletRequest,Model model) {
		 String cause = ex.getRequestURL();
		System.out.println(cause);
		model.addAttribute("meg","No page found with url "+ex.getRequestURL());
		return "errors";
	}

}
