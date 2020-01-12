package com.hospital301.scientificmanagement.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.shared.artifact.filter.StatisticsReportingArtifactFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ccb.sm.entities.ProjectAttachment;
import com.ccb.sm.entities.ProjectEquipment;
import com.ccb.sm.entities.ProjectFund;
import com.ccb.sm.entities.ProjectKeyword;
import com.ccb.sm.entities.ProjectLabTechnique;
import com.ccb.sm.entities.ProjectMember;
import com.ccb.sm.entities.ProjectRelationRel;
import com.ccb.sm.entities.ProjectUnit;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.controller.util.TableNameEnum;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;
import com.hospital301.scientificmanagement.util.Util;

import ch.qos.logback.core.joran.conditional.Condition;

@Service("BaseServiceImpl")
@Transactional(rollbackFor=Exception.class)
public class BaseServiceImpl implements BaseServieInterface {
	@Autowired
	protected FatherMapper fatherMapper;

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Map QueryTableInfoByPage(String tableName, Map<String, Object> map) {
		// TODO Auto-generated method stub
		List list = fatherMapper.baseQueryByMap(tableName, map);
		Integer total = fatherMapper.baseGetSelectTotal(tableName, map);
		Map resultMap = new HashMap<>();
		resultMap.put("page", list);
		resultMap.put("total", total);
		return resultMap;
	}
	@Override
	public Object insert(Object obj) {
		// TODO Auto-generated method stub
		return fatherMapper.baseInsert(obj);
	}

	@Override
	public Integer logicDelete(String tableName,List<String> arrayList,String type, Integer id ) throws Exception {
		// TODO Auto-generated method stub
		Integer integer = fatherMapper.baseLogicDeleteById(tableName, id);
		for(String AssociationJsonNode : arrayList)
		{
			Map map = this.HandleDeletedAssociationTable(AssociationJsonNode, type, id);
			if(null == map)
				continue;
			String AssociationTableName = map.get("tablename").toString();
			map.remove("tablename");
			fatherMapper.baseLogicDeleteByMap(AssociationTableName, map);
		}
		return integer;	
	}

	public int deleteByMap(String tableName, Map<String, Object> conditionMap) {
		return fatherMapper.baseDeleteByMap(tableName, conditionMap);
	}

