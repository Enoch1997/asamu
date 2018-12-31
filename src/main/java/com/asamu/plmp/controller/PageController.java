package com.asamu.plmp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.DeclarationRule;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.DeclarationService;
import com.asamu.plmp.service.MenuService;

@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private DeclarationService declarationService;
	
	@RequestMapping("index")
	public String index() {
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
	
	@RequestMapping("/declare/rule")
	public String setRulePage(Model model) {
		List<DeclarationRule> list = declarationService.findAll();
		if(list==null) {
			//System.out.println("list为nullnullnullnullnullnull");
		}else {
			model.addAttribute("declaration", list.get(0));
		}
		
		return "declare/rule";
	}
	
	@RequestMapping("/declare/entry")
	public String EntryPage(Model model) {
		List<DeclarationRule> list = declarationService.findAll();
		if(list==null) {
			//System.out.println("list为nullnullnullnullnullnull");
		}else {
			model.addAttribute("declaration", list.get(0));
		}
		
		return "declare/entry";
	}
	
	@RequestMapping("/getUserMenu")
	@ResponseBody
	public JsonResult getUserMenu(Integer userId) {
		return menuService.getUserMenu(userId);
	}
	
	
}
