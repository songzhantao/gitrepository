package org.lanqiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.lanqiao.model.Leave;
import org.lanqiao.service.LeaveWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveWorkFlowServiceImpl implements LeaveWorkFlowService {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RepositoryService repositoryService;

	@Override
	public ProcessInstance startWorkflow(Leave leave) {
		ProcessInstance processInstance = null;
		// 自己的dao插入 请假表 返回请假的ID
		String businessKey = UUID.randomUUID().toString(); // 保存在数据请假表可以
		leave.setId(businessKey);
		
		//插入数据
		
		HashMap<String, Object> vals = new HashMap<String, Object>();
		vals.put("day", leave.getDay());

		vals.put("dd", "dudao");
		vals.put("leader", "leader");
		processInstance = runtimeService.startProcessInstanceByKey("process_leave", businessKey, vals);

		//更新数据库   正在审核
		return processInstance;
	}

	// 查看待办任务
	@Override
	public List<Task> findTodoTasks(String userId) {
		// 获取当前人的角色
		// 查询当前人的角色
		String roid = "dudao";

		TaskQuery taskQuery = taskService.createTaskQuery().taskCategory(roid);
		List<Task> tasks = taskQuery.orderByTaskCreateTime().asc()// 使用创建时间的升序排列
				/** 返回结果集 */
				.list();// 返回列表 ]

		if (tasks != null && tasks.size() > 0) {
			for (Task task : tasks) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间:" + task.getCreateTime());
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("########################################################");
			}
		}

		return tasks;
	}

	// 部署
	@Override
	public void deployProcess() {
		repositoryService.createDeployment().name("请假流程").addClasspathResource("org/lanqiao/process/leave.bpmn")
				.addClasspathResource("org/lanqiao/process/leave.png").deploy();

	}
	
	// 查询流程定义
	@Override
	public List<ProcessDefinition> queryProcess() {
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();

		// 添加过滤条件
		query.processDefinitionKey("bxlc");
		// 添加排序条件降序排序
		query.orderByProcessDefinitionVersion().desc();
		// 添加分页查询
		query.listPage(0, 10);
		List<ProcessDefinition> list = query.list();
		return list;
	}

}
