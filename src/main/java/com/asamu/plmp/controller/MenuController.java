package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.MenuDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.MenuService;


@Controller
@RequestMapping("/menu")
public class MenuController {

    @Resource
    MenuService menuService;
	
	@RequestMapping("/getMenu")
	@ResponseBody
	public JsonResult getMenu() {
		List<MenuDO> menuDOs = menuService.findAll();
		return JsonResult.success(menuDOs);
	}
}
