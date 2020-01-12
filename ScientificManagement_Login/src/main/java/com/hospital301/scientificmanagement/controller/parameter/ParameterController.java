package com.hospital301.scientificmanagement.controller.parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.Parameter;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.services.parameter.ParameterService;
import com.hospital301.scientificmanagement.util.Util;

@RestController
public class ParameterController extends BaseController {
	@Autowired
	private ParameterService parameterService;

	@RequestMapping(value = "/parameter/get", method = RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception {
		Map<String, Object> map = (Map<String, Object>) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (map.containsKey("name")) {
			conditionMap.put("name", map.get("name"));
		}
		if (map.containsKey("range")) {
			conditionMap.put("range", map.get("range"));
		} else {
			conditionMap.put("range", "available");
		}
		Object jsonstr = parameterService.get(conditionMap);
		return jsonstr;
	}

	@RequestMapping(value = "/parameter/list", method = RequestMethod.POST)
	public Object list(@RequestBody String requestPayload) throws Exception {

		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("name")) {
				conditionMap.put("name_like", requestPayloadMap.get("name"));
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
		return this.baseGetList(null, TableNameEnum.PARAMETER.getName(), conditionMap);
	}

	@RequestMapping(value = "/parameter/save", method = RequestMethod.POST)
	public Object save(@RequestBody String requestPayload) throws Exception {
		if (null != requestPayload) {
			Parameter parameter = (Parameter) JsonUtil.JsonNodeToObject(requestPayload, "txnBodyCom", Parameter.class);
			if (null == parameter) {
				return "从json获取数据为空";
			}
			this.baseSaveOrUpdate(null, parameter);
			return parameter;
		}
		return null;
	}

	@RequestMapping(value = "/parameter/getTree", method = RequestMethod.POST)
	public Object getTree(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("name")) {
				conditionMap.put("name", requestPayloadMap.get("name"));
			}
			if (requestPayloadMap.containsKey("parent")) {
				conditionMap.put("parent", requestPayloadMap.get("parent"));
			} else {
				conditionMap.put("parent", requestPayloadMap.get(""));
			}
			if (conditionMap.containsKey("range")) {
				conditionMap.put("range", conditionMap.get("range"));
			} else {
				conditionMap.put("range", "available");
			}
		}
		return parameterService.getTree(conditionMap);
	}
	
	@RequestMapping(value = "/parameter/saveValue", method = RequestMethod.POST)
	public Object saveValue(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if (requestPayloadMap.containsKey("name")) {
				conditionMap.put("name", requestPayloadMap.get("name"));
			}
			if (requestPayloadMap.containsKey("parent")) {
				conditionMap.put("parent", requestPayloadMap.get("parent"));
			} else {
				conditionMap.put("parent", requestPayloadMap.get(""));
			}
			if (conditionMap.containsKey("range")) {
				conditionMap.put("range", conditionMap.get("range"));
			} else {
				conditionMap.put("range", "available");
			}
		}
		return parameterService.getTree(conditionMap);
	}
}
