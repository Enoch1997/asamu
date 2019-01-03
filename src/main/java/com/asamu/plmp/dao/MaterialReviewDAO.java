package com.asamu.plmp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asamu.plmp.pojo.entity.MaterialReview;

public interface MaterialReviewDAO extends JpaRepository<MaterialReview, Integer>{

	@Query("select u from MaterialReview u where u.projectId = ?1")
	MaterialReview findByProjrctId(Integer projectId);

}
