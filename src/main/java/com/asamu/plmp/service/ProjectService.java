package com.asamu.plmp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asamu.plmp.dao.ProjectDAO;
import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.entity.UserDO;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private UserDAO userDAO;
	
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
	public List<ProjectinfoDO> findProjectByStatus(Integer id) {
		// TODO Auto-generated method stub
		return projectDAO.findByStatus(id);
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
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i).setDirectorUserName(userDO.getRealName());
			if(list.get(i).getApplyLevel().equals("1"))
			{
				list.get(i).setLevelName("校级一类");
			}
			else if(list.get(i).getApplyLevel().equals("2"))
			{
				list.get(i).setLevelName("校级二类");
			}
			else {
				list.get(i).setLevelName("");
			}
			
			Integer tempInteger = list.get(i).getStatus();
			switch (tempInteger) {
			case 0:
			    list.get(i).setStatusName("保存");
			    break;
			case 1:
				list.get(i).setStatusName("已提交");
			    break;
			case 2:
				list.get(i).setStatusName("初审通过");
			    break;
			case 3:
			    list.get(i).setStatusName("立项评审中");
			    break;
			case 4:
				list.get(i).setStatusName("立项评审完成");
			    break;
			case 5:
				list.get(i).setStatusName("立项");
			    break;
			case 6:
			    list.get(i).setStatusName("不立项");
			    break;
			case 7:
				list.get(i).setStatusName("中期检查通过");
			    break;
			case 8:
				list.get(i).setStatusName("中期检查待整");
			    break;
			case 9:
				list.get(i).setStatusName("已结题");
			    break;
			case 10:
				list.get(i).setStatusName("结题验收整改");
			    break;
			default:
				list.get(i).setStatusName("");
			}
		}
		
		return list;
	}


}
