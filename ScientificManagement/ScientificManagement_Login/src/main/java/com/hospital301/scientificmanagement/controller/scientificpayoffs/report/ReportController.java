package com.hospital301.scientificmanagement.controller.scientificpayoffs.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hospital301.scientificmanagement.Redis.Redis;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
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
	public Object userReporyByResult(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReportByResult(requestPayload, tokenid,"user");
	}

	@RequestMapping(value = "report/user_report_by_academy_level", method = RequestMethod.POST)
	public Object userReporyByAcademyLevel(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReporyByAcademyLevel(requestPayload, tokenid,"user");
	}

	@RequestMapping(value = "report/user_report_by_project_level", method = RequestMethod.POST)
	public Object userReporyByProjectLevel(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReportByProjectLevel(requestPayload, tokenid,"user");
	}

	@RequestMapping(value = "report/user_report_by_exchange_type", method = RequestMethod.POST)
	public Object userReporyByExchangeType(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReporyByExchangeType(requestPayload, tokenid,"user");
	}

	@RequestMapping(value = "report/user_report_by_lab_category", method = RequestMethod.POST)
	public Object userReporyByLabCategory(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReporyByLabCategory(requestPayload, tokenid,"user");
	}

	@RequestMapping(value = "/report/user_report", method = RequestMethod.POST)
	public Object userReport(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list",
				this.reportService.QueryBySqlToResult(Report.USER, this.getConditionMap(requestPayload, tokenid,"user")));
		return result;
	}

	@RequestMapping(value = "/report/org_report", method = RequestMethod.POST)
	public Object orgReport(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.reportService.VerifyUserPermissions(RedisUtil.getRedisUserInfo(tokenid),
				this.getConditionMap(requestPayload, tokenid,"org"));
	}

	@RequestMapping(value = "/report/org_report_by_project_level", method = RequestMethod.POST)
	public Object orgReportByProjectLevel(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReportByProjectLevel(requestPayload, tokenid,"org");
	}

	@RequestMapping(value = "/report/org_report_by_result", method = RequestMethod.POST)
	public Object orgReporyByResult(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReportByResult(requestPayload, tokenid,"org");
	}

	@RequestMapping(value = "/report/org_report_by_lab_category", method = RequestMethod.POST)
	public Object orgReporyByLabCategory(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReporyByLabCategory(requestPayload, tokenid,"org");
	}

	@RequestMapping(value = "report/org_report_by_academy_level", method = RequestMethod.POST)
	public Object orgReporyByAcademyLevel(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReporyByAcademyLevel(requestPayload, tokenid,"org");
	}

	@RequestMapping(value = "report/org_report_by_exchange_type", method = RequestMethod.POST)
	public Object orgReporyByExchangeType(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,
			@RequestBody String requestPayload) throws Exception {
		return this.getReporyByExchangeType(requestPayload, tokenid,"org");
	}

	private Object getReportByProjectLevel(String requestPayload, String tokenid,String type) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list",
				this.reportService.QueryBySqlToResult(Report.PROJECT, this.getConditionMap(requestPayload, tokenid,type)));
		return resultMap;
	}

	private Object getReportByResult(String requestPayload, String tokenid ,String type) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap = this.getConditionMap(requestPayload, tokenid,type);
		for (int i = 0; i < 5; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			Report report = Report.getReportEnumByIndex(i);
			List<Object> rlist = new ArrayList<Object>();
			List<Map<String, Object>> list = (List) this.reportService.QueryBySqlToResult(report, conditionMap);
			if (null != list && list.size() > 0) {
				map.put("label", report.getName());
				map.put("value", list);
				rlist.add(map);
				resultMap.put(report.getAlias(), rlist);
			}
		}
		return resultMap;
	}

	private Object getReporyByLabCategory(String requestPayload, String tokenid ,String type) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list",
				this.reportService.QueryBySqlToResult(Report.LAB, this.getConditionMap(requestPayload, tokenid,type)));
		return resultMap;
	}

	private Object getReporyByAcademyLevel(String requestPayload, String tokenid,String type) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list",
				this.reportService.QueryBySqlToResult(Report.ACADEMY, this.getConditionMap(requestPayload, tokenid,type)));
		return resultMap;
	}

	private Object getReporyByExchangeType(String requestPayload, String tokenid,String type) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list",
				this.reportService.QueryBySqlToResult(Report.EXCHANGE, this.getConditionMap(requestPayload, tokenid,type)));
		return resultMap;
	}

	/**
	 * 获取查询条件
	 * 
	 * @param requestPayloadMap
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> getConditionMap(String requestPayload, String tokenid,String type) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			switch (type) {
			case "user":
				if (requestPayloadMap.containsKey("username")
						&& requestPayloadMap.get("username").toString().trim().length() > 0) {
					conditionMap.put("username", requestPayloadMap.get("username"));
				} else {
					User user = (User) redis.get("token:" + tokenid);
					conditionMap.put("username", user.getUsername());
				}
				conditionMap.put("deleted", false);
				break;

			case "org":
				if (requestPayloadMap.containsKey("org_id")) {
					if (requestPayloadMap.get("org_id").toString().trim().length() > 0)
						conditionMap.put("org_id", requestPayloadMap.get("org_id"));
				}
				conditionMap.put("deleted", false);
				break;
			}
		}
		return conditionMap;
	}

}
