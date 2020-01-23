package com.hospital301.scientificmanagement.services.organization;

import java.util.Map;

/** 
* @author 作者 
* @version 创建时间：2020年1月4日 下午8:36:43 
* 类说明 
*/
public interface OrganizationService 
{
	public Object QueryTableInfoByPage (Map<String ,Object> conditionMap);
	
	public Integer updateParent(String tableName ,Map<String, Object> conditionMap);
	
	public Object get(Map<String, Object> conditionMap);
}
