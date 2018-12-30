package com.asamu.plmp.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_material_review")
public class MaterialReview extends BaseEntity{
	@Column(name="project_id",length=5)
	private Integer projectId;
	
	@Column(name="project_name",length=50)
	private String projectName;
	
	@Column(name="project_period",length=5)
	private Integer projectPeriod;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="finish_time")
	private Date finishTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	
	@Column(name="material_description",length=255)
	private String materialDescription;
	
	@Column(name="review_result",length=5)
	private Integer reviewResult;
	
	@Column(name="reject_reason",length=255)
	private Integer rejectReason;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectPeriod() {
		return projectPeriod;
	}

	public void setProjectPeriod(Integer projectPeriod) {
		this.projectPeriod = projectPeriod;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public Integer getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(Integer reviewResult) {
		this.reviewResult = reviewResult;
	}

	public Integer getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(Integer rejectReason) {
		this.rejectReason = rejectReason;
	}

	@Override
	public String toString() {
		return "MaterialReview [projectId=" + projectId + ", projectName=" + projectName + ", projectPeriod="
				+ projectPeriod + ", finishTime=" + finishTime + ", deadline=" + deadline + ", materialDescription="
				+ materialDescription + ", reviewResult=" + reviewResult + ", rejectReason=" + rejectReason + "]";
	}
	
	

}
