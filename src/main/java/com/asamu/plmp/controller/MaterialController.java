package com.asamu.plmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.MaterialService;
import com.asamu.plmp.util.FileUtil;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	
	private final String DECLARATION_URL="d:\\asamu\\申报书\\";
	/**
     * @function 上传申报书
     * @param file
     * @return
     */
	@RequestMapping("/upload/declaration")
	@ResponseBody
	public JsonResult uploadMaterial(@RequestParam(value = "file", required = false) MultipartFile file){
	    if(file == null){
	        return new JsonResult(201,"上传失败！上传文件为空");
	    }else{
	        return materialService.saveMaterial(file,DECLARATION_URL);
	    }
	
	}
}
