package com.hospital301.scientificmanagement.controller.scientificpayoffs.paper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.ProjectPaper;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.fasterxml.jackson.databind.type.MapType;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class PaperController extends BaseController
{
	
	@RequestMapping(value="/paper/list",method=RequestMethod.POST)
	public Object getList(@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetList(TableNameEnum.PROJECTPAPER.getName(),this.getConditionMap(requestPayload));
	}
	
	@RequestMapping(value="/paper/listByUser",method=RequestMethod.POST)
	public Object listByUser(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByUser(TableNameEnum.PROJECTPAPER.getName(), this.getConditionMap(requestPayload), this.getByUserMap(tokenId));
	}
	
	@RequestMapping(value="/paper/listByOrg",method=RequestMethod.POST)
	public Object listByOrg(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByOrg(TableNameEnum.PROJECTPAPER.getName(), this.getConditionMap(requestPayload), this.getByOrgMap(tokenId));
	}
	
	@RequestMapping(value="/paper/add",method=RequestMethod.POST)
	public Object add(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		if(null != requestPayload)
		{
			ProjectPaper projectPaper = (ProjectPaper) requestAdd(requestPayload,ProjectPaper.class,this.getAssociationTableJsonNode(),TypeEnum.PAPER.getName(),RedisUtil.getRedisUserInfo(tokenId));
			return projectPaper;
		}
		return null;
	}
	
	@RequestMapping(value="/paper/get",method=RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception
	{
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if (null != requestPayloadMap && requestPayloadMap.size()>0) {
			
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			return this.requestGet(TableNameEnum.PROJECTPAPER.getName(), conditionMap, this.getAssociationTableJsonNode(), TypeEnum.PAPER.getName());
		}
		return null;
	}
	
	@RequestMapping(value = "/paper/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectPaper projectPaper = (ProjectPaper) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectPaper.class);
			if(null ==projectPaper)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTPAPER.getName(),this.getAssociationTableJsonNode(),TypeEnum.PAPER.getName(),projectPaper.getId());
			return projectPaper;
		}
		return "接受前台数据为空";
	}
	
	private Map<String,Object> getConditionMap(String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("contact"))
			{
				conditionMap.put("contact", requestPayloadMap.get("contact"));
			}
			if(requestPayloadMap.containsKey("type"))
			{
				conditionMap.put("type", requestPayloadMap.get("type"));
			}
			if(requestPayloadMap.containsKey("issue_name"))
			{
				conditionMap.put("issue_name_like", requestPayloadMap.get("issue_name"));
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
	
	private Map<String,Object> getByUserMap(String tokenid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.PAPER.getName());
		map.put("username", RedisUtil.getRedisUserInfo(tokenid).getUsername());
		return map;
	}
	private Map<String,Object> getByOrgMap(String tokenid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.PAPER.getName());
		map.put("organization_id", RedisUtil.getRedisUserInfo(tokenid).getOrganization_id());
		return map;
	}

	private List<String> getAssociationTableJsonNode()
	{
		List<String> list = new ArrayList<String>();
		list.add("chief_author");
		list.add("deputy_author");
		list.add("project");
		return list;
	}
}
