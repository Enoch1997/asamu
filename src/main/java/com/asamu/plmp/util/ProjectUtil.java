package com.asamu.plmp.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.asamu.plmp.dao.UserDAO;
import com.asamu.plmp.pojo.entity.ProjectInfoExtend;
import com.asamu.plmp.pojo.entity.ProjectinfoDO;
import com.asamu.plmp.pojo.entity.UserDO;

public class ProjectUtil {

	
	public List<ProjectinfoDO> reLevelName(Integer size,List<ProjectinfoDO> list)
	{
		
		for (int i = 0; i < size; i++) {

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
		}
		return list;
	}
	
	public List<ProjectInfoExtend> reLevelNameExtend(Integer size,List<ProjectInfoExtend> list)
	{
		
		for (int i = 0; i < size; i++) {

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
		}
		return list;
	}
	
	public List<ProjectinfoDO> reStatusName(Integer size,List<ProjectinfoDO> list)
	{
		
		for (int i = 0; i < size; i++) {
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
