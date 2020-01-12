package com.hospital301.scientificmanagement.services.parameter.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ccb.sm.entities.Parameter;
import com.ccb.sm.entities.ParameterValue;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.dao.parameter.ParameterValueDao;
import com.hospital301.scientificmanagement.services.BaseServiceImpl;
import com.hospital301.scientificmanagement.services.parameter.ParameterService;
import com.hospital301.scientificmanagement.util.Util;

import ch.qos.logback.classic.db.names.TableName;


@Service("ParameterServiceImpl")
public class ParameterServiceImpl extends BaseServiceImpl implements ParameterService 
{
	@Autowired
	private ParameterValueDao parameterValueDao;
	
	public Object get(Map<String,Object> conditionMap) throws Exception
	{
		String range = conditionMap.get("range").toString();
		conditionMap.remove("range");
//		conditionMap.put("name", "workCategoryType");
		List<Map<String,Object>> list = QueryTableInfo("parameter",conditionMap);
		if(list.size() == 0)
		{
			return "获取数据为空";
		}
		if("all".equals(range))
		{
			conditionMap.put("parameter", conditionMap.get("name"));
			conditionMap.remove("name");
		}else
		{
			conditionMap.put("parameter", conditionMap.get("name"));
			conditionMap.remove("name");
			conditionMap.put("deleted",false);
		}
		List<Map<String,Object>> parameterValuelist = QueryTableInfo("parameter_value",conditionMap);
		Parameter parameter = (Parameter) Util.mapToBean(list.get(0), Parameter.class);
		List<ParameterValue> list2 = new ArrayList<ParameterValue>();
		for(Map map :parameterValuelist )
		{
			list2.add((ParameterValue) Util.mapToBean(map, ParameterValue.class));
		}
		String srcjsonstr = JsonUtil.getJsonResult(parameter);
		Object returnJsonStr = JsonUtil.addJsonNode(srcjsonstr, list2, null, "values");
		return returnJsonStr;
		
	}

	@Override
	public Object getTree(Map<String, Object> conditionMap) {
		String range = conditionMap.get("range").toString();
		conditionMap.remove("range");
		if("all".equals(range))
		{
			conditionMap.put("parameter", conditionMap.get("name"));
			conditionMap.remove("name");
		}else
		{
			conditionMap.put("parameter", conditionMap.get("name"));
			conditionMap.remove("name");
			conditionMap.put("deleted",false);
		}
		List<ParameterValue> resultlist= parameterValueDao.getTree(conditionMap);
		return resultlist;
	}
}
