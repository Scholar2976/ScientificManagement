package com.hospital301.scientificmanagement.controller.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.Project;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.controller.util.TypeEnum;
import com.hospital301.scientificmanagement.services.project.ProjectService;
import com.hospital301.scientificmanagement.util.Util;

/**
 * @author 作者
 * @version 创建时间：2020年1月2日 下午7:44:29 类说明
 */
@RestController
public class ProjectController extends BaseController 
{
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/project/search", method = RequestMethod.POST)
	public Object search(@RequestBody String requestPayload) throws Exception {
		if (null == requestPayload) {
			return null;
		}
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (requestPayloadMap.containsKey("name")) {
			conditionMap.put("name_like", requestPayloadMap.get("name"));
		}
		return this.baseSearch("project", conditionMap);
	}

	@RequestMapping(value = "/project/list", method = RequestMethod.POST)
	public Object list(@RequestBody String requestPayload) throws Exception 
	{
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if(requestPayloadMap.containsKey("name"))
			{
				conditionMap.put("name_like", requestPayloadMap.get("name"));
			}
			if(requestPayloadMap.containsKey("fund1"))
			{
				conditionMap.put("fund1", Float.parseFloat((String) requestPayloadMap.get("fund1")));
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
		return projectService.QueryTableInfoByPage(conditionMap);
	}
	
	
	@RequestMapping(value = "/project/listByUser", method = RequestMethod.POST)
	public Object listByUser(@RequestBody String requestPayload) throws Exception 
	{
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if(requestPayloadMap.containsKey("name"))
			{
				conditionMap.put("name_like", requestPayloadMap.get("name"));
			}
			if(requestPayloadMap.containsKey("fund1"))
			{
				conditionMap.put("fund1", Float.parseFloat((String) requestPayloadMap.get("fund1")));
			}
			if(requestPayloadMap.containsKey("username"))
			{
				conditionMap.put("fund1", requestPayloadMap.get("username"));
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
		return projectService.QueryTableInfoByUser(conditionMap);
	}
	
	@RequestMapping(value = "/project/listByOrg", method = RequestMethod.POST)
	public Object listByOrg(@RequestBody String requestPayload) throws Exception 
	{
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (null != requestPayloadMap && requestPayloadMap.size() > 0) {
			if(requestPayloadMap.containsKey("name"))
			{
				conditionMap.put("name_like", requestPayloadMap.get("name"));
			}
			if(requestPayloadMap.containsKey("fund1"))
			{
				conditionMap.put("fund1", Float.parseFloat((String) requestPayloadMap.get("fund1")));
			}
			if(requestPayloadMap.containsKey("username"))
			{
				conditionMap.put("fund1", requestPayloadMap.get("username"));
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
		return projectService.QueryTableInfoByOrg(conditionMap);
	}
	
	@PostMapping(value = "/project/add")
	public Object add(@RequestBody String requestPayload) throws Exception {
		if(null != requestPayload)
		{
			Project project = (Project) requestAdd(requestPayload,Project.class,this.getAssociationTableJsonNode(),TypeEnum.PROJECT.getName());
			return project;
		}
		return null;
	}
	
	@RequestMapping(value = "project/validateProjectId", method = RequestMethod.POST)
	public Object validateProjectId(@RequestBody String requestPayload ) throws Exception
	{
		if (null == requestPayload) {
			return null;
		}
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (requestPayloadMap.containsKey("project_id")) {
			conditionMap.put("project_id", requestPayloadMap.get("project_id"));
		}
		if (requestPayloadMap.containsKey("id")) {
			conditionMap.put("id", requestPayloadMap.get("id"));
		}
		return validate("project",conditionMap);
		
	}
	
	@RequestMapping(value = "project/validateProjectName", method = RequestMethod.POST)
	public Object validateProjectName(@RequestBody String requestPayload ) throws Exception
	{
		if (null == requestPayload) {
			return null;
		}	
		Map requestPayloadMap = (Map) Util.isNull(requestPayload, false, null);
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if (requestPayloadMap.containsKey("name")) {
			conditionMap.put("name", requestPayloadMap.get("name"));
		}
		if (requestPayloadMap.containsKey("id")) {
			conditionMap.put("id", requestPayloadMap.get("id"));
		}
		return validate("project",conditionMap);
	}
	
	@RequestMapping(value = "/project/remove", method = RequestMethod.POST)
	public Object remove(@RequestBody String requestPayload)throws Exception 
	{	
		if(null != requestPayload)
		{
			Project project = (Project) JsonUtil.JsonNodeToObject(requestPayload,"txnBodyCom",Project.class);
			if(null ==project)
				return "从json获取数据为空";
			this.basedelete(TableNameEnum.PROJECTLAB.getName(),this.getAssociationTableJsonNode(),TypeEnum.LAB.getName(),project.getId());
			return project;
		}
		return "接受前台数据为空";
	}
	
	
	private Object validate(String tableName,Map<String,Object> conditionMap)
	{
		return this.baseValidate(tableName, conditionMap);
	}
	
	private List<String> getAssociationTableJsonNode()
	{
		List list = new ArrayList<String>();
		list.add("member");
		list.add("chief_author");
		list.add("fund");
		list.add("unit");
		list.add("keyword");
		return list;
	}
	
}
