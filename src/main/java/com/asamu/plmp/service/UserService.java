package com.asamu.plmp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserDO findUserById(Integer userid) {
		
		return userDAO.findUserDoById(userid);
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
		UserDO userDO= findUserById(userid);
		userDO.setUpdateTime(new java.sql.Timestamp(System.currentTimeMillis()));
		userDAO.save(userDO);
	}

	public void addUser(UserDO user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public JsonResult login(UserDO user) {
		UserDO realUser = userDAO.findByUsername(user.getUsername());
		if(realUser==null) {
			return new JsonResult(201,"用户名不存在");
		}
		if(!realUser.getPassword().equals(user.getPassword())) {
			return new JsonResult(201,"密码错误");
		}
		return JsonResult.success();
	}
	


}
