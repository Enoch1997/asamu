package com.asamu.plmp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asamu.plmp.pojo.entity.ExpertReview;

public interface AllocationDAO extends JpaRepository<ExpertReview, Integer>{

}
