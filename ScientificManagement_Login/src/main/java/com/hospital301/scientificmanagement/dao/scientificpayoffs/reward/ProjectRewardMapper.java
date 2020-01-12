package com.hospital301.scientificmanagement.dao.scientificpayoffs.reward;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ccb.sm.entities.ProjectReward;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface ProjectRewardMapper  extends FatherMapper
{
	/**
	 * 返回分頁实体对象的集合
	 * @param map
	 * @return
	 */
	public List<ProjectReward> getResultListOfPage(Map<String,Object> map);
	/**
	 * 返回查询的总条数
	 * @param map
	 * @return
	 */
	public Integer getResultListTotal(Map<String,Object> map);
	
	
	/**
	 * 根据work_id更新project_work表中数据
	 * @param list  传入的参数是实体对象集合
	 * @return
	 */
	public Integer BatchupdateByResultId(@Param(value ="list") List<ProjectReward> list);
	
	/**
	 * 根据work_id更新project_work表中数据
	 * @param list  传入的参数是实体对象集合
	 * @return
	 */
	public Integer updateByResultId(ProjectReward projectResult);
	
	/**
	 * 根据work_id删除数据
	 * @param workId
	 * @return
	 */
	public Integer deleteByresultId(int workId);
	
	/**
	 * 批量插入对象
	 * @param list 传入的参数是实体对象的集合
	 * @return
	 */
	public  Integer Batchinsert(@Param(value="list")List<ProjectReward> list);
	/**
	 * 插入单个对象
	 * @param list
	 * @return
	 */
//	public  Integer insert(ProjectResult projectResult);
	
	/**
	 * 返回体对象的集合
	 * @param map
	 * @return
	 */
	public List<ProjectReward> getResultList(Map<String,Object> map);
	
	
	public List<List<Object>> getReslutByPage(Map<String,Object> map);
	
	

}
