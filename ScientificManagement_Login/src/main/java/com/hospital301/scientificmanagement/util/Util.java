package com.hospital301.scientificmanagement.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ccb.sm.util.ParesJsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class Util 
{
	/**
	 * 将map 转换成     T 类型对象
	 * @param map
	 * @param t
	 * @return
	 */
	  public static <T> T mapToBean1(Map<String, Object> map, T t) {
	        if(map == null || t == null) {
	            return null;
	        }

	        try {
	            BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
	            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

	            for(PropertyDescriptor pd : pds) {
	                String key = pd.getName();
	                if(map.containsKey(key)) {
	                    Object value = map.get(key);
	                    Method setter = pd.getWriteMethod();
	                    setter.invoke(t, value);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return t;
	    }
	  
	  public static Object mapToBean(Map<String, Object> map, Class clazz) {
	        if(map == null || clazz == null) {
	            return null;
	        }
	        try {
	        	Object object = clazz.newInstance();
	        	Field[] fields = clazz.getDeclaredFields();
	        	for(Field field : fields)
	        	{
	        		field.setAccessible(true);
	        		if(map.containsKey(field.getName()))
	        		{
	        			field.set(object, map.get(field.getName()));
	        		}
	        	}
	        	return object;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	  /**
	   * 将List<Map<String, Object>>类型的list转换成List<T>类型list
	   * @param list
	   * @param t
	   * @return
	   */
	  public static  List ListmapToBean(List<Map<String, Object>> list, Class clazz) {
	        if(list.size() == 0) {
	            return null;
	        }
	        List BeanList = new ArrayList();
	        try {
	            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
	            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
	            for(Map map : list)
	            {
	            	Object object = clazz.newInstance();
		            for(PropertyDescriptor pd : pds) {
		                String key = pd.getName();
	
		                if(map.containsKey(key)) {
		                    Object value = map.get(key);
		                    Method setter = pd.getWriteMethod();
		                    setter.invoke(object, value);
		                }
		            }
		            BeanList.add(object);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return BeanList;
	    }

	  
	  /**
		 * 判断从前台接受的数据是不是null,如果不是空，返回需要的数据
		 * @param object
		 * @param isReturnObject
		 * @param clazz
		 * @return
		 * @throws JsonParseException
		 * @throws JsonMappingException
		 * @throws IOException
		 */
	public static Object isNull(Object object ,boolean isReturnObject,Class clazz) throws JsonParseException, JsonMappingException, IOException
	{
		if(null != object)
		{
			if(isReturnObject)
			{
				return ParesJsonUtil.jsonToObj(clazz, object.toString());
			}
			return ParesJsonUtil.JsonTOMap(object.toString());
		}
		return null;
	}

	/**
	 * 将Object数组类型转换成list
	 * @param objs
	 * @return
	 */
	public static  List asList(Object[] objs)
	{
		List  list = new ArrayList();
		for(Object object :objs)
		{
			list.add(object);
		}
		return list;
	}
}
