package com.asamu.plmp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asamu.plmp.pojo.entity.RoleDO;

public interface RoleDAO extends JpaRepository<RoleDO, Integer>{
		
	RoleDO findRoleDOById (Integer id);
}
