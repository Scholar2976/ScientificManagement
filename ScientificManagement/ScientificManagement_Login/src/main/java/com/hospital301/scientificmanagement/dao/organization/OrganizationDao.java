package com.hospital301.scientificmanagement.dao.organization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface OrganizationDao extends FatherMapper
{
	/**
	 * 查询并返回总条数
	 * @param conditionMap
	 * @return
	 */
	public List<List<?>> getPageListAndTotal(Map conditionMap);
	
	/**
	 * 更新父节点信息
	 * @return
	 */
	public Integer updateParentNode(Map<String,Object> conditionMap);
	
	public List<Map<String,Object>> get(Map<String,Object> conditionMap);
}
