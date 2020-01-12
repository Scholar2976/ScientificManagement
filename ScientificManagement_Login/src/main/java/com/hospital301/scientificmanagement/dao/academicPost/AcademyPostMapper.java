package com.hospital301.scientificmanagement.dao.academicPost;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ccb.sm.entities.ProjectAcademyPost;

@Mapper
public interface AcademyPostMapper 
{
	/**
	 * 分页查询ProjectAcademyPost表中信息 
	 * @param map
	 * @return
	 */
	public List<ProjectAcademyPost> getAcademyListOfPage(Map<String,Object> map);
	
	/**
	 * 查询ProjectAcademyPost表中信息
	 * @param map
	 * @return
	 */
	public List<ProjectAcademyPost> getAcademyList(Map<String,Object> map);
	
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public Integer getAcademyListTotal(Map<String,Object> map);
	
	/**
	 * 在ProjectAcademyPost表中插入对象
	 * @param list 传入的参数是实体对象的集合
	 * @return
	 */
	public  Integer Insert(ProjectAcademyPost projectAcademyPost);
	
	/**
	 * 根据ID更新ProjectAcademyPost表
	 * @param projectAcademyPost
	 * @return
	 */
	public Integer UpdateById(ProjectAcademyPost projectAcademyPost);
	
	/**
	 * 更新或者插入ProjectAcademyPost表
	 * @param projectAcademyPost
	 * @return
	 */
	public Integer UpdateOrInsert(ProjectAcademyPost projectAcademyPost);
	
	/**
	 * 批量更新或者插入ProjectAcademyPost表
	 * @param projectAcademyPostList
	 * @return
	 */
	public Integer BatchUpdateOrInsert(List<ProjectAcademyPost> projectAcademyPostList);
	
	/**
	 * 删除数据
	 */
	public Integer DeleteById (int id);
	
	/**
	 * 逻辑删除 ，只是修改数据的删除状态（deleted）字段的值
	 * @param map
	 * @return
	 */
	public Integer LogicDelete (Map<String,Object> map);
	
}
