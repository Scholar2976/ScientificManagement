package com.ccb.sm.baseDao.Factory;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;

import com.ccb.sm.util.DataUtil;
import com.ccb.sm.util.DaoUtil;

public class BaseFactory<T>
{

//	@Options
	/**
	 * 插入数据
	 * @param bean
	 * @return
	 */
	public String insert(Map map) {
		
		StringBuffer sb = new StringBuffer();
		String string = "";
		String string2 = "";
		Object object = map.get("entry");
		sb.append("INSERT INTO "+this.getTableName(object.getClass())+"  (");
		List<Field> fields = getFields(object.getClass());
		for(Field field : fields)
		{
			string+=" `"+field.getName()+"` ,";
			string2+="#{param1."+field.getName()+"},";
		}
		sb.append(string.substring(0, string.length()-1).toString()+") value ");
		sb.append("("+string2.substring(0,string2.length()-1)+")");
//		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * 根据删除条件删除数据
	 * @param tableName
	 * @param conditionMap
	 * @return
	 */
	public String deleteByMap(String tableName, Map<String,Object> conditionMap)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from "+tableName+" t where 1=1 ");
		buffer.append(this.getWhereSql(conditionMap, "param2"));
		return buffer.toString();
		
	}
	
	public String logicDeleteByMap(String tableName, Map<String,Object> conditionMap) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("update "+tableName+" t set deleted = 1 ,deleted_time='"+DataUtil.DateToString(new Date())+"' ");
		buffer.append("where 1=1 ");
		buffer.append(getWhereSql(conditionMap, "param2"));
		return  buffer.toString();
	}
		
	public String logicDeleteById(String tableName,Integer id) {
		if(null == id || id.equals(""))
			return "false";
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("update "+tableName+" t set deleted = 1 ,deleted_time='"+DataUtil.DateToString(new Date())+"' ");
		buffer.append("where id = "+id);
		return  buffer.toString();
	}
	
	/**
	 * 从数据库获取符合条件的
	 * @param bean
	 * @param conditionMap
	 * @return
	 */
	public String queryByMap(String tableName ,Map<String,Object> conditionMap) {
		StringBuffer buffer = new StringBuffer();
		StringBuffer pageBuffer = new StringBuffer();
		buffer.append("select * from "+tableName+" t where 1=1 ");
		buffer.append(this.getWhereSql(conditionMap, "param2"));
		buffer.append(this.getLimitSql(conditionMap, "param2"));
		return buffer.toString();
		
	}	
		
	public String queryByUserOrOrg(String tableName ,Map<String,Object> conditionMap,Map<String,Object> map,String key) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t.* from "+tableName +" t ,project_member m where 1=1 ");		
		buffer.append(this.getWhereSql(conditionMap, "param2"));
		buffer.append(this.getWhereSqlByUserOrOrg(map, "param3", key));
		buffer.append(this.getWhereSql(conditionMap, "param2"));
		buffer.append(this.getGroupBy("m.reference_id"));
		return buffer.toString();
	}
	

	/**
	 * 根据Id查询数据
	 */
	public String queryById(String tableName ,int id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from "+tableName +" where id = "+id);
		return buffer.toString();
	}

	/**
	 * 根据Id更新数据
	 * @param bean
	 * @return
	 */
	public String updateById(Map map) {
		StringBuffer stringBuffer = new StringBuffer();
		String string = "";
		Object object = map.get("entry");
		Class clazz = object.getClass();
		List<Field> fields = getFields(clazz);
		stringBuffer.append("update "+this.getTableName(clazz)+" t set ");
		
		for(Field field : fields)
		{
			if("id".equals(field.getName()))
				continue;
			string+=" `"+field.getName()+"` =#{entry."+field.getName()+"},";
		}
		stringBuffer.append(string.substring(0, string.length()-1)+" where `id`= #{entry.id}");
		return stringBuffer.toString();
	}

	/**
	 * 
	 * @param bean
	 * @param conditionMap
	 * @return
	 */
	public String updateByMap(Class clazz,Map<String,Object> conditionMap ) {
		StringBuffer buffer  = new StringBuffer();
		SQL sql = new SQL();
		sql.UPDATE(this.getTableName(clazz));
		List<Field> fields = getFields(clazz);
		for (Field field : fields) {
			field.setAccessible(true);
			String column = field.getName();
			if (column.equals("id")) {
				continue;
			}
//			sql.SET(DaoUtil.humpToLine(column) + "=" + String.format("#{" + column + ",jdbcType=VARCHAR}"));
			sql.SET(column + "=" + String.format("#{param2." + column + "} "));
		}
		buffer.append(sql.toString());
		buffer.append(" where 1=1 ");
		for(Entry<String, Object> entry:conditionMap.entrySet())
		{
//			buffer.append("and "+ entry.getKey()+"='"+entry.getValue()+"' ");
			buffer.append(" and "+ entry.getKey()+"=#{param2."+entry.getKey()+"} ");
		}
		return buffer.toString();
	}
	
	
	public String queryByPageAndTotal(String tableName , Map<String,Object> conditionMap )
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select SQL_CALC_FOUND_ROWS * from "+tableName+ " where 1=1 ");
		for(Entry<String , Object> entry : conditionMap.entrySet())
		{	
			if(entry.getKey().startsWith("page"))
				continue;
//			buffer.append( "and "+entry.getKey()+"= '"+String.valueOf(entry.getValue())+"' ");
			buffer.append( "and "+entry.getKey()+"= #{param2."+entry.getKey()+"}");
		}
