package com.vacation.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vacation.app.dao.ActIdUserDao;
import com.vacation.app.form.LoginForm;
import com.vacation.app.model.ActIdUser;

@Controller
public class LoginController {

	@Autowired
	private ActIdUserDao userDao;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute("form") LoginForm form) {

		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute(value = "form") LoginForm form, BindingResult result) {
		if (!result.hasErrors()) {
			ActIdUser user = userDao.findOne(form.getUserId());
			if (user != null && user.getPwd().equals(form.getPassword())) {
				return "redirect:/index";
			}
		}
		return "login";
	}

}
