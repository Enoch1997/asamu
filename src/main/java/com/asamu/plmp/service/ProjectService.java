package com.asamu.plmp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.ProjectDAO;
import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.util.ProjectUtil;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private UserDAO userDAO;
	
	private ProjectUtil projectUtil = new ProjectUtil();
	
	public void saveProject(ProjectinfoDO projectinfoDO) {
		// TODO Auto-generated method stub
		projectDAO.save(projectinfoDO);
	}
	
	@Transactional
	public List<ProjectinfoDO> findProject(Integer directorUserId, Integer status) {
		// TODO Auto-generated method stub
		return projectDAO.findByIdAndStatus(directorUserId,status);
	}
	
	@Transactional
	public ProjectinfoDO findProject(Integer id) {
		// TODO Auto-generated method stub
		return projectDAO.findByUserId(id).get(0);
	}
	
	@Transactional
	public List<ProjectinfoDO> findProjectByStatus(Integer status) {
		// TODO Auto-generated method stub
		List<ProjectinfoDO> list = projectDAO.findByStatus(status);
		Integer size = list.size();
		
		for (int i = 0; i < size; i++) {
			UserDO userDO = userDAO.findUserDoById(list.get(i).getDirectorUserId());
			list.get(i).setDirectorUserName(userDO.getRealName());
		}
		
		List<ProjectinfoDO> list2 = projectUtil.reLevelName(size, list);
		
		for(int i = 0 ; i< size ;i++)
		{
			list2.get(i).setStatusName("等待初审");
		}
		return list2;
	}
	
	public ProjectinfoDO getProjectById(Integer id) {
		return  projectDAO.findById(id).get();
	}

	@Transactional
	public void updateProjectStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		projectDAO.update(id,status);
	}
	
	@Transactional
	public List<ProjectinfoDO> findProjectByUserId(Integer id) {
		// TODO Auto-generated method stub
		List<ProjectinfoDO> list = projectDAO.findByUserId(id);
		UserDO userDO = userDAO.findUserDoById(id);
		Integer size = list.size();
		String name = userDO.getRealName();
		
		for(int i = 0; i < size ; i++)
		{
			list.get(i).setDirectorUserName(name);
		}
		List<ProjectinfoDO> list1 = projectUtil.reLevelName(size, list);
		List<ProjectinfoDO> list2 = projectUtil.reStatusName(size, list1);
		
		return list2;
	}


}
