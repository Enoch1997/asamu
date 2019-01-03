package com.asamu.plmp.pojo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_material_review")
public class MaterialReview extends BaseEntity{
	@Column(name="project_id",length=5)
	private Integer projectId;
	
	@Column(name="project_period",length=5)
	private Integer projectPeriod;
	
	
	@Column(name="review_result",length=5)
	private Integer reviewResult;
	
	@Column(name="reject_reason",length=255)
	private String rejectReason;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public Integer getProjectPeriod() {
		return projectPeriod;
	}

	public void setProjectPeriod(Integer projectPeriod) {
		this.projectPeriod = projectPeriod;
	}

	public Integer getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(Integer reviewResult) {
		this.reviewResult = reviewResult;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	@Override
	public String toString() {
		return "MaterialReview [projectId=" + projectId + ", projectPeriod=" + projectPeriod + ", reviewResult="
				+ reviewResult + ", rejectReason=" + rejectReason + "]";
	}

	
	

}
