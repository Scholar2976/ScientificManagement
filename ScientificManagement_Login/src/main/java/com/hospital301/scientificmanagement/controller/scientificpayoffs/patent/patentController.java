package com.hospital301.scientificmanagement.controller.scientificpayoffs.patent;

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
import org.w3c.dom.ls.LSInput;

import com.ccb.sm.entities.ProjectPatent;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.services.scientificpayoffs.patent.PatentService;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class patentController extends BaseController {

	@Autowired
	private PatentService patentService;

	@RequestMapping(value = "/patent/list", method = RequestMethod.POST)
	public Object getRewardList(@RequestBody String requestPayload) throws Exception {
		return this.baseGetList(TableNameEnum.PROJECTPATENT.getName(), this.getConditionMap(requestPayload));
	}

	@RequestMapping(value = "/patent/listByUser", method = RequestMethod.POST)
	public Object listByUser(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenId,
			@RequestBody String requestPayload) throws Exception {
		return this.baseGetListByUser(TableNameEnum.PROJECTPATENT.getName(), this.getConditionMap(requestPayload),
				this.getByUserMap(tokenId));
	}

	@RequestMapping(value = "/patent/listByOrg", method = RequestMethod.POST)
	public Object listByOrg(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenId,
			@RequestBody String requestPayload) throws Exception {
		return this.baseGetListByOrg(TableNameEnum.PROJECTPATENT.getName(), this.getConditionMap(requestPayload),
				this.getByOrgMap(tokenId));

	}

	@RequestMapping(value = "/patent/add", method = RequestMethod.POST)
	public Object add(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenId,
			@RequestBody String requestPayload) throws Exception {
		if (null != requestPayload) {
			ProjectPatent projectPatent = (ProjectPatent) requestAdd(requestPayload, ProjectPatent.class,
					this.getAssociationTableJsonNode(), TypeEnum.PATENT.getName(), RedisUtil.getRedisUserInfo(tokenId));
			return projectPatent;
		}
		return null;
	}

	@RequestMapping(value = "/patent/get", method = RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception {

		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {

			if (requestPayloadMap.containsKey("id")) {
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			return this.requestGet(TableNameEnum.PROJECTPATENT.getName(), conditionMap,
					this.getAssociationTableJsonNode(), TypeEnum.PATENT.getName());
		}
		return null;
	}

	@RequestMapping(value = "/patent/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload) throws Exception {
		if (null != requestPayload) {
			ProjectPatent projectPatent = (ProjectPatent) JsonUtil.JsonNodeToObject(requestPayload, "txnBodyCom",
					ProjectPatent.class);
			if (null == projectPatent)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTPATENT.getName(), this.getAssociationTableJsonNode(),
					TypeEnum.PATENT.getName(), projectPatent.getId());
			return projectPatent;
		}
		return "接受前台数据为空";
	}

	private Map<String, Object> getConditionMap(String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("title")) {
				conditionMap.put("title_like", requestPayloadMap.get("title"));
			}
			if (requestPayloadMap.containsKey("inventor")) {
				conditionMap.put("inventor", requestPayloadMap.get("inventor"));
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

	private List<String> getAssociationTableJsonNode() {
		List<String> list = new ArrayList<String>();
		list.add("member");
		list.add("inventor");
		list.add("proposer");
		list.add("patentee");
		return list;
	}

	private Map<String, Object> getByUserMap(String tokenid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.PATENT.getName());
		map.put("username", RedisUtil.getRedisUserInfo(tokenid).getUsername());
		return map;
	}

	private Map<String, Object> getByOrgMap(String tokenid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.PATENT.getName());
		map.put("organization_id", RedisUtil.getRedisUserInfo(tokenid).getOrganization_id());
		return map;
	}
}
