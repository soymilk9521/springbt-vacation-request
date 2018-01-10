package com.vacation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vacation.app.form.LoginForm;

@Controller
public class LoginController {

	@GetMapping(value = "login")
	public String index(Model model, @ModelAttribute("form") LoginForm form) {

		return "login";
	}

	@PostMapping(value = "login")
	public String login(Model model, @ModelAttribute(value = "form") LoginForm form) {

		return "login";
	}

}
