package com.asamu.plmp.pojo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_role_menu")
public class RoleMenuDO extends BaseEntity{

	@JoinColumn(name="role_id")
	@ManyToOne
	private RoleDO role;
	
	@JoinColumn(name="menu_id")
	@ManyToOne
	private MenuDO menu;
}
