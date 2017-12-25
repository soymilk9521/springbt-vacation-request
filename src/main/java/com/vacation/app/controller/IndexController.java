package com.vacation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vacation.app.form.ApplyForm;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		ApplyForm vo = new ApplyForm();
		model.addAttribute("apply", vo);
		return "index";
	}
}
