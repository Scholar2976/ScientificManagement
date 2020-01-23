package com.hospital301.scientificmanagement.services.scientificpayoffs.report;

import java.util.Map;

import com.ccb.sm.entities.User;
import com.hospital301.scientificmanagement.util.Report;

public interface ReportService 
{
	public Object QueryBySqlToResult(Report repory, Map conditionMap);
	
	/**
	 * 校验用户权限
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Object VerifyUserPermissions(User user,Map<String,Object> conditionMap) throws Exception;
}
