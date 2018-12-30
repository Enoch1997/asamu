package com.asamu.plmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.DeclarationDAO;
import com.asamu.plmp.pojo.entity.DeclarationRule;


@Service
public class DeclarationService {
	@Autowired
	private DeclarationDAO declartionDAO;
	
	public List<DeclarationRule> findAll() {
		// TODO Auto-generated method stub
		return declartionDAO.findAll();
	}
}
