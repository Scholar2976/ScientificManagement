package com.hospital301.scientificmanagement.dao.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/** 
* @author 作者 
* @version 创建时间：2020年1月20日 下午2:34:44 
* 类说明 
*/
@Mapper
public interface RoleMapper 
{
	public List<List<?>> getRoleResultByPageAndCount(Map<String,Object> conditionMap);
}
