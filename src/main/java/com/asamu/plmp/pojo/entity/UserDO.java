package com.asamu.plmp.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户实体
 * @author Enoch
 *
 */
@Entity
@Table(name="t_user")
public class UserDO extends BaseEntity{

	@Column(length=50)
	private String username;
	
	@Column(length=50)
	private String password;
	
	@Column(length=50,name="real_name")
	private String realName;
	
	//所属部门
	@Column(length=50)
	private String unit;
	
	@Column(length=20)
	private String tel;
	
	@Column(length=50)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@Column
	private Integer status;
	
	@Column
	private Integer remarks;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRemarks() {
		return remarks;
	}

	public void setRemarks(Integer remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "UserDO [username=" + username + ", password=" + password + ", realName=" + realName + ", unit=" + unit
				+ ", tel=" + tel + ", email=" + email + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", roleId=" + roleId + ", status=" + status + ", remarks=" + remarks + "]";
	}
	
	
/*	create table t_user(
			id				int unsigned auto_increment comment '主键id',
			username		varchar(50) not null comment '用户名',
			password		varchar(50) not null comment '密码',
			realName		varchar(50) comment '真实姓名',
			unit			varchar(50) comment '所属部门',
			tel 			varchar(20) comment '手机号',
			email  			varchar(50) comment '邮箱',
			create_time		datetime comment '创建时间',
			update_time		datetime comment '更新时间',
			role_id			int comment '用户角色',
			status			tinyint unsigned default '1' comment '状态：0表示不可用,1可用',
			remarks			varchar(255) comment '备注',
			primary key(id)
		)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='用户表';*/
}
