package com.hospital301.scientificmanagement.services.parameter;

import java.util.Map;

public interface ParameterService 
{
	public Object get(Map<String,Object> conditionMap) throws Exception;
	
	public Object getTree(Map<String,Object> conditionMap);

}
