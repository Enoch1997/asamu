package com.asamu.plmp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.RoleDAO;
import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.RoleDO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;

@Service
public class UserService {

	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private UserDAO userDAO;
	
	public UserDO findUserById(Integer userid) {
		
		return userDAO.findUserDoById(userid);
	}
	
	public List<UserDO> findAll() {
		// TODO Auto-generated method stub
		List<UserDO> list = userDAO.findAll();
		Integer size = list.size();
		for(int i = 0;i < size;i++)
		{
			int roleid = list.get(i).getRoleId();
			RoleDO role = roleDAO.findRoleDOById(roleid);
			list.get(i).setRolename(role.getName());
		}

		return list;
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
		return JsonResult.success(realUser);
	}

	public List<UserDO> findByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<UserDO> list = userDAO.findByRoleID(roleId);
		return list;
	}
	


}
