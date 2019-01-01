package com.asamu.plmp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asamu.plmp.pojo.entity.Message;



public interface MessageDAO extends JpaRepository<Message, Integer>{

	List<Message> findByReceiverUserId(Integer userId);

	@Modifying
	@Query(value="UPDATE Message xe SET xe.isRead= :isRead WHERE xe.id= :id")
	void updateIsRead(@Param("id")Integer id, @Param("isRead")Integer isRead);
	
	

}
