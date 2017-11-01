package org.lanqiao.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.lanqiao.model.Leave;
import org.lanqiao.model.User;
import org.lanqiao.service.LeaveWorkFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveController {
	private final  static  Logger loger = LoggerFactory.getLogger(LeaveController.class);

	@Autowired  LeaveWorkFlowService  leaveWorkFlowService;
	
	
	//部署单个流程
	@RequestMapping("/process/leave/deply")
	public String deply(Model model){
		leaveWorkFlowService.deployProcess();
		model.addAttribute("message", "请假流程部署");
		return  "success";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/process/leave/start")
	public String start(Leave  leave ,Model model){
		Subject subject = SecurityUtils.getSubject();
		String uname  =String.valueOf(subject.getPrincipal());
		
		User user =new User();
		user.setUname(uname);
		leave.setUser(user);
		loger.debug("[{}]正在启动请假流程",uname);
		leaveWorkFlowService.startWorkflow(leave);
		model.addAttribute("message", "请假流程已经提交且启动");
		return  "success";
	}
	
	@RequestMapping("/process/main")
	public String dotask(Model model){
		Subject subject = SecurityUtils.getSubject();
		String uname  =String.valueOf(subject.getPrincipal());
		loger.info("当前待办任务的用户信息是[{}]",uname);
		List<Task> list =leaveWorkFlowService.findTodoTasks(uname);
		model.addAttribute("tasks",list);
		return  "main";
	}
	
	
	
}
