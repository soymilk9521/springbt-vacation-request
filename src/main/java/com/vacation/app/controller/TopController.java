package com.vacation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TopController {
	
	@GetMapping(value="top")
	public String index(Model model, @RequestParam( value="lang", required=false) String lang) {
		
		model.addAttribute("lang", lang);
		return "top";
	}
}
