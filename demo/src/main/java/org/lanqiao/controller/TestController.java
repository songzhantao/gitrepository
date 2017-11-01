package org.lanqiao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.lanqiao.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("list") 
public class TestController {

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String login(String uname, String upass, HttpSession session) {
		// UserService service =new UserService();
		session.setAttribute("loginUser", "登录数据");
		return "success";
	}

	@RequestMapping(value = "/admin/login2", method = RequestMethod.GET)
	public void login(Integer id, Model model) {
		model.addAttribute("list", "数组数据");
	}

	@RequestMapping(value = "/admin/regsiter8", method = RequestMethod.GET)
	public void login(User user, ModelMap map) {

	}

	@RequestMapping(value = "/admin/regsiter7", method = RequestMethod.GET)
	public void login2(@RequestParam("d") String id) {

	}

	@RequestMapping(value = "/admin/reg3", method = RequestMethod.GET)
	public void login3(@RequestParam(value = "id", required = true) int id) {
		System.out.println(id);
	}

	@RequestMapping(value = "/admin/reg4", method = RequestMethod.GET)
	public void login4(Integer id) {
		System.out.println(id);
	}

	@RequestMapping("/admin/query")
	public ModelAndView login5(String id) {
		ModelAndView mv = new ModelAndView("list", "data", "��̬���Value");
		return mv;

	}

	@RequestMapping("/admin/query2")
	public String login6(String id) {
		// return "foward:/list.jsp";
		return "redirect:/project/view/list"; // ͨ���ض�����Ե�������һ��Controller����
		
	}

	@RequestMapping(value = "/admin/exception")
	public void exec(HttpServletRequest request, HttpServletResponse response) {
			throw  new RuntimeException("hello Exception");
	}
	
	@RequestMapping(value = "/admin/exception2")
	public void exec2(HttpServletRequest request, HttpServletResponse response) {
			throw  new RuntimeException("hello Exception");
	}
	

}
