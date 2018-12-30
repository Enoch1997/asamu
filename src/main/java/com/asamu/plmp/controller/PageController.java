package com.asamu.plmp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.MenuService;

@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private MenuService menuService;
	
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
	
	@RequestMapping("user")
	public String getUserPage() {
		return "userlist/userlist";
	}
	
	@RequestMapping("/getUserMenu")
	@ResponseBody
	public JsonResult getUserMenu(Integer userId) {
		return menuService.getUserMenu(userId);
	}
}
