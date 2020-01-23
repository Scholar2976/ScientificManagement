package com.hospital301.scientificmanagement.controller.scientificpayoffs.software;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.ProjectSoftware;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.Redis.Redis;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class SoftwareController extends BaseController
{
	@RequestMapping(value="/software/list", method=RequestMethod.POST)
	public Object getSoftwareList(@RequestBody String requestPayload)throws Exception
	{
		return this.baseGetList(TableNameEnum.PROJECTSOFTWARE.getName(),this.getConditionMap(requestPayload));
	}
	
	@RequestMapping(value="/software/listByUser", method=RequestMethod.POST)
	public Object listByUser(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload)throws Exception
	{
		return this.baseGetListByUser(TableNameEnum.PROJECTSOFTWARE.getName(), this.getConditionMap(requestPayload), this.getByUserMap(tokenId));
	}
	
	@RequestMapping(value="/software/listByOrg", method=RequestMethod.POST)
	public Object listByOrg(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload)throws Exception
	{
		return this.baseGetListByOrg(TableNameEnum.PROJECTSOFTWARE.getName(), this.getConditionMap(requestPayload), this.getByOrgMap(tokenId));
	}
	
	@RequestMapping(value="/software/add" , method=RequestMethod.POST)
	public Object add(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception 
	{
		if(null != requestPayload)
		{
			ProjectSoftware projectSoftware = (ProjectSoftware) requestAdd(requestPayload,ProjectSoftware.class,this.getAssociationTableJsonNode(),TypeEnum.SOFTWARE.getName(),RedisUtil.getRedisUserInfo(tokenId));
			return projectSoftware;
		}
		return null;
	}
	
	@RequestMapping(value = "/software/get",method=RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception
	{
		
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if (null != requestPayloadMap && requestPayloadMap.size()>0) {
			
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			return this.requestGet(TableNameEnum.PROJECTSOFTWARE.getName(), conditionMap, this.getAssociationTableJsonNode(), TypeEnum.SOFTWARE.getName());
		}
		return null;
	}
	
	@RequestMapping(value = "/software/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectSoftware projectSoftware = (ProjectSoftware) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectSoftware.class);
			if(null ==projectSoftware)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTSOFTWARE.getName(),this.getAssociationTableJsonNode(),TypeEnum.SOFTWARE.getName(),projectSoftware.getId());
			return projectSoftware;
		}
		return "接受前台数据为空";
	}
	
	
	@RequestMapping(value = "/software/validateRegisterId", method = RequestMethod.POST)
	public Object validateRegisterId(@RequestBody String requestPayload) throws Exception
	{
		if (null == requestPayload) {
			return null;
		}
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (requestPayloadMap.containsKey("register_id")) {
			conditionMap.put("register_id", requestPayloadMap.get("register_id"));
		}
		if (requestPayloadMap.containsKey("id")) {
			conditionMap.put("id", requestPayloadMap.get("id"));
		}
		conditionMap.put("deleted", false);
		return baseValidate(TableNameEnum.PROJECTSOFTWARE.getName(),conditionMap);
		
	}
	
	
	private Map<String,Object> getConditionMap(String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("author"))
			{
				conditionMap.put("author_like", requestPayloadMap.get("author"));
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
	
	private  Map<String,Object> getByUserMap(String tokenid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.SOFTWARE.getName());
		map.put("username", RedisUtil.getRedisUserInfo(tokenid).getUsername());
		return map;
	}
	private  Map<String,Object> getByOrgMap(String tokenid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.SOFTWARE.getName());
		map.put("organization_id", RedisUtil.getRedisUserInfo(tokenid).getOrganization_id());
		return map;
	}
	
	private List<String> getAssociationTableJsonNode()
	{
		List<String> list = new ArrayList<String>();
		list.add("member");
		return list;
	}
	
	
}
