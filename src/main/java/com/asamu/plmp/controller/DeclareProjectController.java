package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.DeclarationRule;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.AllocationService;
import com.asamu.plmp.service.ProjectService;

@Controller
@RequestMapping("/declare")
public class DeclareProjectController {

    @Resource
    private ProjectService projectService;
    
    @Resource
    private AllocationService allocationService;
    
    //根据状态显示项目信息
	@RequestMapping("/getProjectsByStatus")
	@ResponseBody
	public JsonResult getProjectsByStatus(Integer status) {
		List<ProjectinfoDO> declareproDos = projectService.findProjectByStatus(status);
		return JsonResult.success(declareproDos);
	}
	
	//分配专家
	@RequestMapping("/allot")
	@ResponseBody
	public JsonResult setAllocation(Integer projectId,Integer expertId) {
		allocationService.setAllocation(projectId,expertId);
		return JsonResult.success();
	}
	
    //专家评审
	@RequestMapping("/getProjectsByExpertIdAndStatus")
	@ResponseBody
	public JsonResult getProjectsByExpertIdAndStatus(Integer expertId,Integer status) {
		List<ProjectinfoDO> declareproDos = projectService.findProjectByExpertIdAndStatus(expertId,status);
		return JsonResult.success(declareproDos);
	}
}
