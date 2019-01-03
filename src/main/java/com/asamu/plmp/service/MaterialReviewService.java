package com.asamu.plmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.MaterialReviewDAO;
import com.asamu.plmp.dao.ProjectDAO;
import com.asamu.plmp.pojo.entity.MaterialReview;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;

@Service
public class MaterialReviewService {

	@Autowired
	MaterialReviewDAO materialReviewDAO;
	@Autowired
	private ProjectDAO projectDAO;
	
	//驳回中期材料
	public void setMidReject(Integer projectId, Integer reviewResult, String rejectReason) {
		// TODO Auto-generated method stub
			MaterialReview materReview = materialReviewDAO.findByProjrctId(projectId);
			if(materReview != null)
			{
				materReview.setRejectReason(rejectReason);
				materReview.setReviewResult(reviewResult);
				materReview.setProjectPeriod(1);
				materialReviewDAO.save(materReview);
			}
			else {
				MaterialReview newMaterialReview = new MaterialReview();
				newMaterialReview.setProjectId(projectId);
				newMaterialReview.setProjectPeriod(1);
				newMaterialReview.setRejectReason(rejectReason);
				newMaterialReview.setReviewResult(reviewResult);
				materialReviewDAO.save(newMaterialReview);
				
			}
			
			//驳回后 置项目中期材料为空
			ProjectinfoDO projectinfoDO = projectDAO.findById(projectId).get();
			projectinfoDO.setMidtermMaterialId(null);
			projectDAO.save(projectinfoDO);
			
	}

	public void setEndReject(Integer projectId, Integer reviewResult, String rejectReason) {
		// TODO Auto-generated method stub
			MaterialReview materReview = materialReviewDAO.findByProjrctId(projectId);
			if(materReview != null)
			{
				materReview.setRejectReason(rejectReason);
				materReview.setReviewResult(reviewResult);
				materReview.setProjectPeriod(2);
				materialReviewDAO.save(materReview);
			}
			else {
				MaterialReview newMaterialReview = new MaterialReview();
				newMaterialReview.setProjectId(projectId);
				newMaterialReview.setProjectPeriod(2);
				newMaterialReview.setRejectReason(rejectReason);
				newMaterialReview.setReviewResult(reviewResult);
				materialReviewDAO.save(newMaterialReview);
			}
			
			//驳回后 置项目结题材料为空
			ProjectinfoDO projectinfoDO = projectDAO.findById(projectId).get();
			projectinfoDO.setEndMaterialId(null);
			projectDAO.save(projectinfoDO);
			
	}
}
