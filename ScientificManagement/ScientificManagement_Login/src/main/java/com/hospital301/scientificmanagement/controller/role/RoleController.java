package com.hospital301.scientificmanagement.controller.role;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.RoleUserRel;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.services.role.RoleService;
import com.hospital301.scientificmanagement.util.Util;

/**
 * @author 作者
 * @version 创建时间：2020年1月19日 上午9:42:39 类说明
 */

@RestController
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/role/list", method = RequestMethod.POST)
	public Object list() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", this.QueryTableInfo(TableNameEnum.ROLE.getName(), null));
		return resultMap;
	}

	@RequestMapping(value = "role/getUsers", method = RequestMethod.POST)
	public Object getUsers(@RequestBody String requestPayload) throws Exception {
		if(null == requestPayload)
			return null;
		return roleService.QueryTableInfoByPage(this.getConditionMap(requestPayload));
	}

	@RequestMapping(value = "role/add", method = RequestMethod.POST)
	public Object add(@RequestBody String requestPayload) throws Exception {
		if(null == requestPayload)
			return null;
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}
			if (requestPayloadMap.containsKey("name")) {
				conditionMap.put("role", requestPayloadMap.get("name"));
			}
		}
		boolean validatedFlag = this.ValidatedRole(conditionMap);
		if(!validatedFlag)
		{
			RoleUserRel roleUserRel = (RoleUserRel) JsonUtil.JsonNodeToObject(requestPayload, "txnBodyCom", RoleUserRel.class);
			return this.baseAdd(roleUserRel);
		}
		return "当前角色已经包含此用户";
	}
	

	@RequestMapping(value = "role/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload) throws Exception {
		if(null == requestPayload)
			return null;
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("name")) {
				conditionMap.put("role", requestPayloadMap.get("name"));
			}
			if (requestPayloadMap.containsKey("username")) {
				conditionMap.put("username", requestPayloadMap.get("username"));
			}
		}
		return this.baseDeletedByMap(TableNameEnum.ROLEUSERREL.getName(),conditionMap);
	}
	
	
	
	
	private Map<String, Object> getConditionMap(String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("name")) {
				conditionMap.put("role_name", requestPayloadMap.get("name"));
			}
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
	
	private boolean ValidatedRole (Map<String,Object> conditionMap) throws Exception
	{
		Object object = this.baseValidate(TableNameEnum.ROLEUSERREL.getName(), conditionMap);
		if(null == object)
		{
			return true;
		}
		return false;
	}
}
