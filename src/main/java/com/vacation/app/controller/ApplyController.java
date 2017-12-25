package com.vacation.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Apply controller
 * @author ri
 *
 */
@Controller
public class ApplyController {
	
	@RequestMapping("/apply")
	public String apply() {
		return "apply";
	}
}
