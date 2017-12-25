package com.vacation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	
	@RequestMapping("/regiester")
	public String regiester() {
		return "regiester";
	}
}
