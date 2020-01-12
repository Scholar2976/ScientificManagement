package com.hospital301.scientificmanagement.dao.parameter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ccb.sm.entities.ParameterValue;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

/** 
* @author 作者 
* @version 创建时间：2020年1月2日 下午5:59:09 
* 类说明 
*/
@Mapper
public interface ParameterValueDao extends FatherMapper
{
	public List<ParameterValue> getTree(Map<String,Object> conditionMap);
}
