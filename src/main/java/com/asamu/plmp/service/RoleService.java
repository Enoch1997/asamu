package com.asamu.plmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.RoleDAO;
import com.asamu.plmp.pojo.entity.RoleDO;

@Service
public class RoleService {

	@Autowired
	private RoleDAO roleDAO;
	public List<RoleDO> findAll() {

		return roleDAO.findAll();
	}

}
