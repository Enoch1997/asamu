package com.asamu.plmp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.RoleMenuDAO;
import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.MenuDO;
import com.asamu.plmp.pojo.entity.RoleMenuDO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.pojo.vo.JsonResult;

@Service
public class MenuService {
	private Logger logger=LoggerFactory.getLogger(MenuService.class) ;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleMenuDAO menuRoleDAO;
	public JsonResult getUserMenu(Integer userId) {
		Optional<UserDO> op = userDAO.findById(userId);
		UserDO userDO = op.get();
		List<RoleMenuDO> list = menuRoleDAO.getByRoleId(userDO.getRoleId());
		logger.info("menuList:"+list);
		List<MenuDO> result=new ArrayList<>();
		for(RoleMenuDO bean:list) {
			result.add(bean.getMenu());
		}
		return JsonResult.success(result);
	}
}
