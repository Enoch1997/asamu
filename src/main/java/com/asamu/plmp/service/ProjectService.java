package com.asamu.plmp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.AllocationDAO;
import com.asamu.plmp.dao.ProjectDAO;
import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.ExpertReview;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.entity.UserDO;
import com.asamu.plmp.util.ProjectUtil;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AllocationDAO allocationDAO;
	
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
		
		List<ProjectinfoDO> list1 = projectUtil.reLevelName(size, list);
		List<ProjectinfoDO> list2 =	projectUtil.reStatusName(size, list1);
		
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

	public List<ProjectinfoDO> findAllProject() {
		// TODO Auto-generated method stub
		List<ProjectinfoDO> list = projectDAO.findAll();
		Integer size = list.size();
		
		for (int i = 0; i < size; i++) {
			UserDO userDO = userDAO.findUserDoById(list.get(i).getDirectorUserId());
			list.get(i).setDirectorUserName(userDO.getRealName());
		}
		
		List<ProjectinfoDO> list1 = projectUtil.reLevelName(size, list);
		List<ProjectinfoDO> list2 =	projectUtil.reStatusName(size, list1);
		return list2;
	}

	public List<ProjectinfoDO> findProjectByExpertIdAndStatus(Integer expertId, Integer status) {
		// TODO Auto-generated method stub
		List<ExpertReview> list = allocationDAO.findByExpertId(expertId);
		Integer size = list.size();
		List<ProjectinfoDO> list1 = new ArrayList<>();
		for(int i = 0; i< size ; i++)
		{
			ProjectinfoDO projectinfoDO = projectDAO.findByProjectIdAndStatus(list.get(i).getProjectId(),status);
			if(projectinfoDO != null)
			{
				String name = userDAO.findUserDoById(projectinfoDO.getDirectorUserId()).getRealName();
				projectinfoDO.setDirectorUserName(name);
				list1.add(projectinfoDO);
			}
		}
		Integer listSize = list1.size();
		 list1 = projectUtil.reLevelName(listSize, list1);
		 list1 = projectUtil.reStatusName(listSize, list1);
		
		
		return list1;
	}


}
