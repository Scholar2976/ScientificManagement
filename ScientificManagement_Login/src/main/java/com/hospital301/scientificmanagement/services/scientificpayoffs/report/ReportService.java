package com.hospital301.scientificmanagement.services.scientificpayoffs.report;

import java.util.Map;

import com.hospital301.scientificmanagement.util.Report;

public interface ReportService 
{
	public Object QueryBySql(Map conditionMap);
	
	public Object QueryBySqlToResult(Report repory, Map conditionMap);

}
