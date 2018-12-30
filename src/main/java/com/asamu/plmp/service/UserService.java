package com.asamu.plmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.UserDO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<UserDO> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

}
