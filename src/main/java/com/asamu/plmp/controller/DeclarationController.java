package com.asamu.plmp.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.DeclarationRule;

import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.DeclarationService;


@Controller
@RequestMapping("/declaration")
public class DeclarationController {
	
    @Resource
    DeclarationService declarationService;
	
	@RequestMapping("/getDeclaration")
	@ResponseBody
	public JsonResult getDeclaration() {
		List<DeclarationRule> declarationRule = declarationService.findAll();
		return JsonResult.success(declarationRule.get(0));
	}
	
	@RequestMapping("/updateDeclarationRule")
	@ResponseBody
	public JsonResult updateDeclarationRule(DeclarationRule declarationRule) {
		declarationService.updateRule(declarationRule);
		return JsonResult.success();
	}
}
