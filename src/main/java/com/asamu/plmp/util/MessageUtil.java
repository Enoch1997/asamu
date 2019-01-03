package com.asamu.plmp.util;

import java.util.Date;

import com.asamu.plmp.pojo.entity.Message;

public class MessageUtil {

	public Message sendmesssage(Integer receiverUserId,Integer status,String projectName,String rejectReason) {
		
		Message message = new Message();
		message.setReceiverUserId(receiverUserId);
		message.setCreateTime(new Date());
		message.setIsRead(0);
		if(status == 2)
		{
			message.setTitle("初审消息！");
			message.setContent("恭喜，您的项目--"+projectName +"--已经通过初审了！");
		}else if(status == 5)
		{
			message.setTitle("立项消息！");
			message.setContent("恭喜，您的项目--"+projectName +"--已经成功立项！");
		}
		else if(status == 6)
		{
			message.setTitle("立项消息！");
			message.setContent("很抱歉，您的项目--"+projectName +"--立项失败！");
		}
		else if(status == 7)
		{
			message.setTitle("中期检查消息！");
			message.setContent("恭喜，您的项目--"+projectName +"--已经成功通过中期检查！");
		}
		else if(status == 8)
		{
			message.setTitle("中期检查消息！");
			message.setContent("很抱歉，您的项目--"+projectName +"--没有通过中期检查！驳回原因"+rejectReason+"。");
		}
		
		else if(status == 9)
		{
			message.setTitle("结题验收消息！");
			message.setContent("恭喜，您的项目--"+projectName +"--已经成功通过结题验收！");
		}
		else if(status == 10)
		{
			message.setTitle("结题验收消息！");
			message.setContent("很抱歉，您的项目--"+projectName +"--没有通过结题验收！驳回原因:"+rejectReason+"。");
		}
		
		
		return message;
		
	}
}
