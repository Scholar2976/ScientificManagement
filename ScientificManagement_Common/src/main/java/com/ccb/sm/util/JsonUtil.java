/**
 * json处理工具类型
 */
package com.ccb.sm.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.glass.ui.TouchInputSupport;

import ch.qos.logback.core.util.DatePatternToRegexUtil;

import com.fasterxml.jackson.annotation.JsonInclude;

public class JsonUtil {
	/**
	 * 将json字符串转换成对象
	 * 
	 * @param jsonStr
	 * @param obj
	 * @return
	 */
	public static Object JsonTOObject(String jsonStr, Class clazz) {
		ObjectMapper mapper = getMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		Object returnobj = null;
		try {
			returnobj = mapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnobj;
	}

	/**
	 * 将对象转换成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String getJsonResult(Object obj) {
		String str = "";
		ObjectMapper mapper = getMapper();
		try {
			str = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(str);
		return str;
	}

	/**
	 * 获取json节点的值 (如果节点的值为数组则，则传入的class类型为数字类型 ： Class[].class ) 并将节点的值转换成指定对象
	 * 
	 * @param jsonStr
	 * @param nodeName
	 * @return Object 转换的对象
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	public static Object JsonNodeToObject(String jsonStr, String nodeName, Class clazz)
			throws JsonProcessingException, IOException {
		ObjectMapper mapper = getMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		JsonNode jsonNode = mapper.readTree(jsonStr);
		if ("keyword".equals(nodeName)) {
			JsonNode resultValue = jsonNode.findValue(nodeName);
			if (null == resultValue)
				return null;
			if (resultValue.isArray()) {
				List<String> keyword = new ArrayList<String>();
				for (JsonNode objNode : resultValue) {
					keyword.add(objNode.asText());
//					System.out.println(objNode.asText());
					return keyword;
				}
			}
			return null;
		}
		JsonNode resultValue = jsonNode.findValue(nodeName);
		if (null == resultValue)
			return null;
		Object object = JsonTOObject(resultValue.toString(), clazz);
		return object;
	}

	/**
	 * 移除Json串中的节点后，将剩下的json串转换成对象
	 * 
	 * @param jsonstr
	 * @param removeNodeName
	 * @return 返回生成的指定对象
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	public static Object getObject(String jsonstr, List<String> removeNodeName, Class clazz)
			throws JsonProcessingException, IOException {
		ObjectMapper mapper = getMapper();
		JsonNode jsonNode = mapper.readTree(jsonstr);
		ObjectNode objectNode = (ObjectNode) jsonNode;
		for (String string : removeNodeName) {
			objectNode.remove(string);
		}
		if (null == objectNode)
			return null;
		Object object = JsonTOObject(objectNode.toString(), clazz);
		return object;
	}

	/**
	 * 在json字符串中添加节点，如果是在根节点添加新节点，则fatherNode赋值为null,
	 * 如果不是在根节点添加，则fatherNode赋值为新添加节点的父节点
	 * 
	 * @param srcjsonStr
	 *            不支持数组格式
	 * @param obj
	 *            支持 List， Map, Object
	 * @param fatherNode
	 * @param NewNodeName
	 * @param isArray
	 *            添加的节点是否是数组结构
	 * @return
	 * @throws Exception
	 */
	public static String addJsonNode(String srcjsonStr, Object object, String fatherNode, String newNodeName)
			throws Exception {
		ObjectMapper mapper = getMapper();
		JsonNode jsonNode = mapper.readTree(srcjsonStr);
		if (null != fatherNode && fatherNode.equals("")) {
			jsonNode = jsonNode.findValue(fatherNode);
		}
		ObjectNode objectNode = (ObjectNode) jsonNode;
		objectNode.putPOJO(newNodeName, object);
		return mapper.writeValueAsString(objectNode);
	}
	// public static String getChildNode(String srjsonStr,String path) throws
	// Exception
	// {
	// ObjectMapper mapper = new ObjectMapper();
	// JsonNode jsonNode = mapper.readTree(srjsonStr);
	// JsonNode resultValue = jsonNode.findValue(path);
	// String childStr = mapper.writeValueAsString(resultValue);
	// return childStr;
	// }

	/**
	 * 将对象转换成json
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String objectToJson(Object obj) throws Exception {
		ObjectMapper mapper = getMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		return jsonStr;
	}

	private static ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
		return mapper;
	}

	public static void main(String[] args) throws Exception {
		List list = new ArrayList<>();
		Map map = new HashMap<String, Object>();
		map.put("name", "zhagsan");
		map.put("age", "123");
		Map map1 = new HashMap<String, Object>();
		map1.put("name", "zhagsan");
		map1.put("age", "123");
		list.add(map);
		list.add(map1);

		String[] array = new String[] { "123", "2344" };
		map.put("keyword", array);
		String string = getJsonResult(map);
		System.out.println(string);
		JsonNodeToObject(string, "keyword", null);
		A a = new JsonUtil().new A();
		a.setMusic("1");
		a.setMusicname("过火");
		A a2 = new JsonUtil().new A();
		a2.setMusic("2");
		a2.setMusicname("千年等一回");
		List list2 = new ArrayList();
		list2.add(a);
		list2.add(a2);
		String objstring = getJsonResult(a);
		// System.out.println(objstring);
		// System.out.println(map.getClass().getTypeName());
		System.out.println(addJsonNode(string, list, null, "Music"));
	}

	class A {
		private String Music;
		private String Musicname;

		public String getMusic() {
			return Music;
		}

		public void setMusic(String music) {
			Music = music;
		}

		public String getMusicname() {
			return Musicname;
		}

		public void setMusicname(String musicname) {
			Musicname = musicname;
		}

	}

}
