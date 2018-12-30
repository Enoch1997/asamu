package com.asamu.plmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.vo.JsonResult;

@Controller
@RequestMapping("/")
public class PageController {

	
	@RequestMapping("index")
	public String login() {
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("message")
	public String message() {
		return "message/message";
	}
	
	@RequestMapping("/getUserMenu")
	public JsonResult getUserMenu() {
		
		return null;
	}
}
