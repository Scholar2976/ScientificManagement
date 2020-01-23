package com.hospital301.scientificmanagement.dao.scientificpayoffs.unit;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ccb.sm.entities.ProjectUnit;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface ProjectUnitMapper extends FatherMapper
{	
	/**
	 * 返回实体对象的集合
	 * @param map
	 * @return
	 */
	public List<ProjectUnit> getUnitList(Map<String,Object> map);
	
	/**
	 * 插入对象
	 * @param list 传入的参数是实体对象的集合
	 * @return
	 */
	public  Integer BatchInsert(@Param(value="list")List<ProjectUnit> list);
	
	/**
	 * 根据reference_id删除数据
	 * @param workId
	 * @return
	 */
	public Integer deleteByReferenceId(int referenceId);
	

}