	public Object batchInsert(List list) {
		// TODO Auto-generated method stub
		return fatherMapper.baseBatchInsert(list);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Map<String, Object>> queryByMap(String tableName, Map<String, Object> conditionMap) {
		// TODO Auto-generated method stub
		return fatherMapper.baseQueryByMap(tableName, conditionMap);
	}
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Map<String ,Object> queryByUser(String tableName, Map<String, Object> conditionMap,Map<String, Object> map) {
		// TODO Auto-generated method stub
		List list = fatherMapper.baseQueryByUserOrOrg(tableName, conditionMap, map, "byuser");
		Integer total = fatherMapper.baseGetSelectTotalByUserOrOrg(tableName, conditionMap, map, "byuser");
		Map resultMap = new HashMap<>();
		resultMap.put("page", list);
		resultMap.put("total", total);
		return resultMap;
	}
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Map<String,Object> queryByOrg(String tableName, Map<String, Object> conditionMap ,Map<String, Object> map) {
		// TODO Auto-generated method stub
		List list = fatherMapper.baseQueryByUserOrOrg(tableName, conditionMap,map,"byorg");
		Integer total = fatherMapper.baseGetSelectTotalByUserOrOrg(tableName, conditionMap, map, "byorg");
		Map resultMap = new HashMap<>();
		resultMap.put("page", list);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> queryById(String tableName, Integer id) {
		// TODO Auto-generated method stub
		return fatherMapper.baseQueryById(tableName, id);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Map<String, Object>> validate(String tableName, Map<String, Object> conditionMap) {
		// TODO Auto-generated method stub
		return fatherMapper.baseValidate(tableName, conditionMap);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List QueryTableInfo(String tableName, Map<String, Object> map) {
		List list = fatherMapper.baseQueryByMap(tableName, map);
		return list;
	}

	public Object baseSaveOrUpdate(Object object)throws Exception {
		return fatherMapper.baseSaveOrUpdate(this.handleObj(object));
	}

	public Object updateByMap(Class clazz, Map<String, Object> conditionMap) {
		return fatherMapper.baseUpdateByMap(clazz, conditionMap);
	}

	/**
	 * 处理前台的jsons数据中需要插入多表的情况
	 * @param requestPayload 前台请求报文
	 * @param clazz  主表实体类
	 * @param arrayList json数据中的需要插入数据库的节点是数组时将节点名称添加到此变量中
	 * @return
	 * @throws Exception
	 */
	
	public Object add(@RequestHeader("")String requestPayload, Class clazz, List<String> arrayList, String type) throws Exception {
		List list = new ArrayList();
		Object obj = null;
		obj = JsonUtil.JsonNodeToObject(requestPayload, "txnBodyCom", clazz);
		this.baseSaveOrUpdate(this.handleObj(obj));
		Integer id = new Integer(0);
		Object object = this.getId(obj);
		{
			if (null == object) {
				return null;
			}
			id = Integer.parseInt(object.toString());
		}
		// 处理关联表的插入
		for (String AssociationName : arrayList) {
			Object[] objects = this.HandleAddAssociationTableJson(AssociationName, requestPayload, type, id);
			if (null != objects && objects.length > 0)
				this.batchInsert(Util.asList(objects));
		}
		return obj;
	}
	
	
	/**
	 * 查询主表和关联表信息
	 * @param tableName 主表名称
	 * @param conditionMap 主表查询条件
	 * @param list 关联表json节点名称
	 * @param type 
	 * @return Json字符串
	 */
	public Object get(String tableName, Map<String,Object> conditionMap,List<String> list,String type) throws Exception
	{ 
		List<Map<String,Object>> listMap = fatherMapper.baseQueryByMap(tableName, conditionMap);
		if(null == listMap || listMap.size()==0 )
			return null;
		String mainJson = JsonUtil.getJsonResult(listMap.get(0));
		Integer id = (Integer) listMap.get(0).get("id");
		for(String AssociationName : list)
		{
			List<Map<String,Object>> associationTableList = this.getAddAssociationTableConditionMap(AssociationName,type,id);
			if(null != associationTableList && associationTableList.size()>0)
			{
				mainJson = JsonUtil.addJsonNode(mainJson, associationTableList, null, AssociationName);
			}
		}
		return mainJson;
	}

	/**
	 * 将关联表中的数据冲json中取出，并转换成相应实体类数组
	 * 
	 * @param AssociationName
	 * @param requestPayload
	 *            json报文
	 * @return
	 * @throws Exception
	 */
	private Object[] HandleAddAssociationTableJson(String AssociationName, String requestPayload, String type,
			Integer id) throws Exception {
		switch (AssociationName) {

		case "member":
			ProjectMember[] projectMemberArray = (ProjectMember[]) JsonUtil.JsonNodeToObject(requestPayload, "member",
					ProjectMember[].class);
			return this.ObjectFieldAssignment(projectMemberArray, type,"member", id);
		case "chief_author":
			ProjectMember[] projectMemberArray1 = (ProjectMember[]) JsonUtil.JsonNodeToObject(requestPayload,
					"chief_author", ProjectMember[].class);
			return this.ObjectFieldAssignment(projectMemberArray1, type, "chief_author", id);
		case "deputy_author":

			ProjectMember[] projectMemberArray2 = (ProjectMember[]) JsonUtil.JsonNodeToObject(requestPayload,
					"deputy_author", ProjectMember[].class);
			return this.ObjectFieldAssignment(projectMemberArray2, type, "deputy_author", id);
		case "inventor":

			ProjectMember[] projectMemberArray3 = (ProjectMember[]) JsonUtil.JsonNodeToObject(requestPayload,
					"inventor", ProjectMember[].class);
			return this.ObjectFieldAssignment(projectMemberArray3, type, "inventor", id);
		case "unit":

			ProjectUnit[] projectUnitArray = (ProjectUnit[]) JsonUtil.JsonNodeToObject(requestPayload, "unit",
					ProjectUnit[].class);
			return this.ObjectFieldAssignment(projectUnitArray, type, null, id);
		case "keyword":
			List<String> list = (List<String>) JsonUtil.JsonNodeToObject(requestPayload,"keyword", null);
			if(null == list || list.size()==0)
				return null;
			ProjectKeyword[] projectkeywordArray = new ProjectKeyword[list.size()];
			for(int i =0 ;i<list.size();i++)
			{
				ProjectKeyword projectKeyword = new ProjectKeyword();
				projectKeyword.setKeyword(list.get(i));
				projectkeywordArray[i]=projectKeyword;
			}
			return this.ObjectFieldAssignment(projectkeywordArray, type, null, id);
		case "attachment":
			ProjectAttachment[] projectAttachmentArray = (ProjectAttachment[]) JsonUtil.JsonNodeToObject(requestPayload,
					"attachment", ProjectAttachment[].class);
			return this.ObjectFieldAssignment(projectAttachmentArray, type, null, id);
		case "project":
			ProjectRelationRel[] projectArray = (ProjectRelationRel[]) JsonUtil.JsonNodeToObject(requestPayload, "project", ProjectRelationRel[].class);
			return this.ObjectFieldAssignment(projectArray, type, null, id);
		case "equipment":
			ProjectEquipment[] projectEquipmentArray = (ProjectEquipment[]) JsonUtil.JsonNodeToObject(requestPayload,
					"equipment", ProjectEquipment[].class);
			return this.ObjectFieldAssignment(projectEquipmentArray, null, null, id);
		case "technique":

			ProjectLabTechnique[] projectLabTechniqueArray = (ProjectLabTechnique[]) JsonUtil
					.JsonNodeToObject(requestPayload, "technique", ProjectLabTechnique[].class);
			return this.ObjectFieldAssignment(projectLabTechniqueArray, null, null, id);
		case "fund":

			ProjectFund[] projectFundArray = (ProjectFund[]) JsonUtil.JsonNodeToObject(requestPayload, "fund",
					ProjectFund[].class);
			return this.ObjectFieldAssignment(projectFundArray, null, null, id);
		default:
			return null;
		}
	}

	/**
	 * 
	 * @param AssociationName 关联表json节点名称
	 * @param type 
	 * @param id 主表id
	 * @return 关联表记录
	 */
	private List<Map<String, Object>> getAddAssociationTableConditionMap(String AssociationName, String type,
			Integer id) {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		switch (AssociationName) {
		case "member":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			conditionMap.put("subtype", "member");
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTMEMBER.getName(), conditionMap);
		case "chief_author":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			conditionMap.put("subtype", "chief_author");
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTMEMBER.getName(), conditionMap);
		case "deputy_author":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			conditionMap.put("subtype", "deputy_author");
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTMEMBER.getName(), conditionMap);
		case "inventor":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			conditionMap.put("subtype", "inventor");
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTMEMBER.getName(), conditionMap);
		case "unit":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTUNIT.getName(), conditionMap);
		case "keyword":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTKEYWORD.getName(), conditionMap);
		case "attachment":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTATTACHMENT.getName(), conditionMap);
		case "equipment":
			conditionMap.put("lab_id", id);
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTEQUIPMENT.getName(), conditionMap);
		case "technique":
			conditionMap.put("lab_id", id);
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTLABTECHNIQUE.getName(), conditionMap);
		case "fund":
			conditionMap.put("project_id", id);
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTFUND.getName(), conditionMap);
		case "project":
			conditionMap.put("reference_id", id);
			conditionMap.put("type", type);
			return fatherMapper.baseQueryByMap(TableNameEnum.PROJECTRELATIONREL.getName(), conditionMap);

		default:
			return null;
		}
	}
	
	private Map<String,Object> HandleDeletedAssociationTable(String AssociationName, String type,
			Integer id) throws Exception {
		Map<String ,Object> conditionMap = new HashMap<String,Object>();
		switch (AssociationName) {

		case "member":
			conditionMap.put("type", type);
			conditionMap.put("subtype","member");
			conditionMap.put("reference_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_member");
			return conditionMap;
		case "chief_author":
			conditionMap.put("type", type);
			conditionMap.put("subtype","chief_author");
			conditionMap.put("reference_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_member");
			return conditionMap;
		case "deputy_author":
			conditionMap.put("type", type);
			conditionMap.put("subtype","deputy_author");
			conditionMap.put("reference_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_member");
			return conditionMap;
		case "inventor":
			conditionMap.put("type", type);
			conditionMap.put("subtype","inventor");
			conditionMap.put("reference_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_member");
			return conditionMap;
		case "unit":
			conditionMap.put("type", type);
			conditionMap.put("reference_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_unit");
			return conditionMap;
		case "keyword":
			conditionMap.put("type", type);
			conditionMap.put("reference_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_keyword");
			return conditionMap;
		case "attachment":
			conditionMap.put("type", type);
			conditionMap.put("reference_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_attachment");
			return conditionMap;
		case "project":
			conditionMap.put("type", type);
			conditionMap.put("project_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project");
			return conditionMap;
		case "equipment":
			conditionMap.put("type", type);
			conditionMap.put("lab_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_equipment");
			return conditionMap;
		case "technique":
			conditionMap.put("lab_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_technique");
			return conditionMap;
		case "fund":
			conditionMap.put("project_id", id);
			conditionMap.put("deleted",false);
			conditionMap.put("tablename","project_fund");
			return conditionMap;
		default:
			return null;
		}
	}

	private Object[] ObjectFieldAssignment(Object[] objArray, String type, String subtype, Integer id) {
		if(null == objArray || objArray.length==0)
			return null;
		for (int i = 0; i < objArray.length; i++) {
			for (Field field : objArray[i].getClass().getDeclaredFields()) {
				field.setAccessible(true);
				try {
					if ("id".equals(field.getName())) {
						field.set(objArray[i], id);
					}
					if ("created_time".equals(field.getName())) {
						field.set(objArray[i], new Date());
					}
					if ("date".equals(field.getName())) {
						field.set(objArray[i], new Date());
					}
					if("lab_id".equals(field.getName()))
					{
						field.set(objArray[i], id);
					}
					if("project_id".equals(field.getName()))
					{
						field.set(objArray[i], id);
					}
					if("reference_id".equals(field.getName()))
					{
						field.set(objArray[i], id);
					}
					if("deleted".equals(field.getName()))
					{
						Object deletedflag = field.get(objArray[i]);
						if(null != deletedflag)
						{
							field.set(objArray[i], false);
						}
					}
					if ("type".equals(field.getName())) {
						if (null == type) {
							continue;
						} else {
							field.set(objArray[i], type);
						}
					}
					if ("subtype".equals(field.getName())) {
						if (null == subtype) {
							continue;
						} else {
							field.set(objArray[i], subtype);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return objArray;
	}

	private Object getId(Object obj) {
		Integer id = 0;
		try {
			Field field = obj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			id = Integer.parseInt(field.get(obj).toString());
			return id;
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 给实体类赋默认值
	 * @param object
	 * @return
	 */
	private Object handleObj(Object object) 
	{
		if(null == object)
			return null;
		for(Field field : object.getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			if("deleted".equals(field.getName()))
			{
				try {
					if(null == field.get(object))
					{
						field.set(object, false);
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if("created_time".equals(field.getName()))
			{
				try {
					if(null == field.get(object))
					{
						field.set(object, new Date());
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return object;
	}
}
