package com.asamu.plmp.controller;



import java.util.Date;
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
	
	//申报项目
	@RequestMapping("/setProject")
	@ResponseBody
	public JsonResult setProject(ProjectinfoDO projectinfoDO) {
		if(projectinfoDO.getId()==null||projectinfoDO.getId()==0) {//insert
			projectService.saveProject(projectinfoDO);
			projectinfoDO.setCreateTime(new Date());
			projectinfoDO.setUpdateTime(projectinfoDO.getCreateTime());
		}else {//update
			ProjectinfoDO result = projectService.getProjectById(projectinfoDO.getId());
			result.setUpdateTime(new Date());
			result.setName(projectinfoDO.getName());
			result.setApplyLevel(projectinfoDO.getApplyLevel());
			result.setField(projectinfoDO.getField());
			result.setMembers(projectinfoDO.getMembers());
			result.setPromise(projectinfoDO.getPromise());
			result.setDirectorTel(projectinfoDO.getDirectorTel());
			result.setStatus(projectinfoDO.getStatus());
			result.setDeclarationMaterialId(projectinfoDO.getDeclarationMaterialId());
			projectService.saveProject(result);
		}
		
		return JsonResult.success();
	}
	
	@RequestMapping("/getProject")
	@ResponseBody
	public JsonResult getProject(Integer id,Integer status) {
		List<ProjectinfoDO> projectinfoDOs = projectService.findProject(id,status);
		return JsonResult.success(projectinfoDOs);
	}
	
}
