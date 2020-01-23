package com.hospital301.scientificmanagement.controller.organization;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital301.scientificmanagement.services.organization.OrganizationService;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class OrganizationController 
{
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value="/org/list",method=RequestMethod.POST)
	public Object getList(@RequestBody String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("parent"))
			{
				conditionMap.put("parent", requestPayloadMap.get("parent"));
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
		return organizationService.QueryTableInfoByPage(conditionMap);
	}
	
	@RequestMapping(value="/org/remove",method=RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("parent"))
			{
				conditionMap.put("parent", requestPayloadMap.get("parent"));
			}else
			{
				conditionMap.put("parent", requestPayloadMap.get(""));
			}
			if(requestPayloadMap.containsKey("type"))
			{
				conditionMap.put("type", requestPayloadMap.get("type"));
			}else
			{
				conditionMap.put("type", requestPayloadMap.get("000"));
			}
			if(requestPayloadMap.containsKey("org_id"))
			{
				conditionMap.put("org_id", requestPayloadMap.get("org_id"));
			}
			conditionMap.put("deleted", false);
		}
		return organizationService.updateParent("org_org_rel", conditionMap);
	}
	
	@RequestMapping(value="/org/get",method=RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("type"))
			{
				conditionMap.put("type", requestPayloadMap.get("type"));
			}else
			{
				conditionMap.put("type", requestPayloadMap.get("000"));
			}
			if(requestPayloadMap.containsKey("org_id"))
			{
				conditionMap.put("org_id", requestPayloadMap.get("org_id"));
			}	
			conditionMap.put("deleted", false);
		}
		return organizationService.get(conditionMap);
	}
}