//		buffer.append("limit "+ String.valueOf(conditionMap.get("pageStart"))+", "+String.valueOf(conditionMap.get("pageEnd")));
		buffer.append("limit #{param2.pageStart},#{param2.pageEnd} ;");
		buffer.append("SELECT FOUND_ROWS() AS COUNT;");
		return buffer.toString();
		
	}
	

	
	/**
	 * 插入或者更新
	 * @param bean
	 * @return
	 */
	public String saveOrUpdate(Object obj) {
		Map<String, String> map = new HashMap<String, String>();
		StringBuffer buffer = new StringBuffer();
		StringBuffer updateBufer = new StringBuffer();
		StringBuffer insertBuffer = new StringBuffer();
		StringBuffer insertValueBuffer = new StringBuffer();
		
		String tablename = this.getTableName(obj.getClass());
		List<Field> fields = getFields(obj.getClass());
		buffer.append("insert into " + tablename + "(");
		for(Field field : fields)
		{
			try {
				if(null == field.get(obj))
				{
					continue;
				}
				insertBuffer.append("`"+field.getName()+"`,");
				insertValueBuffer.append("#{"+field.getName()+"},");
				updateBufer.append("`"+field.getName()+"` = #{"+field.getName()+"},");
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		buffer.append(insertBuffer.substring(0, insertBuffer.length()-1).toString()+") values ");
		buffer.append("("+insertValueBuffer.substring(0, insertValueBuffer.length()-1).toString()+")");
		buffer.append(" ON DUPLICATE KEY UPDATE ");
		buffer.append(updateBufer.substring(0,updateBufer.length()-1).toString());

		return buffer.toString();
	}
	
	/**
	 * 批量更新
	 * @param map
	 * @return
	 */
	public String batchInsert(Map map) {
		StringBuffer buffer = new StringBuffer();
		StringBuffer insert = new StringBuffer();
		StringBuffer update = new StringBuffer();
		String str = new String();
		List list = (List) map.get("list");
		Object object = list.get(0);
		Class clazz = object.getClass();
		buffer.append("INSERT INTO "+this.getTableName(clazz)+" (");
		List<Field> fields = getFields(clazz);
		for(Field field : fields)
		{
			if("id".equals(field.getName()))
				continue;
			insert.append(" `"+field.getName()+"` ,");
			str+="#'{'list[{0}]."+field.getName()+"},";
			update.append("`"+field.getName()+"`= VALUES(`"+field.getName()+"`)," );
		}
		buffer.append(insert.substring(0, insert.length()-1).toString()+") values");

		int length = list.size();
		MessageFormat messageFormat  =  new MessageFormat("("+str.substring(0,str.length()-1)+")");
//		MessageFormat mf = new MessageFormat(
//				"(#'{'list[{0}].d_id},#'{'list[{0}].dec},#'{'list[{0}].type},#'{'list[{0}].date})");
		for (int i = 0; i < length; i++) {
			buffer.append(messageFormat.format(new Object[] { i }));
			if (i < length - 1) {
				buffer.append(",");
			}
		}
		buffer.append(" ON DUPLICATE KEY UPDATE " + update.substring(0,(update.toString().length()-1)).toString());
		System.out.println(buffer.toString());
		return buffer.toString();

	}
	
	public String validate (String tableName ,Map<String,Object> conditionMap) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from "+tableName +" where 1=1");
		for(Entry<String, Object> entry : conditionMap.entrySet())
		{
			if("id".equals(entry.getKey()))
			{
//				buffer.append(" and "+entry.getKey()+" != '" +entry.getValue().toString()+"'") ;
				buffer.append(" and "+entry.getKey()+" != #{param2." +entry.getKey()+"}") ;
				continue;
			}
		
//			buffer.append(" and "+entry.getKey()+" = '" +entry.getValue().toString()+"'") ;
			buffer.append(" and "+entry.getKey()+" = #{param2." +entry.getKey()+"}") ;
		}
		return buffer.toString();
	}
	
	/**
	 * 返回查询到的总条数
	 * @param tableName
	 * @param conditionMap
	 * @return
	 */
	public String total(String tableName, Map<String,Object> conditionMap)
	{
		String sqlstr = "select count(1) from "+tableName+" t where 1=1 ";
		StringBuffer buffer = new StringBuffer();
		buffer.append(sqlstr);
		buffer.append(this.getWhereSql(conditionMap, "param2"));
		return buffer.toString();
	}
	
	public String totalByUserOrOrg(String tableName, Map<String,Object> conditionMap,Map<String ,Object> map , String key )
	{
		String sqlstr = "select count(1) from ( select count(1) from "+tableName+" t ,project_member m where 1=1 ";
		StringBuffer buffer = new StringBuffer();
		buffer.append(sqlstr);
		buffer.append(this.getWhereSql(conditionMap, "param2"));
		buffer.append(this.getWhereSqlByUserOrOrg(map, "param3", key));
		buffer.append(this.getGroupBy("m.reference_id"));
		buffer.append(") temp");
		return buffer.toString();
	}
	
	
	
	public String executeBySql(String sql)
	{
		return sql;
	}
	
	
	/**
	 * 返回对象中的所有字段
	 * @param clazz
	 * @return
	 */
	private List<Field> getFields(Class clazz) {
		List<Field> fieldList = new ArrayList<>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) 
		{
			field.setAccessible(true);
			//判断实体类中的字段是否时list类型，如果是则忽略此字段
			if(field.getType() == List.class )
				continue;
			fieldList.add(field);
		}
		return fieldList;
	}	
	
	/**
	 * 获取表名
	 * @param clazz
	 * @return
	 */
	private String getTableName(Class clazz)
	{
		String entryname = clazz.getSimpleName();
		String tablename = DaoUtil.humpToLine(entryname);
		return tablename;
	}
	
	/**
	 * 获取sql语句中where语句条件部分
	 * @param conditionMap
	 * @param paramAlias
	 * @return
	 */
	private String getWhereSql(Map<String,Object> conditionMap,String paramAlias)
	{
		StringBuffer buffer = new StringBuffer();
		if(null == conditionMap || conditionMap.size()==0)
			return buffer.append("").toString();
//		if(!conditionMap.containsKey("deleted"))
//		{
//			buffer.append("and t.deleted = false");
//		}
		for(String key : conditionMap.keySet())
		{
			if(key.startsWith("page"))
			{
				continue;
			}
			if(key.endsWith("_like"))
			{
				buffer.append(" and t."+key.replace("_like", "")+" like CONCAT('%',#{"+paramAlias+"." +key+"},'%')") ;
				continue;
			}
			buffer.append(" and t."+key+" = #{"+paramAlias+"." +key+"}") ;
		}
		return buffer.toString();
	}
	
	private String getWhereSqlByUserOrOrg(Map<String,Object> conditionMap,String paramAlias,String key)
	{
		switch (key) {
		case "byuser":
			return this.getWhereSqlByUser(conditionMap, paramAlias);
		case "byorg":
			return this.getWhereSqlByOrg(conditionMap, paramAlias);
		default:
			return null;
		}
	}
	
	private String getWhereSqlByUser(Map<String,Object> conditionMap,String paramAlias)
	{
		StringBuffer buffer = new StringBuffer();
		if(null == conditionMap || conditionMap.size()==0)
			return buffer.append(" and m.reference_id=t.id ").toString();
		if(conditionMap.containsKey("username"))
		{
			buffer.append(" and m.username=#{"+paramAlias+".username} ");
		}
		if(conditionMap.containsKey("type"))
		{
			buffer.append(" and m.type=#{"+paramAlias+".type} ");
		}
		if(conditionMap.containsKey("type"))
		{
			buffer.append(" and m.reference_id=t.id ");
		}
		return buffer.toString();
	}
	private String getWhereSqlByOrg(Map<String,Object> conditionMap,String paramAlias)
	{
		StringBuffer buffer = new StringBuffer();
		if(null == conditionMap || conditionMap.size()==0)
			return buffer.append(" and m.reference_id=t.id ").toString();
		if(conditionMap.containsKey("username"))
		{
			buffer.append(" and m.organization_id=#{"+paramAlias+".organization_id} ");
		}
		if(conditionMap.containsKey("type"))
		{
			buffer.append(" and m.type=#{"+paramAlias+".type} ");
		}
		if(conditionMap.containsKey("type"))
		{
			buffer.append(" and m.reference_id=t.id ");
		}
		return buffer.toString();
	}
		
	
	/**
	 * 获取sql语句limit部分
	 * @param conditionMap
	 * @param paramAlias
	 * @return
	 */
	private String getLimitSql(Map<String,Object> conditionMap,String paramAlias)
	{
		StringBuffer buffer = new StringBuffer();
		if(null == conditionMap || conditionMap.size()==0)
			return buffer.append("").toString();
		if(conditionMap.containsKey("pageStart") && conditionMap.containsKey("pageEnd"))
		{
			buffer.append(" limit #{"+paramAlias+".pageStart},#{"+paramAlias+".pageEnd}");
		}
		return buffer.toString();
	}
	
	
	/**
	 * 对实体对象赋默认值
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
	
	private String getGroupBy(String ... list )
	{
		StringBuffer groupBy = new StringBuffer();
		groupBy.append(" group by ");
		for(String column : list)
		{
			groupBy.append(column+",");
		}
		return groupBy.substring(0, groupBy.toString().length()-1).toString();
	}
}
