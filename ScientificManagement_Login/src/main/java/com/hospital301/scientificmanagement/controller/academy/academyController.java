package com.hospital301.scientificmanagement.controller.academy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.ProjectAcademy;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.util.Util;

/** 
* @author 作者 
* @version 创建时间：2019年12月25日 下午3:44:52 
* 类说明 
*/

@RestController
public class academyController extends BaseController
{
	@RequestMapping(value="/academy/search",method=RequestMethod.POST)
	public Object search(@RequestBody String requestPayload) throws Exception
	{
		List<Map<String, Object>> list = this.baseGet(TableNameEnum.PROJECTACADEMY.getName(),this.getConditionMap(requestPayload));
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
 		for(Map map : list)
 		{
 			Map<String,Object> m_map = new HashMap<>();
 			m_map.put("name", map.get("name"));
 			m_map.put("label",map.get("name"));
 			m_map.put("value", map.get("id"));
 			resultList.add(m_map);
 		}
 		Map<String,Object> resultMap = new HashMap<>();
 		resultMap.put("list", resultList);
 		return resultMap;
	}
	
	@RequestMapping(value="/academy/listByUser",method=RequestMethod.POST)
	public Object listByUser(@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByUser(TableNameEnum.PROJECTACADEMY.getName(), this.getConditionMap(requestPayload), this.getByUserMap());
	}
	
	
	@RequestMapping(value="/academy/listByOrg",method=RequestMethod.POST)
	public Object listByOrg(@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByOrg(TableNameEnum.PROJECTACADEMY.getName(), this.getConditionMap(requestPayload), this.getByOrgMap());
	}
	
	@RequestMapping(value="/academy/list",method=RequestMethod.POST)
	public Object getList(@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetList(TableNameEnum.PROJECTACADEMY.getName(),this.getConditionMap(requestPayload));
	}
	

	@RequestMapping(value = "/academy/add", method = RequestMethod.POST)
	public Object add(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectAcademy projectAcademy = (ProjectAcademy) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectAcademy.class);
			if(null ==projectAcademy)
				return "从json获取数据为空";
			projectAcademy.setCreated_time(new Date());
			this.baseSaveOrUpdate(null, projectAcademy);
			return projectAcademy;
		}
		return "接受前台数据为空";
	}
	
	@RequestMapping(value = "academy/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectAcademy projectAcademy = (ProjectAcademy) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectAcademy.class);
			if(null ==projectAcademy)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTACADEMY.getName(),this.getAssociationTableJsonNode(),TypeEnum.ACADEMY.getName(),projectAcademy.getId());
			return projectAcademy;
		}
		return "接受前台数据为空";
	}
	
	
	
	private Map<String,Object> getConditionMap(String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("name"))
			{
				conditionMap.put("name_like", requestPayloadMap.get("name"));
			}
			conditionMap.put("deleted", false);
			int pageSize = 0;
			if(requestPayloadMap.containsKey("tRecInPage"))
			{
				
				pageSize = Integer.parseInt(requestPayloadMap.get("tRecInPage").toString());
				conditionMap.put("pageEnd", pageSize);
			}
			if(requestPayloadMap.containsKey("tPageJump"))
			{
				int page = Integer.parseInt(requestPayloadMap.get("tPageJump").toString());
				if (page == 0) 
				{
					page = 1;
				}
				conditionMap.put("pageStart", (page - 1) * pageSize);
			}
			
		}
		return conditionMap;
	}
	
	private List<String> getAssociationTableJsonNode()
	{
		List<String> list = new ArrayList<String>();
		list.add("member");
		return list;
	}
	
	private Map<String,Object> getByUserMap()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.ACADEMY.getName());
		map.put("username", "admin");
		return map;
	}
	private Map<String,Object> getByOrgMap()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.ACADEMY.getName());
		map.put("organization_id", "");
		return map;
	}
}
