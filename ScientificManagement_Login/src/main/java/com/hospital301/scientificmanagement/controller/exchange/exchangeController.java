package com.hospital301.scientificmanagement.controller.exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.TokenId;
import org.apache.maven.shared.artifact.filter.StatisticsReportingArtifactFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ccb.sm.entities.ProjectExchange;
import com.ccb.sm.entities.User;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.Redis.Redis;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.user.userController;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.util.Util;

/** 
* @author 作者 
* @version 创建时间：2019年12月27日 上午9:25:08 
* 类说明 
*/
@RestController
public class exchangeController extends BaseController
{
	@Autowired
	private Redis redis;
	@RequestMapping(value="/exchange/list",method=RequestMethod.POST) 
	public Object list(@RequestBody String requestPayload)throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("title"))
			{
				conditionMap.put("title_like", requestPayloadMap.get("title"));
			}
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
		return this.baseGetList(null, TableNameEnum.PROJECTEXCHANGE.getName(),conditionMap);
	}
	
	@RequestMapping(value="/exchange/listByUser",method=RequestMethod.POST) 
	public Object listByUser(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload)throws Exception
	{
		return this.baseGetListByUser(TableNameEnum.PROJECTEXCHANGE.getName(), this.getConditionMap(requestPayload), this.getByUserMap(getRedisUserInfo("token:"+tokenId).getUsername()));
	}
	
	@RequestMapping(value="/exchange/listByOrg",method=RequestMethod.POST) 
	public Object listByOrg(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload)throws Exception
	{
		return this.baseGetListByOrg(TableNameEnum.PROJECTEXCHANGE.getName(), this.getConditionMap(requestPayload), this.getByOrgMap(getRedisUserInfo("token:"+tokenId).getOrganization_id()));
	}
	
	@RequestMapping(value="/exchange/add",method=RequestMethod.POST)
	public Object add(@RequestBody String requestPayload) throws Exception
	{
		if(null != requestPayload)
		{
			ProjectExchange projectExchange = (ProjectExchange) requestAdd(requestPayload,ProjectExchange.class,this.getAssociationTableJsonNode(),TypeEnum.EXCHANGE.getName());
			return projectExchange;
		}
		return null;
	}
	
	@RequestMapping(value = "/exchange/get",method=RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception
	{
		
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if (null != requestPayloadMap && requestPayloadMap.size()>0) {
			
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			return this.requestGet("project_exchange", conditionMap, this.getAssociationTableJsonNode(), TypeEnum.EXCHANGE.getName());
		}
		return null;
	}
	

	@RequestMapping(value = "/exchange/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectExchange projectExchange = (ProjectExchange) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectExchange.class);
			if(null ==projectExchange)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTEXCHANGE.getName(),this.getAssociationTableJsonNode(),TypeEnum.EXCHANGE.getName(),projectExchange.getId());
			return projectExchange;
		}
		return "接受前台数据为空";
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
	
	private Map<String,Object> getByUserMap(String username)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.EXCHANGE.getName());
		map.put("username", username);
		return map;
	}
	private Map<String,Object> getByOrgMap(String organization_id)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.EXCHANGE.getName());
		map.put("organization_id", organization_id);
		return map;
	}

	private List<String> getAssociationTableJsonNode()
	{
		List<String> list = new ArrayList<String>();
		list.add("member");
		list.add("unit");
		list.add("undertake_unit");
		return list;
	}
	
	private User getRedisUserInfo(String tokenid)
	{
		return (User) redis.getUserInfo(tokenid);
	}
}
