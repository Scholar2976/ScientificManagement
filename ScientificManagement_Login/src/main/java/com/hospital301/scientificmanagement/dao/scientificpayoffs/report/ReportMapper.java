package com.hospital301.scientificmanagement.dao.scientificpayoffs.report;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/** 
* @author 作者 
* @version 创建时间：2019年12月25日 上午10:00:05 
* 类说明 
*/
@Mapper
public interface ReportMapper 
{
	/**
	 * 获取我的成果中的奖励统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportReward(Map conditionMap);
	
	/**
	 * 获取我的成果中的论文统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportPaper(Map conditionMap);
	
	/**
	 * 获取我的成果中的软著的统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportSoftWare(Map conditionMap);
	
	/**
	 * 获取我的成果中的著作的统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportWork(Map conditionMap);
	
	/**
	 * 获取我的成果中patent统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportPatent(Map conditionMap);
	
	/**
	 * 获取我的项目的统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportProject(Map conditionMap);
	
	/**
	 * 获取实验室的统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportLab(Map conditionMap);
	/**
	 * 获取学术任职的统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportAcademy(Map conditionMap);
	
	/**
	 * 获取学术活动的统计结果
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getReportExchange(Map conditionMap);
	
	/**
	 * 个人主页上的统计信息
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> getUserReport(Map conditionMap);
	
}	
