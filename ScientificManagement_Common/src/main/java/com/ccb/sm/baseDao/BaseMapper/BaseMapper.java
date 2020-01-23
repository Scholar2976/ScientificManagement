/**
 * 查询条件有日期类型时，首先把日期类型格式化成字符串然后在放到map中 
 * 例如  日期为2019-12-09（Date类型）  "2019-12-09"
 */
package com.ccb.sm.baseDao.BaseMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ccb.sm.baseDao.Factory.BaseFactory;


public interface BaseMapper {

	/**
	 * 插入数据
	 * @param bean
	 * @return
	 */
	@InsertProvider(method = "insert",type=BaseFactory.class)
	public int baseInsert(@Param("entry")Object obj);
   
	/**
	 * 更新或者插入 
	 * @param bean
	 * @return
	 */
	@Options(useGeneratedKeys=true,keyColumn="id")
	@InsertProvider(method="saveOrUpdate",type=BaseFactory.class)
	public int baseSaveOrUpdate (Object obj);
	
	/**
	 * 批量更新
	 * @param cla
	 * @param list
	 * @return
	 */
	@InsertProvider(method = "batchInsert" , type =BaseFactory.class )
	public int baseBatchInsert(@Param("list")List list);
	
	
	/**
	 * 删除数据
	 * @param tableName 表名
	 * @param conditionMap 删除条件
	 * @return
	 */
	@DeleteProvider(method = "deleteByMap",type=BaseFactory.class)
	public int baseDeleteByMap(String tableName, Map<String, Object> conditionMap);
	
	/**
	 * 逻辑删除
	 * @param tableName
	 * @param conditionMap
	 * @return
	 */
	@DeleteProvider(method = "logicDeleteByMap",type=BaseFactory.class)
	public Integer baseLogicDeleteByMap(String tableName, Map<String,Object> conditionMap);
	
	
	/**
	 * 逻辑删除数据
	 * @param tableName
	 * @param id 
	 * @return
	 */
	@DeleteProvider(method = "logicDeleteById",type=BaseFactory.class)
	public int baseLogicDeleteById(String tableName,Integer id );


	/**
	 * 根据conditionMap中的查询条件返回对应实体对象
	 * @param bean  实体对象
	 * @param conditionMap 查询条件
	 * @return
	 */
	@SelectProvider(method = "queryByMap",type=BaseFactory.class)
	public List<Map<String,Object>> baseQueryByMap(String tableName ,Map<String,Object> conditionMap);

	
	@SelectProvider(method = "queryById",type=BaseFactory.class)
	public Map<String, Object> baseQueryById(String tableName ,Integer id);
	
	
	@SelectProvider(method = "queryByUserOrOrg",type=BaseFactory.class)
	public List<Map<String,Object>> baseQueryByUserOrOrg(String tableName ,Map<String,Object> conditionMap,Map<String, Object> map,String key);
	
	
	
	
    /**
     * 根据Id更新数据
     * @param bean
     * @return
     */
	@UpdateProvider(method = "updateById",type=BaseFactory.class)
	public int baseUpdateById(@Param("entry")Object obj);
	
	/**
	 * 根据条件更新数据
	 * @param bean
	 * @param conditionMap
	 * @return
	 */
	@UpdateProvider(method = "updateByMap",type=BaseFactory.class)
	public int baseUpdateByMap(Class clazz,Map<String,Object> conditionMap);
	
	
	@SelectProvider(method = "queryByPageAndTotal",type=BaseFactory.class)
	public List<List<Object>> queryByPageAndTotal(String tableName ,Map<String,Object> conditionMap);
	
	
	@SelectProvider(method = "validate",type=BaseFactory.class)
	public List<Map<String,Object>>  baseValidate(String tableName ,Map<String,Object> conditionMap);
	
	
	@SelectProvider(method = "total",type=BaseFactory.class)
	public Integer baseGetSelectTotal(String tableName ,Map<String,Object> conditionMap);
	
	/**
	 * 
	 * @param tableName
	 * @param conditionMap
	 * @param map
	 * @param key 值："byuser" ,"byorg"
	 * @return
	 */
	@SelectProvider(method = "totalByUserOrOrg",type=BaseFactory.class)
	public Integer baseGetSelectTotalByUserOrOrg(String tableName, Map<String,Object> conditionMap,Map<String ,Object> map , String key );
	
	/**
	 * 使用传入的sql语句来执行数据库查询操作
	 * @param sql 需要执行的sql语句
	 * @return
	 */
	@SelectProvider(method = "executeBySql",type=BaseFactory.class)
	public List<Map<String,Object>> baseQueryBySql(String sql);
	
	/**
	 * 使用传入的sql语句来执行数据库插入操作
	 * @param sql
	 * @return
	 */
	@SelectProvider(method = "executeBySql",type=BaseFactory.class)
	public List<Map<String,Object>> baseInsertBySql(String sql);
	
	/**
	 * 使用传入的sql语句来执行数据库更新操作
	 * @param sql
	 * @return
	 */
	@SelectProvider(method = "executeBySql",type=BaseFactory.class)
	public List<Map<String,Object>> baseUpdateBySql(String sql);
	
	/**
	 * 使用传入的sql语句来执行数据库删除操作
	 * @param sql
	 * @return
	 */
	@SelectProvider(method = "executeBySql",type=BaseFactory.class)
	public List<Map<String,Object>> baseDeleteBySql(String sql);
}
