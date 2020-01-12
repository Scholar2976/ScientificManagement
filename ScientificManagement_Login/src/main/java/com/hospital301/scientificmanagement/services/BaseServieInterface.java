package com.hospital301.scientificmanagement.services;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;

public interface BaseServieInterface 
{
	/**
	 * 按分页查询数据库表中数据并返回所有查询到的条数
	 * @param map 查询条件
	 * @return 
	 */
	
	public Map QueryTableInfoByPage(String tableName,Map<String,Object> map);
	
	/**
	 * 查询数据库表中数据
	 * @param map 查询条件
	 * @return 
	 */
	
	public List QueryTableInfo(String tableName,Map<String,Object> map);

	
	/**
	 * 插入
	 * @param obj 需要插入数据的实体对象
	 * @return
	 */
	public Object insert(Object obj);
	
	/**
	 * 批量插入
	 * @param list 需要插入的实体对象列表
	 * @return
	 */
	public Object batchInsert(List list);
	
	/**
	 * 逻辑删除
	 * @param map
	 * @return
	 */
	public Integer logicDelete(String tableName,List<String> arrayList,String type, Integer id ) throws Exception;
	
	/**
	 * 物理删除
	 * @param tableName
	 * @param conditionMap
	 * @return
	 */
	public int deleteByMap(String tableName, Map<String, Object> conditionMap);
	/**
	 * 
	 * @param tableName
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> queryByMap(String tableName ,Map<String,Object> conditionMap);
	
	public Map<String,Object> queryByUser(String tableName, Map<String, Object> conditionMap,Map<String, Object> map);
	
	public Map<String,Object> queryByOrg(String tableName, Map<String, Object> conditionMap,Map<String, Object> map); 
	
	public Map<String,Object> queryById(String tableName ,Integer id);
	
	/**
	 * 验证数据
	 * @param tableName
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String,Object>> validate(String tableName,Map<String,Object> conditionMap );
	
	/**
	 * 更新或者插入
	 * @param object
	 * @return
	 */
	public Object baseSaveOrUpdate(Object object) throws Exception;
	
	/**
	 * 更新数据
	 * @param clazz
	 * @param conditionMap
	 * @return
	 */
	public Object updateByMap(Class clazz, Map<String,Object> conditionMap);
	
	/**
	 * 处理前台的jsons数据中需要插入多表的情况
	 * @param requestPayload 前台请求报文
	 * @param clazz
	 * @param arrayList json数据中的需要插入数据库的节点是数组时将节点名称添加到此变量中
	 * @return
	 * @throws Exception
	 */
	public Object add(String requestPayload,Class clazz,List<String> arrayList,String type) throws Exception ;
	
	/**
	 * 查询主表和关联表信息
	 * @param tableName 主表名称
	 * @param conditionMap 主表查询条件
	 * @param list 关联表json节点名称
	 * @param type 
	 * @return Json字符串
	 */
	public Object get(String tableName, Map<String,Object> conditionMap,List<String> list,String type) throws Exception;

}
