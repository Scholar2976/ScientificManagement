package com.hospital301.scientificmanagement.controller.project;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.ProjectCooperation;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.util.Util;

/** 
* @author 作者 
* @version 创建时间：2020年1月13日 下午7:46:44 
* 类说明 
*/
@RestController
public class CooperateController extends BaseController
{

	@RequestMapping(value = "/cooperate/list", method = RequestMethod.POST)
	public Object list(@RequestBody String requestPayload) throws Exception 
	{
		return this.baseGetList(TableNameEnum.PROJECTCOOPERATION.getName(),this.getConditionMap(requestPayload));
	}
	
	

	@PostMapping(value = "/cooperate/add")
	public Object add(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) throws Exception
	{
		if(null != requestPayload)
		{
			ProjectCooperation projectCooperation = (ProjectCooperation) requestAdd(requestPayload,ProjectCooperation.class,null,TypeEnum.COOPERATION.getName(),RedisUtil.getRedisUserInfo(tokenId));
			return projectCooperation;
		}
		return null;
	}
	
	
	@RequestMapping(value = "/cooperate/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectCooperation projectCooperation= (ProjectCooperation) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectCooperation.class);
			if(null ==projectCooperation)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTCOOPERATION.getName(),null,TypeEnum.COOPERATION.getName(),projectCooperation.getId());
			return projectCooperation;
		}
		return "接受前台数据为空";
	}
	
	
	private Map<String,Object> getConditionMap(String requestPayload) throws Exception
	{
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if(requestPayloadMap.containsKey("name"))
			{
				conditionMap.put("name_like", requestPayloadMap.get("name"));
			}
			conditionMap.put("deleted", false);
			int pageSize = 0;
			if (requestPayloadMap.containsKey("tRecInPage")) {

				pageSize = Integer.parseInt(requestPayloadMap.get("tRecInPage").toString());
				conditionMap.put("pageEnd", pageSize);
			}
			if (requestPayloadMap.containsKey("tPageJump")) {
				int page = Integer.parseInt(requestPayloadMap.get("tPageJump").toString());
				if (page == 0) {
					page = 1;
				}
				conditionMap.put("pageStart", (page - 1) * pageSize);
			}

		}
		return conditionMap;
	}

}
