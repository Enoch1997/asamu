package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
	@ResponseBody
	public JsonResult login(UserDO user,HttpSession session) {
		 JsonResult result = userService.login(user);
		 if(result.getCode()==200) {
			 session.setAttribute("user", result.getData());
		 }
		 return result;
	}
	
    @RequestMapping("/logout")
	public String logout(HttpSession session) {
		 session.removeAttribute("user");
		 return "login";
	}
    
    /**
     * 更新基本信息
     * @param session
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
	public JsonResult update(UserDO user) {
    	//System.out.println(user);
		return userService.updateUser(user);
	}

    @RequestMapping("/updatePsd")
    @ResponseBody
	public JsonResult updatePsd(Integer id,String oldPsd,String newPsd) {
		return userService.updateUserPsd(id, oldPsd, newPsd);
	}
    
	@RequestMapping("/getUsers")
	@ResponseBody
	public JsonResult getUsers() {
		List<UserDO> list = userService.findAll();
		System.out.println(list);
		return JsonResult.success(list);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult deleteUsers(Integer id) {
		userService.deleteUser(id);
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
	
	@RequestMapping("/getUsersByRole")
	@ResponseBody
	public JsonResult getUsers(Integer roleId) {
		List<UserDO> list = userService.findByRoleId(roleId);
		System.out.println(list);
		return JsonResult.success(list);
	}
	
	/**
	 * 跳转用户详情页面
	 * @return
	 */
	@RequestMapping("/detail")
	public String getDetailPage(Integer id,HttpSession session,Model model) {
		UserDO user;
		if(id==null) {
			user = (UserDO)session.getAttribute("user");
		}else {
			user = userService.findUserById(id);
		}
		model.addAttribute("user", user);
		return "/user/userDetail";
	}
	
	/**
	 * 跳转用户列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String getUserPage() {
		return "user/userlist";
	}
	
	/**
	 * 跳转用户修改密码页面
	 * @return
	 */
	@RequestMapping("updatePsdPage")
	public String getUpdatePsdPage() {
		return "user/psd";
	}
	
	/**
	 * 跳转添加用户页面
	 * @return
	 */
	@RequestMapping("add")
	public String getAddPage() {
		return "user/add";
	}
}
