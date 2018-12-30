package com.asamu.plmp.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_expert_review")
public class ExpertReview extends BaseEntity{
	@Column(name="project_id",length=5)
	private Integer projectId;
	
	@Column(length=5)
	private Integer score;
	
	@Column(length=255)
	private String comment;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ExpertReview [projectId=" + projectId + ", score=" + score + ", comment=" + comment + "]";
	}
	
	
	
	
}
