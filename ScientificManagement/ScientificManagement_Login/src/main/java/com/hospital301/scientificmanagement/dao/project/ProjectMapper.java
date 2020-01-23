package com.hospital301.scientificmanagement.dao.project;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/** 
* @author 作者 
* @version 创建时间：2020年1月2日 下午8:59:43 
* 类说明 
*/
@Mapper
public interface ProjectMapper 
{
	public List<List<?>> getPageListAndTotal (Map<String,Object> conditionMap);
	
	public List<List<?>> getPageListAndTotalByUser (Map<String,Object> conditionMap);
	
	public List<List<?>> getPageListAndTotalByOrg (Map<String,Object> conditionMap);
}
