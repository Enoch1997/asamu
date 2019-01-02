package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.DeclarationRule;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.ProjectService;

@Controller
@RequestMapping("/declare")
public class DeclareProjectController {

    @Resource
    private ProjectService projectService;
    
	@RequestMapping("/getProjectsByStatus")
	@ResponseBody
	public JsonResult getProjectsByStatus(Integer status) {
		List<ProjectinfoDO> declareproDos = projectService.findProjectByStatus(status);
		return JsonResult.success(declareproDos);
	}
	
	
	@RequestMapping("/allot")
	@ResponseBody
	public JsonResult setAllotion() {
		Integer status = 1;
		List<ProjectinfoDO> declareproDos = projectService.findProjectByStatus(status);
		return JsonResult.success(declareproDos);
	}
}
