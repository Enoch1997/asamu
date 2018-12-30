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
	
	@Column(length=50)
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
