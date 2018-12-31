package com.asamu.plmp.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_projectinfo")
public class ProjectinfoDO extends BaseEntity {
	
	@Column(length=50)
	private String name;
	
	@Column(length=50)
	private String apply_level;
	
	@Column(length=50)
	private String feild;
	
	@Column(length=255)
	private String members;
	
	@Column(length=1000)
	private String promise;
	
	@Column(name="director_user_id",length=10)
	private Integer directorUserId;
	
	@Column(name="director_tel",length=20)
	private String directorTel;
	
	@Column(name="director_email",length=50)
	private String directorEmail;
	
	@Column(length=5)
	private Integer status;
	
	@Column(name="declaration_material_id",length=5)
	private Integer declarationMaterialId;
	
	@Column(name="midterm_material_id",length=5)
	private Integer midterMaterialId;
	
	@Column(name="end_material_id",length=5)
	private Integer endMaterialId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApply_level() {
		return apply_level;
	}

	public void setApply_level(String apply_level) {
		this.apply_level = apply_level;
	}

	public String getFeild() {
		return feild;
	}

	public void setFeild(String feild) {
		this.feild = feild;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getPromise() {
		return promise;
	}

	public void setPromise(String promise) {
		this.promise = promise;
	}

	
	
	public Integer getDirectorUserId() {
		return directorUserId;
	}

	public void setDirectorUserId(Integer directorUserId) {
		this.directorUserId = directorUserId;
	}

	public String getDirectorTel() {
		return directorTel;
	}

	public void setDirectorTel(String directorTel) {
		this.directorTel = directorTel;
	}

	public String getDirectorEmail() {
		return directorEmail;
	}

	public void setDirectorEmail(String directorEmail) {
		this.directorEmail = directorEmail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDeclarationMaterialId() {
		return declarationMaterialId;
	}

	public void setDeclarationMaterialId(Integer declarationMaterialId) {
		this.declarationMaterialId = declarationMaterialId;
	}

	public Integer getMidterMaterialId() {
		return midterMaterialId;
	}

	public void setMidterMaterialId(Integer midterMaterialId) {
		this.midterMaterialId = midterMaterialId;
	}

	public Integer getEndMaterialId() {
		return endMaterialId;
	}

	public void setEndMaterialId(Integer endMaterialId) {
		this.endMaterialId = endMaterialId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "ProjectinfoDO [name=" + name + ", apply_level=" + apply_level + ", feild=" + feild + ", members="
				+ members + ", promise=" + promise + ", directorUserId=" + directorUserId + ", directorTel="
				+ directorTel + ", directorEmail=" + directorEmail + ", status=" + status + ", declarationMaterialId="
				+ declarationMaterialId + ", midterMaterialId=" + midterMaterialId + ", endMaterialId=" + endMaterialId
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
