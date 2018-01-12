package com.vacation.app.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController extends BaseController {
	
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private HistoryService historyService;
	/**
	 * index 
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/index", "/"})
	public String index(Model model, @CookieValue(value = BaseController.COOKIE_LOCALE, required = false)String preLang, 
			@RequestParam(value = "lang", required = false) String curLang, HttpServletResponse response) {
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().active().list();
		List<HistoricProcessInstance> historyInstances = historyService.createHistoricProcessInstanceQuery().finished().list();
		
		int count = processInstances.size();
		int finished = historyInstances.size();
		model.addAttribute("count", count);
		model.addAttribute("finished", finished);
		// set default language
		if (StringUtils.isEmpty(curLang)) {
			if (StringUtils.isEmpty(preLang)) {
				// system default language
				curLang = Locale.getDefault().toString();
				response.addCookie(new Cookie(BaseController.COOKIE_LOCALE, curLang));
			}else {
				//cookie language
				curLang = preLang; 
			}
		}
		model.addAttribute("lang", curLang);
		return "index";
	}
	
	/**
	 * do clear vacation request
	 * @return
	 */
	@PostMapping("/clear")
	public String clear() {
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().active().list();
		for (ProcessInstance ins : processInstances) {
			runtimeService.deleteProcessInstance(ins.getId(), "delete");
		}
		List<HistoricProcessInstance> historyInstances = historyService.createHistoricProcessInstanceQuery().finished().list();
		for (HistoricProcessInstance historyInstance: historyInstances) {
			historyService.deleteHistoricProcessInstance(historyInstance.getId());
		}
		return "redirect:/index";
	}
}
