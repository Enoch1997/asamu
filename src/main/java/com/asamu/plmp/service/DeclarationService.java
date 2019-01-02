package com.asamu.plmp.service;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public void updateRule(DeclarationRule declarationRule) {
		// TODO Auto-generated method stub
		declartionDAO.save(declarationRule);

		
	}
	public List<DeclarationRule> findByType(Integer type) {
		// TODO Auto-generated method stub
		return declartionDAO.findByType(type);
	}
}
