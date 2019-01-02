package com.asamu.plmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.AllocationDAO;
import com.asamu.plmp.pojo.entity.ExpertReview;

@Service
public class AllocationService {
	@Autowired
	private AllocationDAO allocationDAO;
	@Autowired
	private ProjectService projectService;
	public void setAllocation(Integer proId, Integer expId) {
		// TODO Auto-generated method stub
		ExpertReview expertReview = new ExpertReview();
		
		expertReview.setExpertId(expId);
		expertReview.setProjectId(proId);
		allocationDAO.save(expertReview);		
		projectService.updateProjectStatus(proId,3);
		
	}

}
