package com.hospital301.scientificmanagement.controller.BaseController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.ccb.sm.entities.User;
import com.ccb.sm.response.ResponsePage;
import com.hospital301.scientificmanagement.services.BaseServieInterface;

@Controller
public class BaseController 
{
	@Autowired
	@Qualifier(value="BaseServiceImpl")
	private BaseServieInterface  baseServieInterface;

	/**
	 * 
	 * @param service 需要调用的Service
	 * @param conditionMap 数据库查询条件
	 * @return
	 */
	public Object baseGetList(String tableName,Map<String,Object> conditionMap)
	{
		Map ResultMap = baseServieInterface.QueryTableInfoByPage(tableName,conditionMap);
		Map countmap = new HashMap();
		countmap.put("totalRec", ResultMap.get("total"));
		ResponsePage rspage = new ResponsePage();
		rspage.setList(ResultMap.get("page"));
		rspage.setTxnCommCom(countmap);
		return rspage;
	}
	
	public Object baseGetListByUser(String tableName,Map<String,Object> conditionMap,Map<String, Object> map)
	{
		Map ResultMap = baseServieInterface.queryByUser(tableName, conditionMap, map);
		Map countmap = new HashMap();
		countmap.put("totalRec", ResultMap.get("total"));
		ResponsePage rspage = new ResponsePage();
		rspage.setList(ResultMap.get("page"));
		rspage.setTxnCommCom(countmap);
		return rspage;
	}
	
	public Object baseGetListByOrg(String tableName,Map<String,Object> conditionMap,Map<String, Object> map)
	{
		Map ResultMap = baseServieInterface.queryByOrg(tableName, conditionMap, map);
		Map countmap = new HashMap();
		countmap.put("totalRec", ResultMap.get("total"));
		ResponsePage rspage = new ResponsePage();
		rspage.setList(ResultMap.get("page"));
		rspage.setTxnCommCom(countmap);
		return rspage;
	}
	
	/**
	 * 插入通用方法
	 * @param service 需要调用的Service
	 * @param txnBodyCom 接受的报文体
	 * @param clazz 数据库中插入的实体类
	 * @return
	 */
	public Object baseAdd(Object object) throws Exception
	{
		Object result =  baseServieInterface.insert(object);
		return result;
			
		
	}
	/**
	 * 批量插入通用方法
	 * @param service 需要调用的Service
	 * @param txnBodyCom 接受的报文体
	 * @param clazz 数据库中插入的实体类
	 * @return
	 */
	public Object baseBatchAdd(BaseServieInterface service,List list) throws Exception
	{
		setService(service);
		Object result = baseServieInterface.batchInsert(list);
//		Object result =  baseServieInterface.batchInsert(objEntity);
		return null;
			
		
	}
	
	/**
	 * 逻辑删除通用方法
	 * @param service 需要调用的Service
	 * @param conditionMap 删除条件
	 * @return
	 * @throws Exception 
	 */
	public Object basedelete(String tableName,List<String> arrayList,String type, Integer id ) throws Exception
	{
		Integer deleteCount= baseServieInterface.logicDelete(tableName,arrayList,type, id );
		if(deleteCount>0)
		{
			return "";
		}
		return "数据不存在";
		
	}
	
	public Object baseDeletedByMap(String tableName, Map<String,Object> conditionMap)throws Exception
	{
		return baseServieInterface.deleteByMap(tableName, conditionMap);
	}

	/**
	 * 跟新或者插入
	 * @param service
	 * @param object
	 * @return
	 */
	public Object baseSaveOrUpdate(String username,Object object) throws Exception
	{
		Field field = object.getClass().getDeclaredField("id");
		field.setAccessible(true);
		if(null == field.get(object))
		{
			FormtObject(object,"creator",username);
			FormtObject(object,"created_time",new Date());
		}else
		{
			FormtObject(object,"modifier",username);
			FormtObject(object,"modified_time",new Date());
		}
		return baseServieInterface.baseSaveOrUpdate(object);
	}
	
	
	
	
	
	public String  baseValidate(String tableName,Map<String,Object> conditionMap)
	{
		List<Map<String,Object>> list = baseServieInterface.validate(tableName, conditionMap);
		if(list.size()>0)
		{
			return "数据已存在";
		}
		return "";
	}
	/**
	 * 更新
	 * @param service
	 * @param clazz
	 * @param conditionMap
	 * @return
	 */
	public Object updateByMap(Object service ,Class clazz, Map<String,Object> conditionMap)
	{
		setService(service);
		return baseServieInterface.updateByMap(clazz, conditionMap);
	}
	
	public List<Map<String, Object>>  baseGet(String tableName,Map conditionMap)
	{
		return baseServieInterface.queryByMap(tableName, conditionMap);
	}
	
	
	public Object requestAdd(String requestPayload,Class clazz,List<String> arrayList,String type,User user) throws Exception
	{
		return this.baseServieInterface.add(requestPayload, clazz,arrayList,type,user);
	}
	
	/**
	 * 查询主表和关联表信息
	 * @param tableName 主表名称
	 * @param conditionMap 主表查询条件
	 * @param list 关联表json节点名称
	 * @param type 
	 * @return Json字符串
	 */
	public Object requestGet(String tableName,Map<String,Object> conditionMap,List<String> list,String type) throws Exception
	{
		return this.baseServieInterface.get(tableName, conditionMap, list, type);
	}
	
	public Object baseQueryById (String tableName, Integer id)
	{
		return this.baseServieInterface.queryById(tableName, id);
	}
	
	public Object baseSearch(String tableName,Map<String,Object> conditionMap)
	{
		Map<String,Map<String,Object>> resultmap = new HashMap<String,Map<String,Object>>();
		conditionMap.put("deleted", false);
		conditionMap.put("pageStart", 0);
		conditionMap.put("pageEnd", 50);
		List<Map<String,Object>> daolist =this.baseGet(tableName,conditionMap);
		if(daolist.size()>0)
		{
			for(Map map : daolist)
			{
				Map<String,Object> map1 = new HashMap<String, Object>();
				map1.put("label", map.get("name"));
				map1.put("value", map.get("id"));
				map1.put("location", map.get("location"));
				map1.put("name", map.get("name"));
				resultmap.put("list", map1);
			}
			return resultmap;
		}
		
		
		return null;
	}
	
	public Object QueryTableInfo(String tableName,Map<String,Object> map)
	{
		return this.baseServieInterface.QueryTableInfo(tableName, map);
	}
	
	
	private void setService(Object service)
	{
		if(service != null )
		{
			this.baseServieInterface = (BaseServieInterface) service;
		}
	}
	
	private Object FormtObject(Object obj,String fieldName,Object fieldValue) throws Exception
	{
		Field creator = obj.getClass().getDeclaredField(fieldName);
		creator.setAccessible(true);
		if(null == creator.get(obj))
		{
			creator.set(obj, fieldValue);
		}
		return obj;
	}
	
}
	