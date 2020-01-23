package com.hospital301.scientificmanagement.controller.academyPost;

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

import com.ccb.sm.entities.ProjectAcademyPost;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.RedisUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.services.academicpost.Academicpost;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class academyPostController extends BaseController {
	@Autowired
	private Academicpost academicpostService;

	@RequestMapping(value = "/academy_post/list", method = RequestMethod.POST)
	public Object getList(@RequestBody String requestPayload) throws Exception {
		Object object = this.baseGetList(TableNameEnum.PROJECTACADEMYPOST.getName(),
				this.getConditionMap(requestPayload));
		if (null == object)
			return null;
		return JsonUtil.objectToJson(object);
	}

	@RequestMapping(value = "/academy_post/listByUser", method = RequestMethod.POST)
	public Object listByUser(@RequestBody String requestPayload) throws Exception {
		Object object = this.baseGetListByUser(TableNameEnum.PROJECTACADEMYPOST.getName(),
				this.getConditionMap(requestPayload), this.getByUserMap());
		if (null == object)
			return null;

		return JsonUtil.objectToJson(object);
	}

	@RequestMapping(value = "/academy_post/listByOrg", method = RequestMethod.POST)
	public Object listByOrg(@RequestBody String requestPayload) throws Exception {
		Object object = this.baseGetListByOrg(TableNameEnum.PROJECTACADEMYPOST.getName(),
				this.getConditionMap(requestPayload), this.getByOrgMap());
		if (null == object)
			return null;
		return JsonUtil.objectToJson(object);
	}

	@RequestMapping(value = "/academy_post/add", method = RequestMethod.POST)
	public Object add(@RequestHeader(value = "C-Dynamic-Password-Foruser") String tokenId,
			@RequestBody String requestPayload) throws Exception {
		if (null != requestPayload) {
			ProjectAcademyPost projectAcademyPost = (ProjectAcademyPost) requestAdd(requestPayload,
					ProjectAcademyPost.class, this.getAssociationTableJsonNode(), TypeEnum.ACADEMY.getName(),
					RedisUtil.getRedisUserInfo(tokenId));
			if (null == projectAcademyPost)
				return null;
			return JsonUtil.objectToJson(projectAcademyPost);
			// return projectAcademyPost;
		}
		return "接受前台数据为空";
	}

	@RequestMapping(value = "/academy_post/get", method = RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {

			if (requestPayloadMap.containsKey("id")) {
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			return this.requestGet("project_academy_post", conditionMap, this.getAssociationTableJsonNode(),
					TypeEnum.ACADEMY.getName());
		}
		return null;
	}

	@RequestMapping(value = "/academy_post/remove", method = RequestMethod.POST)
	public Object delete(@RequestBody String requestPayload) throws Exception {
		if (null != requestPayload) {
			ProjectAcademyPost projectAcademyPost = (ProjectAcademyPost) JsonUtil.JsonNodeToObject(requestPayload,
					"txnBodyCom", ProjectAcademyPost.class);
			if (null == projectAcademyPost)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTACADEMYPOST.getName(), this.getAssociationTableJsonNode(),
					TypeEnum.ACADEMY.getName(), projectAcademyPost.getId());
			return projectAcademyPost;
		}
		return null;
	}

	private Map<String, Object> getConditionMap(String requestPayload) throws Exception {

		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("academy_name")) {
				conditionMap.put("academy_name_like", requestPayloadMap.get("academy_name"));
			}
			if (requestPayloadMap.containsKey("nickname")) {
				conditionMap.put("nickname_like", requestPayloadMap.get("nickname"));
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
		return list;
	}

	private Map<String, Object> getByUserMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.ACADEMY.getName());
		map.put("username", "admin");
		return map;
	}

	private Map<String, Object> getByOrgMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", TypeEnum.ACADEMY.getName());
		map.put("organization_id", "");
		return map;
	}

	public Academicpost getAcademicpostService() {
		return academicpostService;
	}

	public void setAcademicpostService(Academicpost academicpostService) {
		this.academicpostService = academicpostService;
	}

}
