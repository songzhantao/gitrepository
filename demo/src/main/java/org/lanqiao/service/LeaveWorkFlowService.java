package org.lanqiao.service;

import java.util.List;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.lanqiao.model.Leave;

public interface LeaveWorkFlowService {
	
	
	public void deployProcess();
	
	public  List<ProcessDefinition> queryProcess();
	//启动流程 提交请假表单 
	public ProcessInstance  startWorkflow(Leave  leave );
	//
	public List<Task> findTodoTasks(String userId) ;
}
