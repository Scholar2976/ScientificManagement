package com.hospital301.scientificmanagement.services.project.impl;

import java.text.Format;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccb.sm.response.ResponsePage;
import com.hospital301.scientificmanagement.dao.project.ProjectMapper;
import com.hospital301.scientificmanagement.services.project.ProjectService;

/** 
* @author 作者 
* @version 创建时间：2020年1月2日 下午8:58:11 
* 类说明 
*/
@Service
public class ProjectImpl implements ProjectService
{
	@Autowired
	private ProjectMapper projectDao;
	
	public Object QueryTableInfoByPage(Map<String, Object> conditionMap) {
		List<List<?>> daolist = projectDao.getPageListAndTotal(conditionMap);
		if(daolist.size()>0)
		{
			List list = daolist.get(0);
			Integer total = (Integer) daolist.get(1).get(0);
			Map resultMap = new HashMap<>();
			
			resultMap.put("page", list);
			resultMap.put("total", total);
			return Format(resultMap);
		}else
		{
			return null;
		}

	}
	
	public Object QueryTableInfoByUser(Map<String, Object> conditionMap) {
		List<List<?>> daolist = projectDao.getPageListAndTotalByUser(conditionMap);
		if(daolist.size()>0)
		{
			List list = daolist.get(0);
			Integer total = (Integer) daolist.get(1).get(0);
			Map resultMap = new HashMap<>();
			resultMap.put("page", list);
			resultMap.put("total", total);
			return Format(resultMap);
		}else
		{
			return null;
		}

	}
	
	public Object QueryTableInfoByOrg(Map<String, Object> conditionMap) {
		List<List<?>> daolist = projectDao.getPageListAndTotalByOrg(conditionMap);
		if(daolist.size()>0)
		{
			List list = daolist.get(0);
			Integer total = (Integer) daolist.get(1).get(0);
			Map resultMap = new HashMap<>();
			resultMap.put("page", list);
			resultMap.put("total", total);
			return Format(resultMap);
		}else
		{
			return null;
		}

	}
	
	private Object Format(Map<String,Object> resultMap)
	{
		Map countmap = new HashMap();
		countmap.put("totalRec", resultMap.get("total"));
		ResponsePage rspage = new ResponsePage();
		rspage.setList(resultMap.get("page"));
		rspage.setTxnCommCom(countmap);
		return rspage;
	}
}
