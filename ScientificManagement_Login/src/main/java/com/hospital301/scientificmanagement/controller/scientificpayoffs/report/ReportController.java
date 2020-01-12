package com.hospital301.scientificmanagement.controller.scientificpayoffs.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.TokenId;
import org.apache.maven.shared.artifact.filter.StatisticsReportingArtifactFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import com.ccb.sm.entities.User;
import com.hospital301.scientificmanagement.Redis.Redis;
import com.hospital301.scientificmanagement.services.scientificpayoffs.report.ReportService;
import com.hospital301.scientificmanagement.util.Report;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class ReportController {
	@Autowired
	private ReportService reportService;
	@Autowired
	private Redis redis;

	/**
	 * 我的成果
	 * 
	 * @param requestPayload
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "report/user_report_by_result", method = RequestMethod.POST)
	public Object userReporyByResult(@RequestBody String requestPayload) throws Exception {
		Map<String ,Object> resultMap = new HashMap<String ,Object>();
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}

		}
		for (int i = 0; i < 5; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			Report report = Report.getReportEnumByIndex(i);
			List<Object> rlist = new ArrayList<Object>();
			List<Map<String,Object>> list =  (List) this.reportService.QueryBySqlToResult(report, conditionMap);
			if(null != list && list.size()>0)
			{
				map.put("label", report.getName());
				map.put("value", list);
				rlist.add(map);
				resultMap.put(report.getAlias(),rlist);	
			}
//			if (null != list && list.size() > 0) {
//				map.put("label", report.getName());
//				requestPayloadMap.put(report.getAlias(), map);
//			}
		}
		//return requestPayloadMap;
		return resultMap;
	}

	@RequestMapping(value = "report/user_report_by_academy_level", method = RequestMethod.POST)
	public Object userReporyByAcademyLevel(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}

		}
		requestPayloadMap.clear();
		requestPayloadMap.put("list", this.reportService.QueryBySqlToResult(Report.ACADEMY, conditionMap));
		return requestPayloadMap;
	}

	@RequestMapping(value = "report/user_report_by_project_level", method = RequestMethod.POST)
	public Object userReporyByProjectLevel(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}

		}
		requestPayloadMap.clear();
		requestPayloadMap.put("list", this.reportService.QueryBySqlToResult(Report.PROJECT, conditionMap));
		return requestPayloadMap;
	}

	@RequestMapping(value = "report/user_report_by_exchange_type", method = RequestMethod.POST)
	public Object userReporyByExchangeType(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}

		}
		requestPayloadMap.clear();
		requestPayloadMap.put("list", this.reportService.QueryBySqlToResult(Report.EXCHANGE, conditionMap));
		return requestPayloadMap;
	}

	@RequestMapping(value = "report/user_report_by_lab_category", method = RequestMethod.POST)
	public Object userReporyByLabCategory(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}

		}
		requestPayloadMap.clear();
		requestPayloadMap.put("list", this.reportService.QueryBySqlToResult(Report.LAB, conditionMap));
		return requestPayloadMap;
	}

	@RequestMapping(value = "/report/user_report", method = RequestMethod.POST)
	public Object userReport(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenid,@RequestBody String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> result = new HashMap<String,Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}else
			{
				User user = (User) redis.getUserInfo("token:"+tokenid);
				conditionMap.put("username", user.getUsername());
			}
		}
		requestPayloadMap.clear();
		result.put("list", this.reportService.QueryBySqlToResult(Report.USER, conditionMap));
		return result;
	}
	
	@RequestMapping(value = "/report/org_report", method = RequestMethod.POST)
	public Object orgReport(@RequestBody String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}

		}
		requestPayloadMap.clear();
		requestPayloadMap.put("list", this.reportService.QueryBySqlToResult(Report.USER, conditionMap));
		return requestPayloadMap;
	}
	
	
}
