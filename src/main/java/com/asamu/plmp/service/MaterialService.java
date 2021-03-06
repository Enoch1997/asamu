package com.asamu.plmp.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.asamu.plmp.dao.MaterialDAO;
import com.asamu.plmp.pojo.entity.Material;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.util.FileUtil;

@Service
public class MaterialService {
	@Autowired
	private MaterialDAO materialDAO;

	public JsonResult saveMaterial(MultipartFile file, String dECLARATION_URL) {
		if(file.isEmpty()) {
			return new JsonResult(201,"上传失败！上传文件为空");
		}
		String fileName = file.getOriginalFilename();
		//System.out.println(fileName);
		String url = FileUtil.fileOne(file, dECLARATION_URL);
		if(url==null) {
			return new JsonResult(201,"上传失败！");
		}
		Material material=new Material();
		material.setName(fileName);
		material.setUrl(url);
		material.setCreateTime(new Date());
		
		materialDAO.save(material);
		
		return JsonResult.success(material);
	}
	
	public Material getById(Integer id) {
		Optional<Material> o = materialDAO.findById(id);
		return o.get();
	}

}
