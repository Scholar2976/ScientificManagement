package com.hospital301.scientificmanagement.dao.scientificpayoffs.paper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ccb.sm.entities.ProjectPaper;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface ProjectPaperMapper  extends FatherMapper
{
//	public List<ProjectPaperJoinMember> getPaperList(Map<String,Object> map);
	
	public  List<ProjectPaper> getPaperList(Map<String,Object> map);

	
	public int getPaperListTotal(Map map);
	
	public int  InsertOrUpdatePaperByPaperId (ProjectPaper paper);
}
