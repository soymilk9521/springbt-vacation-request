package com.vacation.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {
	
	@RequestMapping("/test")
	public String index(Model model) {
		List<User> users = new ArrayList<User>();
		users.add(new User(1L,"karl"));
		users.add(new User(2L, "harry"));
		model.addAttribute("beans", users);
		return "top";
	}
	
	class User {
		private Long id;
		private String name;
		public User() {}
		public User(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
