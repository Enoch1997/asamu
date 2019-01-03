package com.asamu.plmp.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.ExpertReview;
import com.asamu.plmp.pojo.entity.ProjectInfoExtend;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.AllocationService;
import com.asamu.plmp.service.MessageService;
import com.asamu.plmp.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Resource
	ProjectService projectService;
	
	@Resource
	AllocationService allocationService;
	
	@Resource
	MessageService messageService;
	
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
	
	/**
	 * 根据负责人id和状态获得项目
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping("/getProject")
	@ResponseBody
	public JsonResult getProject(Integer id,Integer status) {
		List<ProjectinfoDO> projectinfoDOs = projectService.findProject(id,status);
		return JsonResult.success(projectinfoDOs);
	}
	@RequestMapping("/getProjectById")
	@ResponseBody
	public JsonResult getProject(Integer id) {
		ProjectinfoDO projectinfoDOs = projectService.findProject(id);
		return JsonResult.success(projectinfoDOs);
	}

	@RequestMapping("/getProjectByUserId")
	@ResponseBody
	public JsonResult getProjectByUserId(Integer id) {
		List<ProjectinfoDO> projectinfoDOs = projectService.findProjectByUserId(id);
		return JsonResult.success(projectinfoDOs);
	}

	@RequestMapping("/getProjectByStatus")
	@ResponseBody
	public JsonResult getProjectByStatus(Integer status) {
		List<ProjectinfoDO> projectinfoDOs = projectService.findProjectByStatus(status);
		return JsonResult.success(projectinfoDOs);
	}
	
	@RequestMapping("/getProjectsExtendByStatus")
	@ResponseBody
	public JsonResult getProjectExtendByStatus(Integer status) {
		List<ProjectinfoDO> projectinfoDOs = projectService.findProjectByStatus(status);
		Integer size = projectinfoDOs.size();
		List<ProjectInfoExtend> projectInfoExtends = new ArrayList<>(size);
		for(int i = 0; i < size ; i++)
		{	
			ProjectInfoExtend templist = new ProjectInfoExtend();
			templist.setName(projectinfoDOs.get(i).getName());
			templist.setLevelName(projectinfoDOs.get(i).getLevelName());
			templist.setField(projectinfoDOs.get(i).getField());
			templist.setDirectorUserName(projectinfoDOs.get(i).getDirectorUserName());
			templist.setStatusName(projectinfoDOs.get(i).getStatusName());
			ExpertReview expertReview = allocationService.findExpertReview(projectinfoDOs.get(i).getId());
			templist.setScore(expertReview.getScore());
			templist.setComment(expertReview.getComment());
			projectInfoExtends.add(templist);
		}
		return JsonResult.success(projectInfoExtends);
	}

	@RequestMapping("/UpdateProjectStatus")
	@ResponseBody
	public JsonResult updateProjectStatus(Integer id,Integer status) {
		projectService.updateProjectStatus(id,status);
		if(status==2||status==5||status==6||status==7||status==8||status==9||status==10) {
			messageService.sendMessageById(id, status);
		}
		
		return JsonResult.success();
	}
	
	@RequestMapping("/getAllProject")
	@ResponseBody
	public JsonResult getAllProject() {
		List<ProjectinfoDO> projectinfoDOs = projectService.findAllProject();
		return JsonResult.success(projectinfoDOs);
	}
	
}
