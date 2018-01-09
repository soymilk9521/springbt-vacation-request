package com.vacation.app.controller;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
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
	public String index(Model model) {
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().active().list();
		List<HistoricProcessInstance> historyInstances = historyService.createHistoricProcessInstanceQuery().finished().list();
		
		int count = processInstances.size();
		int finished = historyInstances.size();
		model.addAttribute("count", count);
		model.addAttribute("finished", finished);
		return "index";
	}
	
	/**
	 * clear vacation request
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
