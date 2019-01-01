package com.asamu.plmp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asamu.plmp.pojo.entity.ProjectinfoDO;

public interface ProjectDAO extends JpaRepository<ProjectinfoDO, Integer>{
	
	@Query("select u from ProjectinfoDO u where u.directorUserId = ?1 and u.status = ?2")
	List<ProjectinfoDO> findByIdAndStatus(Integer directorUserId,Integer status);
	
	@Query("select u from ProjectinfoDO u where u.directorUserId = ?1")
	List<ProjectinfoDO> findByUserId(Integer directorUserId);
	
	@Query("select u from ProjectinfoDO u where u.status = ?1")
	List<ProjectinfoDO> findByStatus(Integer status);
	

	@Modifying
	@Query(value="UPDATE ProjectinfoDO xe SET xe.status= :status WHERE xe.id= :id")
	void update(@Param("id")Integer id, @Param("status")Integer status);
}
