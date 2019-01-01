package com.asamu.plmp.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asamu.plmp.dao.MessageDAO;
import com.asamu.plmp.pojo.entity.Message;



@Service
public class MessageService {
	@Autowired
	private MessageDAO messageDAO;

	public List<Message> findMessageByUserId(Integer userId)
	{

		List<Message> list1 = messageDAO.findByReceiverUserId(userId);
		int size = list1.size();
		for (int i = 0; i < size; i++) {
		list1.get(i).setRemark();
		}
	   return list1;
	}
	
	@Transactional
	public void updateMessageById(Integer id,Integer isRead)
	{
		messageDAO.updateIsRead(id,isRead);
	}
}
