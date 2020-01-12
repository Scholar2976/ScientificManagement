package com.hospital301.scientificmanagement.dao.scientificpayoffs.attachment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ccb.sm.entities.ProjectAttachment;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface ProjectAttachmentMapper extends FatherMapper
{
	/**
	 * 返回实体对象的集合
	 * @param map
	 * @return
	 */
	public List<ProjectAttachment> getAttachmentList(Map<String,Object> map);
	
	/**
	 * 插入对象
	 * @param list 传入的参数是实体对象的集合
	 * @return
	 */
	public  Integer insert(@Param(value="list")List<ProjectAttachment> list);
	
	/**
	 * 根据reference_id删除数据
	 * @param workId
	 * @return
	 */
	public Integer deleteByReferenceId(int referenceId);
	

}
