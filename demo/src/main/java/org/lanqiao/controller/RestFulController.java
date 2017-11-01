package org.lanqiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {
	// demo
	// http://localhost:8080/project/restful/5/query
	@RequestMapping("/restful/{id}/query")
	public String doRestful(@PathVariable("id") String id) {
		return "list";
	}

	
	@RequestMapping("/view/{dir}/{page}")
	public String foward(@PathVariable("dir") String dir, @PathVariable("page") String page) {
		return dir + "/" + page;
	}


	@RequestMapping("/view/{page}")
	public String foward2(@PathVariable("page") String page) {
		return page;
	}
	

	
	

}
