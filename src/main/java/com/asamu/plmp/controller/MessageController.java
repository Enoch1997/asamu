package com.asamu.plmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asamu.plmp.pojo.entity.Message;
import com.asamu.plmp.pojo.vo.JsonResult;
import com.asamu.plmp.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
    @Resource
    MessageService messageService;
	
	@RequestMapping("/getUserMessage")
	@ResponseBody
	public JsonResult getUserMessage(Integer userId) {
		List<Message> list = messageService.findMessageByUserId(1);
		System.out.println(list.get(0).getCreateTime());
		return JsonResult.success(list);
	}
	

}
