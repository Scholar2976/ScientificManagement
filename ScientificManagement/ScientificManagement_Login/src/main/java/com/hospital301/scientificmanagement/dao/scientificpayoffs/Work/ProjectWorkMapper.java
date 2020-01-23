package com.hospital301.scientificmanagement.dao.scientificpayoffs.Work;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ccb.sm.entities.ProjectWork;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface ProjectWorkMapper extends FatherMapper
{
	/**
	 * 查询work表中信息
	 * @param map
	 * @return
	 */
	public List<ProjectWork> getWorkList(Map<String,Object> map);
	/**
	 * 
	 * @param map
	 * @return
	 */
	public Integer getWorkListTotal(Map<String,Object> map);
	/**
	 * 根据work_id批量更新project_work表中数据
	 * @param list  传入的参数是实体对象集合
	 * @return
	 */
	public Integer BatchupdateByWorkId(List<ProjectWork> list);
	
	/**
	 * 根据work_id删除数据
	 * @param workId
	 * @return
	 */
	public Integer deleteByWorkId(int workId);
	
	/**
	 * 批量插入
	 * @param list 传入的参数是实体对象的集合
	 * @return
	 */
	public  Integer BatchInsert(List<ProjectWork> list);
	/**
	 * 插入对象
	 * @param list 传入的参数是实体对象的集合
	 * @return
	 */
	public  Integer Insert(ProjectWork projectWork);
	
	public Integer UpdateByWorkId(ProjectWork projectWork);
	
	
	
	
	
	

}
