package com.hospital301.scientificmanagement.controller.scientificPlatform.equipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.ProjectEquipment;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.util.Util;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 上午9:45:33 
* 类说明 
*/
@RestController
public class EquipmentController extends BaseController
{
	
	@RequestMapping(value = "/equipment/get",method=RequestMethod.POST)
	public Object get(@RequestBody String requestPayload) throws Exception
	{
		
		Map requestPayloadMap = ParesJsonUtil.JsonTOMap(requestPayload);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if (null != requestPayloadMap && requestPayloadMap.size()>0) {
			
			if(requestPayloadMap.containsKey("id"))
			{
				conditionMap.put("id", requestPayloadMap.get("id"));
			}
			List<String> list = new ArrayList<String>();
			list.add("member");
			return this.requestGet("project_equipment", conditionMap, list, TypeEnum.EQUIPMENT.getName());
//			return this.baseQueryById("project_lab",Integer.parseInt(requestPayloadMap.get("id").toString()));
		}
		return null;
	}
	
	@PostMapping(value = "/equipment/add")
	public Object add(@RequestBody String requestPayload) throws Exception {
		if(null != requestPayload)
		{
			List list = new ArrayList<String>();
			list.add("member");
			ProjectEquipment projectEquipment = (ProjectEquipment) requestAdd(requestPayload,ProjectEquipment.class,list,TypeEnum.EQUIPMENT.getName());
			return projectEquipment;
		}
		return null;
	}

	@PostMapping(value = "/equipment/list")
	public Object list(@RequestBody String requestPayload) throws Exception {
		Map requestPayloadMap = (Map)Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(null != requestPayloadMap && requestPayloadMap.size()>0)
		{
			int pageSize = 0;
			if(requestPayloadMap.containsKey("title"))
			{
				conditionMap.put("name_like", requestPayloadMap.get("title"));
			}
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
		return this.baseGetList(null, TableNameEnum.PROJECTEQUIPMENT.getName(),conditionMap);
	}

	@RequestMapping(value = "/equipment/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			ProjectEquipment projectEquipment = (ProjectEquipment) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",ProjectEquipment.class);
			if(null ==projectEquipment)
				return "从json获取数据为空";
//			this.basedelete(null,"project_equipment",projectEquipment.getId());
			return projectEquipment;
		}
		return "接受前台数据为空";
	}

}
