package com.asamu.plmp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asamu.plmp.pojo.entity.DeclarationRule;


public interface DeclarationDAO extends JpaRepository<DeclarationRule, Integer> {



}
