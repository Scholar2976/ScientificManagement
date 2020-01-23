package com.hospital301.scientificmanagement.services.scientificpayoffs.report.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.visitor.functions.If;
import com.ccb.sm.entities.User;
import com.hospital301.scientificmanagement.dao.scientificpayoffs.report.ReportMapper;
import com.hospital301.scientificmanagement.services.BaseServiceImpl;
import com.hospital301.scientificmanagement.services.scientificpayoffs.report.ReportService;
import com.hospital301.scientificmanagement.util.Report;
import com.mysql.cj.protocol.ResultListener;

@Service
public class ReportServiceImpl extends BaseServiceImpl implements ReportService {
	@Autowired
	private ReportMapper reportMapper;

	public Object QueryBySqlToResult(Report report, Map conditionMap) {
		List<Map<String, Object>> list = this.getReportResult(report, conditionMap);
		return list;
	}

	public Object VerifyUserPermissions(User user, Map<String, Object> conditionMap) throws Exception {
		String org_id = "";
		String org_name = "";
		Integer childNodeCount = 0;
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		List<String> userrole = reportMapper.getUserRole(user.getUsername());
		if(null == userrole)
			return "用户无权限查看此信息";
		if (userrole.contains("superuser")) {
			resultList = reportMapper.getOrgReport(conditionMap);
			childNodeCount = reportMapper.getOrgChildCount(conditionMap);
			return this.getOrgReport(resultList, org_name, org_id, childNodeCount);
		}
		if (userrole.contains("manager")|| userrole.contains("leader")) {
			if (org_id.length() == 0) {
				org_id = user.getOrganization_id();
			} else if (!org_id.startsWith(user.getOrganization_id())) {
				return "用户无权限查看此信息";
			}
			org_id = user.getOrganization_id();
			org_name = user.getOrganization_name();
			resultList = reportMapper.getOrgReport(conditionMap);
			childNodeCount = reportMapper.getOrgChildCount(conditionMap);
			return this.getOrgReport(resultList, org_name, org_id, childNodeCount);
		}
		return "用户无权限查看此信息";
	}

	private List<Map<String, Object>> getReportResult(Report report, Map conditionMap) {
		switch (report) {
		case REWARD:
			return reportMapper.getReportReward(conditionMap);
		case PAPER:
			return this.reportMapper.getReportPaper(conditionMap);
		case SOFTWARE:
			return this.reportMapper.getReportSoftWare(conditionMap);
		case WORK:
			return this.reportMapper.getReportWork(conditionMap);
		case PATENT:
			return this.reportMapper.getReportPatent(conditionMap);
		case PROJECT:
			return this.reportMapper.getReportProject(conditionMap);
		case ACADEMY:
			return this.reportMapper.getReportAcademy(conditionMap);
		case LAB:
			return this.reportMapper.getReportLab(conditionMap);
		case EXCHANGE:
			return this.reportMapper.getReportExchange(conditionMap);
		case USER:
			return this.reportMapper.getUserReport(conditionMap);
		default:
			return null;
		}
	}

	/**
	 * 获取org_report返回报文
	 * 
	 * @return
	 */
	private Map<String, Object> getOrgReport(List list, String org_name, String org_id, Integer childNodeCount) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("org_id", org_id);
		resultMap.put("org_name", org_name);
		resultMap.put("children_count", childNodeCount);
		return resultMap;
	}

}