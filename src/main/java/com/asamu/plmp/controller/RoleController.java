package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.RoleDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    RoleService roleService;
	
	@RequestMapping("/getRole")
	@ResponseBody
	public JsonResult getDeclaration() {
		List<RoleDO> role = roleService.findAll();
		return JsonResult.success(role);
	}
}
