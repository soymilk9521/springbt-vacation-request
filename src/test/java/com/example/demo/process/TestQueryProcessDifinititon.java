package com.example.demo.process;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

public class TestQueryProcessDifinititon {
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	@Deployment(resources = { "vacation-request.bpmn20.xml" })
	public void testProcessDinifition() {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
				.orderByProcessDefinitionVersion().asc().list();
		System.out.println("流程 count" + processDefinitions.size());
		for (ProcessDefinition pd : processDefinitions) {
			System.out.println("流程定义ID:" + pd.getId());// 流程定义的key+版本+随机生成数
			System.out.println("流程定义的名称:" + pd.getName());// 对应vacation-request.bpmn20.xml文件中的name属性值
			System.out.println("流程定义的key:" + pd.getKey());// 对应vacation-request.bpmn20.xml文件中的id属性值
			System.out.println("流程定义的版本:" + pd.getVersion());// 当流程定义的key值相同的相同下，版本升级，默认1
			System.out.println("资源名称bpmn文件:" + pd.getResourceName());
			System.out.println("资源名称png文件:" + pd.getDiagramResourceName());
			System.out.println("部署对象ID：" + pd.getDeploymentId());
			System.out.println("------------------------------");
		}
	}

	@Test
	@Deployment(resources = { "vacation-request.bpmn20.xml" })
	public void testRunProcess() {
		List<ProcessInstance> processInstances = activitiRule.getRuntimeService().createProcessInstanceQuery().list();
		for (ProcessInstance pd : processInstances) {
			System.out.println("流程ID:" + pd.getId());
			System.out.println("流程名称:" + pd.getName());
			System.out.println("当前活跃流程ID:" + pd.getActivityId());
			System.out.println("父流程ID：" + pd.getParentId());
			System.out.println("当前流程描述:" + pd.getDescription());
			System.out.println("流程定义ID:" + pd.getProcessDefinitionId());
			System.out.println("流程定义的Key：" + pd.getProcessDefinitionKey());
			System.out.println("流程ID：" + pd.getProcessInstanceId());
			System.out.println("流程??：" + pd.getBusinessKey());
			System.out.println("------------------------------");
		}
	}

	@Test
	@Deployment(resources = { "vacation-request.bpmn20.xml" })
	public void testExecution() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		List<Execution> executions = runtimeService.createExecutionQuery().list();
		for (Execution ex : executions) {
			System.out.println("execution id:" +ex.getId());
			System.out.println("当前活跃ID:" + ex.getActivityId());
			System.out.println("描述:" + ex.getDescription());
			System.out.println("name:" + ex.getName());
			System.out.println("parenet id:" + ex.getParentId());
			System.out.println("流程ID:" + ex.getProcessInstanceId());
			System.out.println("??" + ex.getTenantId());
			System.out.println("------------------------------");
		}
	}
	
	@Test
	@Deployment(resources = { "vacation-request.bpmn20.xml" })
	public void testTask() {
		TaskService taskService = activitiRule.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().list();
		for (Task tk: tasks) {
			System.out.println("getAssignee?" + tk.getAssignee());
			System.out.println("getCategory?" + tk.getCategory());
			System.out.println("getDescription?" + tk.getDescription());
			System.out.println("getExecutionId?" + tk.getExecutionId());
			System.out.println("getFormKey?" + tk.getFormKey());
			System.out.println("getId?" + tk.getId());
			System.out.println("getName?" + tk.getName());
			System.out.println("getOwner?" + tk.getOwner());
			System.out.println("getPriority?" + tk.getPriority());
			System.out.println("getParentTaskId?" + tk.getParentTaskId());
			System.out.println("getProcessInstanceId?" + tk.getProcessInstanceId());
			System.out.println("getProcessDefinitionId?" + tk.getProcessDefinitionId());
			System.out.println("getTaskDefinitionKey?" + tk.getTaskDefinitionKey());
			System.out.println("getTenantId?" + tk.getTenantId());
			System.out.println("------------------------------");
		}
	}
	
	@Test
	@Deployment(resources = { "vacation-request.bpmn20.xml" })
	public void testActivitiTask() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().list();
		List<Task> allTasks = new ArrayList<Task>();
		for (ProcessInstance ps: processInstances) {
			List<Task> tasks = taskService.createTaskQuery().processInstanceId(ps.getProcessInstanceId()).list();
			System.out.println("the task size of processInstance:" + tasks.size());
			allTasks.addAll(tasks);
		}
		System.out.println("all task size:" + allTasks.size());
	}
}
