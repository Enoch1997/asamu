package com.asamu.plmp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asamu.plmp.pojo.entity.RoleMenuDO;

public interface RoleMenuDAO extends JpaRepository<RoleMenuDO,Integer>{
	
	@Query(value = "select * from t_role_menu where role_id=?1", nativeQuery = true)
	public List<RoleMenuDO> getByRoleId(Integer roleId);
}
