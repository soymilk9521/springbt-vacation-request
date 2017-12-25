package com.vacation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApproveController {
	@RequestMapping("approve")
	public String approve() {
		
		return "approve";
	}
}
