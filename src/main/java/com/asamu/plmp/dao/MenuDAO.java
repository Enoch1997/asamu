package com.asamu.plmp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asamu.plmp.pojo.entity.MenuDO;

public interface MenuDAO extends JpaRepository<MenuDO, Integer> {

}
