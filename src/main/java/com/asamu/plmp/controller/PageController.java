package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.DeclarationRule;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.entity.RoleDO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.DeclarationService;
import com.asamu.plmp.service.MenuService;
import com.asamu.plmp.service.ProjectService;
import com.asamu.plmp.service.RoleService;

@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private DeclarationService declarationService;
	
    @Resource
    RoleService roleService;
	
    @RequestMapping("login")
	public String login() {
		return "login";
	}
    
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String index1() {
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
	
	@RequestMapping("/role")
	public String getRolePage() {
		return "systemsetup/role";
	}
	
	@RequestMapping("/menu")
	public String getMenuPage() {
		return "systemsetup/menu";
	}
	
	@RequestMapping("/declare/rule")
	public String setRulePage(Model model) {
		List<DeclarationRule> list = declarationService.findByType(0);
		if(list==null) {
			//System.out.println("list为null");
		}else {
			model.addAttribute("declaration", list.get(0));
		}
		
		return "declare/rule";
	}
	
	@RequestMapping("/mid/set")
	public String setMidRulePage(Model model) {
		List<DeclarationRule> list = declarationService.findByType(1);
		if(list==null) {
			//System.out.println("list为null");
		}else {
			model.addAttribute("declaration", list.get(0));
		}
		
		return "mid/rule";
	}
	
	@RequestMapping("/end/set")
	public String setEndRulePage(Model model) {
		List<DeclarationRule> list = declarationService.findByType(2);
		if(list==null) {
			//System.out.println("list为null");
		}else {
			model.addAttribute("declaration", list.get(0));
		}
		
		return "end/rule";
	}
	
	@RequestMapping("/declare/entry")
	public String EntryPage(Model model) {
		List<DeclarationRule> list = declarationService.findAll();
		if(list==null) {
			//System.out.println("list为null");
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
	
	@RequestMapping("/declare/project")
	public String projectDeclarePage(@RequestParam(defaultValue = "1")Integer userId,Model model) {
		List<ProjectinfoDO> list = projectService.findProject(userId, 0);
		if(list.size()>0) {
			model.addAttribute("project", list.get(list.size()-1));
			model.addAttribute("flag","true");
		}else {
			model.addAttribute("project",new ProjectinfoDO());
			model.addAttribute("flag","false");
		}
		return "declare/projectDeclare";
	}
	

	
	@RequestMapping("/project")
	public String getProjectPage() {
		return "project/myproject";
	}
	
	@RequestMapping("/project/list")
	public String getAllProjectPage() {
		return "project/projectlist";
	}

	@RequestMapping("/declare/check")
	public String getPreProject() {
		return "declare/check";
	}
	
	@RequestMapping("/declare/expertAllot")
	public String getExpertAllot() {
		return "declare/allocation";
	}
}
