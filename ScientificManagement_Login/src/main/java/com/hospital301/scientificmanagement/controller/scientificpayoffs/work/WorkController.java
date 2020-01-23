package com.hospital301.scientificmanagement.controller.scientificpayoffs.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.shared.artifact.filter.StatisticsReportingArtifactFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.html.HTMLIsIndexElement;

import com.ccb.sm.entities.ProjectWork;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.services.scientificpayoffs.work.WorkService;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class WorkController extends BaseController
{
	@Autowired
	private WorkService workService;

	
	@RequestMapping(value="/work/list",method=RequestMethod.POST)
	public Object getWorkList(@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetList(TableNameEnum.PROJECTWORK.getName(),this.getConditionMap(requestPayload));
	}
	
	@RequestMapping(value="/work/listByUser",method=RequestMethod.POST)
	public Object listByUser(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByUser(TableNameEnum.PROJECTWORK.getName(), this.getConditionMap(requestPayload), this.getByUserMap(tokenId));
	}
	
	@RequestMapping(value="/work/listByOrg",method=RequestMethod.POST)
	public Object listByOrg(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByOrg(TableNameEnum.PROJECTWORK.getName(), this.getConditionMap(requestPayload), this.getByOrgMap(tokenId));
	}
	
	
	@RequestMapping(value="/work/add" , method=RequestMethod.POST)
	public Object add(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception 
	{
		if(null != requestPayload)
		{
			ProjectWork projectWork = (ProjectWork) requestAdd(requestPayload,ProjectWork.class,this.getAssociationTableJsonNode(),TypeEnum.WORK.getName(),RedisUtil.getRedisUserInfo(tokenId));
			return projectWork;
		}
		return null;
	}
	
	@RequestMapping(value = "/work/get",method=RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception
	{
		
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if (null != requestPayloadMap && requestPayloadMap.size()>0) {
			
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			return this.requestGet(TableNameEnum.PROJECTWORK.getName(), conditionMap, this.getAssociationTableJsonNode(), TypeEnum.WORK.getName());
		}
		return null;
	}
	
	@RequestMapping(value = "/work/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectWork projectWork = (ProjectWork) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectWork.class);
			if(null ==projectWork)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTWORK.getName(),this.getAssociationTableJsonNode(),TypeEnum.WORK.getName(),projectWork .getId());
			return projectWork;
		}
		return "接受前台数据为空";
	}
	
	
	
	@RequestMapping(value = "/work/validateISBN", method = RequestMethod.POST)
	public Object validateISBN(@RequestBody String requestPayload) throws Exception
	{
		if (null == requestPayload) {
			return null;
		}
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (requestPayloadMap.containsKey("isbn")) {
			conditionMap.put("isbn", requestPayloadMap.get("isbn"));
		}
		if (requestPayloadMap.containsKey("id")) {
			conditionMap.put("id", requestPayloadMap.get("id"));
		}
		conditionMap.put("deleted", false);
		return baseValidate(TableNameEnum.PROJECTWORK.getName(),conditionMap);
		
	}
	
	private Map<String,Object> getConditionMap(String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("title"))
			{
				conditionMap.put("title_like", requestPayloadMap.get("title"));
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
		map.put("type", TypeEnum.WORK.getName());
		map.put("username", RedisUtil.getRedisUserInfo(tokenid).getUsername());
		return map;
	}
	private  Map<String,Object> getByOrgMap(String tokenid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.WORK.getName());
		map.put("organization_id", RedisUtil.getRedisUserInfo(tokenid).getOrganization_id());
		return map;
	}
	
	private List<String> getAssociationTableJsonNode()
	{
		List<String> list = new ArrayList<String>();
		list.add("chief_author");
		list.add("deputy_author");
		list.add("project");
		list.add("member");
		list.add("unit");
		return list;
	}
	
	private String returnStr()
	{
		return "接受前台数据为空";
	}
	
}
