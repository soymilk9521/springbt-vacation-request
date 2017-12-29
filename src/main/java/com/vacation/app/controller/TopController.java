package com.vacation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TopController {
	
	@RequestMapping(value="top", method=RequestMethod.GET)
	public String index(Model model, @RequestParam( value="lang", required=false) String lang) {
		
		model.addAttribute("lang", lang);
		return "top";
	}
}
