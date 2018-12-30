package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
    @Resource
    UserService userService;
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public JsonResult getUsers() {
		List<UserDO> list = userService.findAll();
		System.out.println(list);
		return JsonResult.success(list);
	}
	
	@RequestMapping("/deleteUsers")
	@ResponseBody
	public JsonResult deleteUsers(Integer userid) {
		userService.deleteUser(userid);
		return JsonResult.success();
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public JsonResult updateUser(Integer userid,UserDO user) {
		userService.updateUser(userid,user);
		return JsonResult.success();
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public JsonResult addUser(UserDO user) {
		userService.addUser(user);
		return JsonResult.success();
	}
	
	
	
}
