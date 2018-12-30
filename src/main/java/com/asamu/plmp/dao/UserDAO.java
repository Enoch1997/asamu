package com.asamu.plmp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asamu.plmp.pojo.entity.UserDO;

public interface UserDAO extends JpaRepository<UserDO, Integer>{

}
