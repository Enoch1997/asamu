package com.asamu.plmp.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.asamu.plmp.pojo.entity.Material;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.MaterialService;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	
	private final String DECLARATION_URL="d:\\asamu\\申报书\\";
	private final String MID_MATERIAL_URL="d:\\asamu\\中期材料\\";
	private final String END_MATERIAL_URL="d:\\asamu\\结题材料\\";
	
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
	
	/**
     * @function 上传中期检查材料
     * @param file
     * @return
     */
	@RequestMapping("/upload/midMaterial")
	@ResponseBody
	public JsonResult uploadMidMaterial(@RequestParam(value = "file", required = false) MultipartFile file){
	    if(file == null){
	        return new JsonResult(201,"上传失败！上传文件为空");
	    }else{
	        return materialService.saveMaterial(file,MID_MATERIAL_URL);
	    }
	
	}
	
	/**
     * @function 上传结题验收材料
     * @param file
     * @return
     */
	@RequestMapping("/upload/endMaterial")
	@ResponseBody
	public JsonResult uploadEndMaterial(@RequestParam(value = "file", required = false) MultipartFile file){
	    if(file == null){
	        return new JsonResult(201,"上传失败！上传文件为空");
	    }else{
	        return materialService.saveMaterial(file,END_MATERIAL_URL);
	    }
	
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public JsonResult download(HttpServletRequest request,HttpServletResponse response,Integer id) throws UnsupportedEncodingException {
		Material material = materialService.getById(id);
		
		String fileName = material.getName();// 设置文件名，根据业务需要替换成要下载的文件名
		System.out.println(material);
        if (fileName != null) {
            //设置文件路径
            String realPath = material.getUrl();
            File file = new File(realPath);
            System.out.println("是否存在"+file.exists());
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;filename* = UTF-8''" + URLEncoder.encode(fileName,"UTF-8"));// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return JsonResult.success();
	}
	
	
	
}
