package com.asamu.plmp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asamu.plmp.pojo.entity.ProjectinfoDO;

public interface ProjectDAO extends JpaRepository<ProjectinfoDO, Integer>{
	
	@Query("select u from ProjectinfoDO u where u.directorUserId = ?1 and u.status = ?2")
	List<ProjectinfoDO> findByIdAndStatus(Integer directorUserId,Integer status);
}
