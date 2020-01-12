package com.hospital301.scientificmanagement.services.organization.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital301.scientificmanagement.dao.organization.OrganizationDao;
import com.hospital301.scientificmanagement.services.organization.OrganizationService;

/** 
* @author 作者 
* @version 创建时间：2020年1月4日 下午8:37:13 
* 类说明 
*/
@Service
public class OrganizationServiceImpl implements OrganizationService 
{
	@Autowired
	private OrganizationDao organizationDao;
	@Override
	public Object QueryTableInfoByPage(Map<String, Object> conditionMap) {
		List<List<?>> daolist = organizationDao.getPageListAndTotal(conditionMap);
		
		if(daolist.size()>0)
		{
			List list = daolist.get(0);
			Integer total = (Integer) daolist.get(1).get(0);
			Map resultMap = new HashMap<>();
			resultMap.put("page", list);
			resultMap.put("total", total);
			return resultMap;
		}else
		{
			return null;
		}
	}
	@Override
	public Integer updateParent(String tableName ,Map<String, Object> conditionMap) {
		// TODO Auto-generated method stub
		Integer integer =organizationDao.baseDeleteByMap(tableName, conditionMap);
		if(integer>0)
		{
			integer = organizationDao.updateParentNode(conditionMap);
		}
		return integer;
	}
	@Override
	public Object get(Map<String, Object> conditionMap) 
	{
		return organizationDao.get(conditionMap);
	}

}
