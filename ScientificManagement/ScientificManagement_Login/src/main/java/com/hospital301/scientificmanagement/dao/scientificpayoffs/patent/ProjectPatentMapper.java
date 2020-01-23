package com.hospital301.scientificmanagement.dao.scientificpayoffs.patent;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ccb.sm.entities.ProjectPatent;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface ProjectPatentMapper extends FatherMapper
{
	/**
	 * 获取patent表信息
	 * @param map
	 * @return
	 */
	public List<ProjectPatent> getPatentList(Map<String,Object> map);
	
	/**
	 * 获取查询的总条数
	 * @param map
	 * @return
	 */
	public Integer getPatentListTotal(Map<String,Object> map);
	
	
//	public Integer insert (ProjectPatent projectPatent);
	

//	public Integer updateById (ProjectPatent projectPatent);
}
