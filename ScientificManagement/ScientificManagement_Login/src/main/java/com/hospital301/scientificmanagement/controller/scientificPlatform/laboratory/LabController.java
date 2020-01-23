package com.hospital301.scientificmanagement.controller.scientificPlatform.laboratory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.ProjectLab;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.Redis.Redis;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.util.Util;

/**
 * @author 作者
 * @version 创建时间：2019年12月30日 上午9:45:14 类说明
 */

@RestController
public class LabController extends BaseController
{
	@RequestMapping(value = "/lab/get",method=RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception
	{
		
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if (null != requestPayloadMap && requestPayloadMap.size()>0) {
			
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			conditionMap.put("deleted", false);
			return this.requestGet(TableNameEnum.PROJECTLAB.getName(), conditionMap, this.getAssociationTableJsonNode(), TypeEnum.LAB.getName());
		}
		return null;
	}
	
	@PostMapping(value = "/lab/add")
	public Object add(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception {
		if(null != requestPayload)
		{
			
			ProjectLab projectLab = (ProjectLab) requestAdd(requestPayload,ProjectLab.class,this.getAssociationTableJsonNode(),TypeEnum.LAB.getName(),RedisUtil.getRedisUserInfo(tokenId));
			return projectLab;
		}
		return null;
	}

	@PostMapping(value = "/lab/list")
	public Object list(@RequestBody String requestPayload) throws Exception {
		
		return this.baseGetList(TableNameEnum.PROJECTLAB.getName(),this.getConditionMap(requestPayload));
	}

	@PostMapping(value = "/lab/listByUser")
	public Object listByUser(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception {
		return this.baseGetListByUser(TableNameEnum.PROJECTLAB.getName(), this.getConditionMap(requestPayload), this.getByUserMap(RedisUtil.getRedisUserInfo(tokenId).getUsername()));
	}

	@PostMapping(value = "/lab/listByOrg")
	public Object listByOrg(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception {
		return this.baseGetListByOrg(TableNameEnum.PROJECTLAB.getName(), this.getConditionMap(requestPayload), this.getByOrgMap(RedisUtil.getRedisUserInfo(tokenId).getOrganization_id()));
	}

	
	@RequestMapping(value = "/lab/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectLab projectLab = (ProjectLab) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectLab.class);
			if(null ==projectLab)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTLAB.getName(),this.getAssociationTableJsonNode(),TypeEnum.LAB.getName(),projectLab.getId());
			return projectLab;
		}
		return "接受前台数据为空";
	}
	@PostMapping(value = "/lab/search")
	public Object searchUser(@RequestBody String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			int pageSize = 0;
			if(requestPayloadMap.containsKey("name"))
			{
				conditionMap.put("name_like", requestPayloadMap.get("name"));
			}
		}
		return this.baseSearch(TableNameEnum.PROJECTLAB.getName(), conditionMap);

	}
	
	private Map<String,Object> getConditionMap(String requestPayload)throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map <String,Object> conditionMap = new HashMap<String,Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
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
		List list = new ArrayList<String>();
		list.add("member");
		list.add("technique");
		list.add("equipment");
		return list;
	}
	
	private Map<String,Object> getByUserMap(String uername)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.LAB.getName());
		map.put("username", uername);
		return map;
	}
	private Map<String,Object> getByOrgMap(String organization_id)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.LAB.getName());
		map.put("organization_id", organization_id);
		return map;
	}
}

