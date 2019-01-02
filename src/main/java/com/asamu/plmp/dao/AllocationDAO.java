package com.asamu.plmp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asamu.plmp.pojo.entity.ExpertReview;

public interface AllocationDAO extends JpaRepository<ExpertReview, Integer>{

	
	@Query("select u from ExpertReview u where u.expertId = ?1")
	List<ExpertReview> findByExpertId(Integer expertId);
}
