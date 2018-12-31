package com.asamu.plmp.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	/**
     * @function  单文件上传
     * @return
     */
	public static String fileOne(MultipartFile file, String saveUrl){
	    String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	    String fileName = UUID.randomUUID() + suffix;
	    String newUrl = saveUrl+fileName;
	    System.out.println("文件路径：" + newUrl);
	    File saveFile = new File(newUrl);
	    if(!saveFile.getParentFile().exists()){
	        saveFile.getParentFile().mkdirs();
	    }
	    try {
	        file.transferTo(saveFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return newUrl;
	}
}
