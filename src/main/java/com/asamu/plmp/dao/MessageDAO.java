package com.asamu.plmp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asamu.plmp.pojo.entity.Message;



public interface MessageDAO extends JpaRepository<Message, Integer>{

	List<Message> findByReceiverUserId(Integer userId);

}
