package com.hospital301.scientificmanagement.services.scientificpayoffs.report.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital301.scientificmanagement.dao.scientificpayoffs.report.ReportMapper;
import com.hospital301.scientificmanagement.services.BaseServiceImpl;
import com.hospital301.scientificmanagement.services.scientificpayoffs.report.ReportService;
import com.hospital301.scientificmanagement.util.Report;


@Service
public class ReportServiceImpl extends BaseServiceImpl implements ReportService 
{
	@Autowired
	private ReportMapper reportMapper;
	public Object QueryBySqlToResult(Report report, Map conditionMap) 
	{
//		List<Map<String,Object>> list = this.fatherMapper.baseQueryBySql(getSql(report, conditionMap));
		List<Map<String,Object>> list = this.getReportResult(report, conditionMap);
//		Map<String, Object> result = new HashMap<>();
//		if (null != list && list.size() > 0) {
//			result.put("value", list);
//		}
		return list;
	}

	@Override
	public Object QueryBySql(Map conditionMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private List<Map<String,Object>> getReportResult(Report report, Map conditionMap) {
//		String sql = "";
		switch (report) {
		case REWARD:
			return reportMapper.getReportReward(conditionMap);
//			sql = "select p.label as name, count(1) as value " + "from project_member m, project_reward b "
//					+ "left join parameter_value p on b.level=p.value and p.parameter='rewardLevel' "
//					+ "where m.username='" + conditionMap.get("username").toString()
//					+ "' and m.reference_id=b.id and m.type='reward' " + "group by b.level order by p.order";
//			break;
		case PAPER:
			return this.reportMapper.getReportPaper(conditionMap);
//			sql = "select p.label as name, count(1) as value " + "from project_member m, project_paper b "
//					+ "left join parameter_value p on b.type=p.value and p.parameter='paperType' "
//					+ "where m.username='" + conditionMap.get("username").toString()
//					+ "' and m.reference_id=b.id and m.type='paper' " + "group by b.type order by p.order";
//			break;
		case SOFTWARE:
			return this.reportMapper.getReportSoftWare(conditionMap);
//			sql = "select p.label as name, count(1) as value " + "from project_member m, project_software b "
//					+ "left join parameter_value p on b.development_mode=p.value and p.parameter='softwareDevelopmentMode' "
//					+ "where m.username='" + conditionMap.get("username").toString()
//					+ "' and m.reference_id=b.id and m.type='software' "
//					+ "group by b.development_mode order by p.order";
//			break;
		case WORK:
			return this.reportMapper.getReportWork(conditionMap);
//			sql = "select p.label as name, count(1) as value " + "from project_member m, project_work b "
//					+ "left join parameter_value p on b.category=p.value and p.parameter='workDomainType' "
//					+ "where m.username='" + conditionMap.get("username").toString()
//					+ "' and m.reference_id=b.id and m.type='work' " + "group by b.category order by p.order";
//			break;
		case PATENT:
			return this.reportMapper.getReportPatent(conditionMap);
//			sql = "select p.label as name, count(1) as value " + "from project_member m, project_patent b "
//					+ "left join parameter_value p on b.type=p.value and p.parameter='patentType' "
//					+ "where m.username='" + conditionMap.get("username").toString()
//					+ "' and m.reference_id=b.id and m.type='patent' " + "group by b.type order by p.order";
//			break;
		case PROJECT:
			return this.reportMapper.getReportProject(conditionMap);
//			sql = "select p.level, count(1) as count from project_member m, project p " + "where m.username='"
//					+ conditionMap.get("username").toString() + "' and m.reference_id=p.id and m.type='project' "
//					+ "group by p.level";
//			break;
		case ACADEMY:
			return this.reportMapper.getReportAcademy(conditionMap);
//			sql = "select a.academy_level, count(1) as count " + "from project_academy a, project_academy_post p "
//					+ "where a.id = p.academy_id and p.username='" + conditionMap.get("username").toString() + "' "
//					+ "group by a.academy_level";
//			break;
		case LAB:
			return this.reportMapper.getReportLab(conditionMap);
//			sql = "select a.academy_level, count(1) as count " + "from project_academy a, project_academy_post p "
//					+ "where a.id = p.academy_id and p.username='" + conditionMap.get("username").toString() + "' "
//					+ "group by a.academy_level";
//			break;
		case EXCHANGE:
			return this.reportMapper.getReportExchange(conditionMap);
//			sql = "select a.academy_level, count(1) as count " + "from project_academy a, project_academy_post p "
//					+ "where a.id = p.academy_id and p.username='" + conditionMap.get("username").toString() + "' "
//					+ "group by a.academy_level";
//			break;
		case USER:
			return this.reportMapper.getUserReport(conditionMap);
		default:
			return null;
		}
	}


}