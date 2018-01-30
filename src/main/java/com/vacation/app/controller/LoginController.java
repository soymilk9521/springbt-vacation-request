package com.vacation.app.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vacation.app.dao.ActIdUserDao;
import com.vacation.app.form.LoginForm;
import com.vacation.app.model.ActIdUser;

@Controller
public class LoginController {

	@Autowired
	private ActIdUserDao userDao;

	@GetMapping(value = "login")
	public String index(Model model, @ModelAttribute("form") LoginForm form) {

		return "login";
	}

	@PostMapping(value = "login")
	public String login(Model model, @ModelAttribute(value = "form") LoginForm form) {
		if (!StringUtils.isEmpty(form.getUsername())) {
			ActIdUser user = userDao.findUserByUserId(form.getUsername());
			if (user != null && user.getPwd() != null && user.getPwd().equals(form.getPassword())) {
				return "index";
			}
		}
		return "login";
	}

}
