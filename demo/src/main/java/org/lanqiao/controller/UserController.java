package org.lanqiao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.lanqiao.model.User;
import org.lanqiao.service.UserService;
import org.lanqiao.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	private final  static  Logger loger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	// demo演示
	@RequestMapping("/dologin")
	public String dologin(String name) {
		loger.debug("{}正在登录，使用的Ipxxxxx", name);
		return "login";
	}

	@RequestMapping("/logout")
	public String logout() {
		
		Subject subject = SecurityUtils.getSubject();
		
		subject.logout();
		
		return "login";
	}
	
	//demo 演示
	@RequestMapping("/isValid")
	public String testpriv() {
		Subject subject = SecurityUtils.getSubject();
		subject.isPermitted("adfa");
		return "success";
	}

	// 通过Shiro认证登录
	@RequestMapping("/login")
	public ModelAndView loginByShiro(@RequestParam("uname") String username, @RequestParam("upass") String password,
			Model model) {
		loger.debug("{}正在准备登录", username);
		ModelAndView mv = null;
		//当前主体   当前用户
		Subject subject = SecurityUtils.getSubject();
		
		//没有认证过
		if (!subject.isAuthenticated()) {
			// 构建令牌
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			//token.setRememberMe(true);
			try {
				// 去认证
				subject.login(token);
				
				mv = new ModelAndView("success");
				loger.info( "User [" + subject.getPrincipal() + "] logged in successfully." );
			} catch (IncorrectCredentialsException ice) {
				mv = new ModelAndView("login");
				mv.addObject("loginError", "用户名或者密码错误");
			} catch (UnknownAccountException ice) {
				mv = new ModelAndView("login");
				mv.addObject("loginError", "用户名不存储");
			} catch (ExcessiveAttemptsException ice) {
				mv = new ModelAndView("login");
				mv.addObject("loginError", "多次错误登录");
			}catch(Exception ex){
				mv = new ModelAndView("login");
				loger.info( "login error   ,maybe is []",ex.getMessage() );
				mv.addObject("loginError", "其他未知错误");
			}
		}else{
			mv = new ModelAndView("success");
			loger.info( "User [" + subject.getPrincipal() + "] already  logged in successfully." );
		}

		return mv;
	}

	// http://localhost:8080/demo/user/login
	@RequestMapping("/login2")
	public String login(String uname, String upass, Model model, HttpSession session) {
		String result = "list";
		User user = userService.login(uname, upass);
		if (user != null) {
			session.setAttribute("loginUser", user);
		} else {
			model.addAttribute("loginError", "用户名或者密码错误");
			result = "login";
		}
		return result; // WEB-INF/view/login.ftl
	}

	@RequestMapping("/register")
	public String register() {
		return "success";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List users = userService.findList();
		model.addAttribute("list", users);
		return "users";
	}

	@RequestMapping("/search")
	public String search(UserVo uservo, Model model) {
		List list = userService.findBySearch(uservo);
		model.addAttribute("list", list);
		model.addAttribute("vo", uservo);
		return "users";
	}

	// http://localhost:8080/demo/delete?ids=1&ids=2&ids=3
	// String [] ids =request.getParamterValues("ids")
	@RequestMapping("/delete")
	public String delete(String[] ids) {
		userService.deleteUsers(ids);
		return "redirect:/user/list";
	}

	// demo演示
	@RequestMapping("/ajax")
	@ResponseBody
	public Object ajaxrequest() {
		User user = userService.login("admin", "123456");
		return user;
	}

	// demo演示
	@RequestMapping(value = "/upload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model) {

		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

		return "result";
	}

	// demo演示
	@RequestMapping("/upload2")
	public String addUser(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) {

		for (int i = 0; i < files.length; i++) {
			System.out.println("fileName---------->" + files[i].getOriginalFilename());

			if (!files[i].isEmpty()) {
				int pre = (int) System.currentTimeMillis();
				try {
					// 拿到输出流，同时重命名上传的文件
					FileOutputStream os = new FileOutputStream(
							"H:/" + new Date().getTime() + files[i].getOriginalFilename());
					// 拿到上传文件的输入流
					FileInputStream in = (FileInputStream) files[i].getInputStream();

					// 以写字节的方式写文件
					int b = 0;
					while ((b = in.read()) != -1) {
						os.write(b);
					}
					os.flush();
					os.close();
					in.close();
					int finaltime = (int) System.currentTimeMillis();
					System.out.println(finaltime - pre);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("上传出错");
				}
			}
		}
		return "/success";
	}

}
