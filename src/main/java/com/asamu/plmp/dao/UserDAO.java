package com.asamu.plmp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.entity.UserDO;

public interface UserDAO extends JpaRepository<UserDO, Integer>{
	void deleteById(Integer id);
	UserDO findUserDoById(Integer id);
	
	//根据用户名查找
	UserDO findByUsername(String username);
	
	@Query("select u from UserDO u where u.roleId = ?1")
	List<UserDO> findByRoleID(Integer roleId);

	/*@Modifying
	@Query("update t_user as c set c.realName = user.realName,c.password = user.password,c.unit = user.unit,c.tel = user.tel,c.email = user.email,c where c.userid = :userid")
	void update(Integer userid, UserDO user);*/
}
