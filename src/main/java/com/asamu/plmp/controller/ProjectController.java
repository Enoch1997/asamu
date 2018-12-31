package com.asamu.plmp.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Resource
	ProjectService projectService;
	
	@RequestMapping("/setProject")
	@ResponseBody
	public JsonResult setProject(ProjectinfoDO projectinfoDO) {
		projectService.saveProject(projectinfoDO);
		return JsonResult.success();
	}
	
	@RequestMapping("/getProject")
	@ResponseBody
	public JsonResult getProject(Integer id,Integer status) {
		List<ProjectinfoDO> projectinfoDOs = projectService.findProject(id,status);
		return JsonResult.success(projectinfoDOs);
	}
	
}
