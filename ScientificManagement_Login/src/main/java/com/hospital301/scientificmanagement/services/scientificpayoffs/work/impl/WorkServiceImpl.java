package com.hospital301.scientificmanagement.services.scientificpayoffs.work.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccb.sm.entities.ProjectWork;
import com.hospital301.scientificmanagement.dao.scientificpayoffs.member.ProjectMemberMapper;
import com.hospital301.scientificmanagement.dao.scientificpayoffs.Work.ProjectWorkMapper;
import com.hospital301.scientificmanagement.dao.scientificpayoffs.unit.ProjectUnitMapper;
import com.hospital301.scientificmanagement.services.BaseServiceImpl;
import com.hospital301.scientificmanagement.services.scientificpayoffs.work.WorkService;

@Service
public class WorkServiceImpl extends BaseServiceImpl  implements WorkService
{
	@Autowired
	private ProjectWorkMapper workdao;
	@Autowired
	private ProjectMemberMapper memberdao;
	@Autowired
	private ProjectUnitMapper unitdao;
	
	@Override
	public Map QueryTableInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List list = workdao.getWorkList(map);
		Integer total = workdao.getWorkListTotal(map);
		Map resultMap = new HashMap<>();
		resultMap.put("page", list);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	public Object insert(Object obj)
	{
		ProjectWork projectWork = (ProjectWork) obj;
		Map idMap = new HashMap<>();
		List list = new ArrayList<>();
		
				
		workdao.baseSaveOrUpdate(obj);
//		idMap.put("reference_id", projectWork.getId());
		//保存project_member对象
//		if(projectWork.getMember().size()>0)
//		{
//			idMap.put("type", projectResult.getType());
//			this.handleAssociationTable(idMap, projectWork.getMember());
//			memberdao.deleteByReferenceId(Integer.parseInt(String.valueOf(projectWork.getId())));
//			memberdao.BatchInsert(projectWork.getMember());
//		}
		//保存unit对象
//		if(projectWork.getUnit().size()>0)
//		{
//			this.handleAssociationTable(idMap, projectWork.getUnit());
//			unitdao.deleteByReferenceId(Integer.parseInt(String.valueOf(projectWork.getId())));
//			unitdao.BatchInsert(projectWork.getUnit());
//		}
//		idMap.clear();
		idMap.put("id",projectWork.getId());

		ProjectWork result = (ProjectWork)workdao.getWorkList(idMap).get(0);
//		List<ProjectMember> memberlist = memberdao.getMemberList(idMap);
//		List<ProjectUnit> unitlist = unitdao.getUnitList(idMap);
//		result.setUnit(projectWork.getUnit());
//		result.setMember(projectWork.getMember());
		return result;
	
	}

}
