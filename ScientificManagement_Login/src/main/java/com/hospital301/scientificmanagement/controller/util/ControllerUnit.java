package com.hospital301.scientificmanagement.controller.util;

import java.util.HashMap;
import java.util.Map;

/** 
* @author 作者 
* @version 创建时间：2020年1月7日 下午2:29:40 
* 类说明 
*/
public class ControllerUnit 
{
	public Map<String,Object> getByUserMap()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.LAB.getName());
		map.put("username", "admin");
		return map;
	}
	public Map<String,Object> getByOrgMap()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.LAB.getName());
		map.put("organization_id", "");
		return map;
	}

}
