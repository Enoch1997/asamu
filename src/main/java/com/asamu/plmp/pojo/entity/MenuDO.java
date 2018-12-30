package com.asamu.plmp.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Enoch
 *
 */
@Entity
public class MenuDO extends BaseEntity{
	@Column(length=50)
	private String name;
	
	private String uri;
	
	private String description;
	
	private Integer pid;
	
	@Column(name="menu_level")
	private Integer menuLevel;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_Time")
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
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
		return "MenuDO [name=" + name + ", uri=" + uri + ", description=" + description + ", pid=" + pid
				+ ", menuLevel=" + menuLevel + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
	
/*	##########################
	##菜单表t_menu
	##########################
	create table t_menu(
		id				int unsigned auto_increment comment '主键id',
		name			varchar(50) not null comment '菜单名称',
		uri				varchar(255) comment '菜单uri',
		description		varchar(255) comment '描述',
		pid				int unsigned default '0' comment '父菜单id',
		menu_level		tinyint unsigned default '1' comment '菜单层级',
		create_time		datetime comment '创建时间',
		update_time		datetime comment '更新时间',
		primary key(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='菜单表';*/
}
