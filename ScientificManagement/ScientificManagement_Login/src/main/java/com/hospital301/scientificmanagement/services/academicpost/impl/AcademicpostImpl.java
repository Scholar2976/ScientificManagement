package com.hospital301.scientificmanagement.services.academicpost.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccb.sm.entities.ProjectAcademyPost;
import com.hospital301.scientificmanagement.dao.academicPost.AcademyPostMapper;
import com.hospital301.scientificmanagement.services.BaseServiceImpl;
import com.hospital301.scientificmanagement.services.academicpost.Academicpost;


@Service
public class AcademicpostImpl extends BaseServiceImpl implements Academicpost 
{
	@Autowired
	private AcademyPostMapper academyPostdao;

	public Map QueryTableInfo(Map<String, Object> map)
	{
		List list = academyPostdao.getAcademyListOfPage(map);
		Integer total = academyPostdao.getAcademyListTotal(map);
		Map resultMap = new HashMap<>();
		resultMap.put("page", list);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	public Object insert(Object obj) {
		ProjectAcademyPost projectAcademyPost = (ProjectAcademyPost) obj;
		Map idMap = new HashMap<>();
		idMap.put("id",projectAcademyPost.getId() );
		
		int count = academyPostdao.getAcademyListTotal(idMap);
		if(count>0)
		{
			academyPostdao.UpdateById(projectAcademyPost);
		}else
		{
			academyPostdao.Insert(projectAcademyPost);
		}
		ProjectAcademyPost result = (ProjectAcademyPost)academyPostdao.getAcademyList(idMap).get(0);
		return result;
	}

	@Override
	public Boolean logicDelete(Map<String, Object> map) {
		Integer count = academyPostdao.LogicDelete(map);
		if(count>0)
		{
			return true;
		}
		return false;
	}
	
	
}
