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

	public RoleDO getRole() {
		return role;
	}

	public void setRole(RoleDO role) {
		this.role = role;
	}
	
	public MenuDO getMenu() {
		return menu;
	}

	public void setMenu(MenuDO menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "RoleMenuDO [role=" + role + ", menu=" + menu + "]";
	}
	
	
}
