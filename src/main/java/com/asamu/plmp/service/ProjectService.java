package com.asamu.plmp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.ProjectDAO;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	public void saveProject(ProjectinfoDO projectinfoDO) {
		// TODO Auto-generated method stub
		projectDAO.save(projectinfoDO);
	}
	
	@Transactional
	public List<ProjectinfoDO> findProject(Integer directorUserId, Integer status) {
		// TODO Auto-generated method stub
		return projectDAO.findByIdAndStatus(directorUserId,status);
	}

}
