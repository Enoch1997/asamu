package com.asamu.plmp.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_role")
public class RoleDO extends BaseEntity{
	@Column
	private String name;
	
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_Time")
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;
	
	private String remarks;//备注

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "RoleDO [name=" + name + ", description=" + description + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", remarks=" + remarks + "]";
	}
	
	
	
/*	##########################
	##角色表t_role
	##########################
	create table t_role(
		id				int unsigned auto_increment comment '主键id',
		name			varchar(50) not null comment '角色名称',
		description		varchar(255) comment '描述',
		create_time		datetime comment '创建时间',
		update_time		datetime comment '更新时间',
		remarks			varchar(255) comment '备注',
		primary key(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='角色表';*/
}
