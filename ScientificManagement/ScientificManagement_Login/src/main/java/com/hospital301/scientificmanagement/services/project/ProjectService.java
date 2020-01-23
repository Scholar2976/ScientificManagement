package com.hospital301.scientificmanagement.services.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @author 作者 
* @version 创建时间：2020年1月2日 下午8:56:46 
* 类说明 
*/
public interface ProjectService 
{
	public Object QueryTableInfoByPage(Map<String, Object> conditionMap) throws Exception;
	
	public Object QueryTableInfoByUser(Map<String, Object> conditionMap) throws Exception;
	
	public Object QueryTableInfoByOrg(Map<String, Object> conditionMap) throws Exception;
}
