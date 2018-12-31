package com.asamu.plmp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.UserDO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserDO findByUserId(Integer userid) {
		
		return null;
	}
	
	public List<UserDO> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	public void deleteUser(Integer userid) {
		// TODO Auto-generated method stub
		userDAO.deleteById(userid);
	}
	@Transactional
	public void updateUser(Integer userid,UserDO user) {
		// TODO Auto-generated method stub
		//userDAO.update(userid,user);
		
	}

	public void addUser(UserDO user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}
	


}
