package com.asamu.plmp.pojo.entity;

import javax.persistence.Transient;

public class ProjectInfoExtend extends ProjectinfoDO{
	@Transient
	private Integer score;
	@Transient
	private String comment;
	@Transient
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Transient
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "ProjectInfoExtend [score=" + score + ", comment=" + comment + "]";
	}
	
	
}
