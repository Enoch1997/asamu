package com.asamu.plmp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;

@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private UserDAO userDAO;
	
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
	@ResponseBody
	public JsonResult getUserMenu(Integer userId) {
		Optional<UserDO> op = userDAO.findById(userId);
		UserDO userDO = op.get();
		System.out.println(userDO.toString());
		return JsonResult.success(userDO);
	}
}
