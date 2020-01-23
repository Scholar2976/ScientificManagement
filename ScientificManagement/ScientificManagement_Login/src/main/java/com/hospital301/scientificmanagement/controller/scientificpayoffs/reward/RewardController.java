package com.hospital301.scientificmanagement.controller.scientificpayoffs.reward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ccb.sm.entities.ProjectReward;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.services.scientificpayoffs.reward.RewardService;
import com.hospital301.scientificmanagement.util.Util;



@RestController
public class RewardController extends BaseController
{
	@Autowired
	private RewardService rewardservice;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/reward/list", method = RequestMethod.POST)
	public Object getRewardList(@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetList(TableNameEnum.PROJECTREWARD.getName(),this.getConditionMap(requestPayload));
	}
	
	
	@RequestMapping(value = "/reward/listByUser", method = RequestMethod.POST)
	public Object listByUser(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByUser(TableNameEnum.PROJECTREWARD.getName(), this.getConditionMap(requestPayload), this.getByUserMap(tokenId));
	}
	
	@RequestMapping(value = "/reward/listByOrg", method = RequestMethod.POST)
	public Object listByOrg(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		return this.baseGetListByOrg(TableNameEnum.PROJECTREWARD.getName(), this.getConditionMap(requestPayload), this.getByOrgMap(tokenId));
	}
	
	@RequestMapping(value = "/reward/add", method = RequestMethod.POST)
	public Object add(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectReward projectReward = (ProjectReward) requestAdd(requestPayload,ProjectReward.class,this.getAssociationTableJsonNode(),TypeEnum.REWARD.getName(),RedisUtil.getRedisUserInfo(tokenId));
			return projectReward;
		}
		return null;
	}
	
	
	@RequestMapping(value = "/reward/get", method = RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception 
	{
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if (null != requestPayloadMap && requestPayloadMap.size()>0) {
			
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			return this.requestGet(TableNameEnum.PROJECTREWARD.getName(), conditionMap, this.getAssociationTableJsonNode(), TypeEnum.REWARD.getName());
		}
		return null;
	}
	
	@RequestMapping(value = "/reward/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload) throws  Exception 
	{
		if(requestPayload != null)
		{
			Map txnBodyComMap = ParesJsonUtil.JsonTOMap(requestPayload.toString());
			if(txnBodyComMap.containsKey("id"))
			{
				return this.basedelete(TableNameEnum.PROJECTREWARD.getName(),this.getAssociationTableJsonNode(),TypeEnum.REWARD.getName(), Integer.valueOf(txnBodyComMap.get("id").toString()));
			}
			return null;
		}
		return returnStr();
		
	}
	
	@RequestMapping(value = "/reward/validateRewardId", method = RequestMethod.POST)
	public Object validate(@RequestBody String requestPayload) throws Exception
	{
		if (null == requestPayload) {
			return null;
		}
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (requestPayloadMap.containsKey("reward_id")) {
			conditionMap.put("reward_id", requestPayloadMap.get("reward_id"));
		}
		if (requestPayloadMap.containsKey("id")) {
			conditionMap.put("id", requestPayloadMap.get("id"));
		}
		conditionMap.put("deleted", false);
		return baseValidate(TableNameEnum.PROJECTREWARD.getName(),conditionMap);
		
	}
	
	private Map<String,Object> getConditionMap(String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("year"))
			{
				conditionMap.put("year", requestPayloadMap.get("year"));
			}
			if(requestPayloadMap.containsKey("type"))
			{
				conditionMap.put("type", requestPayloadMap.get("type"));
			}
			if(requestPayloadMap.containsKey("domain"))
			{
				conditionMap.put("domain", requestPayloadMap.get("domain"));
			}
			if(requestPayloadMap.containsKey("level"))
			{
				conditionMap.put("level", requestPayloadMap.get("level"));
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
		map.put("type", TypeEnum.REWARD.getName());
		map.put("username", RedisUtil.getRedisUserInfo(tokenid).getUsername());
		return map;
	}
	private  Map<String,Object> getByOrgMap(String tokenid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.REWARD.getName());
		map.put("organization_id", RedisUtil.getRedisUserInfo(tokenid).getOrganization_id());
		return map;
	}
	
	private List<String> getAssociationTableJsonNode()
	{
		List<String> list = new ArrayList<String>();
		list.add("member");
		list.add("project");
		list.add("unit");
		list.add("keyword");
		return list;
	}
	
	private String returnStr()
	{
		return "接受前台数据为空";
	}
	
		
}
