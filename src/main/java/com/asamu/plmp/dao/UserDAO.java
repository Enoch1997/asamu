package com.asamu.plmp.dao;


import org.springframework.data.jpa.repository.JpaRepository;



import com.asamu.plmp.pojo.entity.UserDO;

public interface UserDAO extends JpaRepository<UserDO, Integer>{
	void deleteById(Integer id);
	UserDO findUserDoById(Integer id);
	
	

	/*@Modifying
	@Query("update t_user as c set c.realName = user.realName,c.password = user.password,c.unit = user.unit,c.tel = user.tel,c.email = user.email,c where c.userid = :userid")
	void update(Integer userid, UserDO user);*/
}
