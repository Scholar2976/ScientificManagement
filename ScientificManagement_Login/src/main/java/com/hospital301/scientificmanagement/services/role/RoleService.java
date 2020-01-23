package com.hospital301.scientificmanagement.services.role;

import java.util.Map;


/** 
* @author 作者 
* @version 创建时间：2020年1月20日 下午2:32:50 
* 类说明 
*/
public interface RoleService 
{
	public Object QueryTableInfoByPage(Map<String, Object> conditionMap) throws Exception;
}
