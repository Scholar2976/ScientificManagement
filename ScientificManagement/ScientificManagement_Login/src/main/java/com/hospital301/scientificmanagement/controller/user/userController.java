package com.hospital301.scientificmanagement.controller.user;

import static org.junit.Assert.assertNotNull;

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

import com.ccb.sm.entities.ProjectMember;
import com.ccb.sm.entities.User;
import com.ccb.sm.response.ErrorResponseCommInfo;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.services.user.UserService;
import com.hospital301.scientificmanagement.util.Util;


@RestController
public class userController extends BaseController 
{
	@Autowired
	private UserService userServiceImp; 
	
	@RequestMapping(value="/user/searchUser",method=RequestMethod.POST)
	public Object searchUser(@RequestBody(required=false) String requestPayload) throws Exception
	{
		if(null == requestPayload)
		{
			return null;
		}
		Map map = (Map) Util.isNull(requestPayload, false, null);
		return userServiceImp.searchUser(map.get("username").toString());
	}

	@RequestMapping(value="/user/list",method=RequestMethod.POST)
	public Object getList(@RequestBody(required=false) String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("username"))
			{
				conditionMap.put("username_like", requestPayloadMap.get("username"));
			}
			if(requestPayloadMap.containsKey("nickname"))
			{
				conditionMap.put("nickname_like", requestPayloadMap.get("nickname"));
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
		return this.baseGetList(TableNameEnum.USER.getName(),conditionMap);
	}
	

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public Object add(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			User user = (User) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",User.class);
			if(null ==user)
				return "从json获取数据为空";
			this.baseSaveOrUpdate(null, user);
			Object[] projectMemberArray = (Object[]) JsonUtil.JsonNodeToObject(requestPayload, "member",ProjectMember[].class);
			if(null !=projectMemberArray && projectMemberArray.length>0 )
				this.baseBatchAdd(null,Util.asList(projectMemberArray));
			return user;
		}
		return "Background get foreground data is null";
	}
	
	
	@RequestMapping(value = "/user/validateUserId", method = RequestMethod.POST)
	public Object validateUserId(@RequestBody String requestPayload)throws Exception 
	{	
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			if(requestPayloadMap.containsKey("username"))
			{
				conditionMap.put("username", requestPayloadMap.get("username"));
			}
			conditionMap.put("deleted", false);
		}
		ArrayList<String> tableNameList = new ArrayList<String>();
		tableNameList.add("user");
		
		return this.baseValidate("user", conditionMap);
	}
	
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
	public Object changePassword(@RequestBody String requestPayload)throws Exception 
	{	
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			if(requestPayloadMap.containsKey("username"))
			{
				conditionMap.put("username", requestPayloadMap.get("username"));
			}
			conditionMap.put("deleted", false);
		}
		ArrayList<String> tableNameList = new ArrayList<String>();
		tableNameList.add("user");
		return this.updateByMap(null, User.class, conditionMap);
	}
	

	@RequestMapping(value = "/user/get", method = RequestMethod.POST)
	public Object get(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenid,@RequestBody String requestPayload)throws Exception 
	{	
		User user = RedisUtil.getRedisUserInfo(tokenid);
		if(null != user)
		{
			return user;
		}
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			if(requestPayloadMap.containsKey("username"))
			{
				conditionMap.put("username", requestPayloadMap.get("username"));
			}
		}
		List<Map<String, Object>> resultList = this.baseGet("user", conditionMap);
		if(null != resultList && resultList.size()>0)
		{
			return resultList.get(0);
		}
		return new ErrorResponseCommInfo();
	}

}
