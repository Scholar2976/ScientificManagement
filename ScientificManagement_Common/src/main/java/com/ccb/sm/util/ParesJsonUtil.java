/**
 * 使用jackson解析json数据,并返回Map对象
 * 
 */
package com.ccb.sm.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParesJsonUtil {

	/**
	 * 存储解析后的json数据
	 */
	private static Map map = new HashMap();
	
	/**
	 * 解析json字符串为对象
	 * @param obj
	 * @param jsonStr
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Object jsonToObj(Object obj, String jsonStr)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return obj = mapper.readValue(jsonStr, obj.getClass());
	}
	
	

	/**
	 * 获取解析json后的map对象
	 * 
	 * @param json
	 * @return
	 */
	public static Map JsonTOMap(String json) {
		if (null == json || "".equals(json)) {
			map.put("error", "json数据为空 ");
			return map;
		}
		try {
			ParseJsonData(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 解析json数据
	 * 
	 * @param jsonstr
	 * @throws Exception
	 */
	private static void ParseJsonData(String jsonstr) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(jsonstr);
		isJsonValueNode(jsonNode);
	}

	/**
	 * 通过遍历判断是否是值节点
	 * 
	 * @param node
	 */
	private static void isJsonValueNode(JsonNode node) {
		if (node.isObject()) {
			Iterator<Entry<String, JsonNode>> it = node.fields();
			while (it.hasNext()) {
				Entry<String, JsonNode> entry = it.next();
				getJsonNodeValue(entry);
			}
		}
	}

	/**
	 * 将json节点的数据以键--值对的形式放到map中
	 * 
	 * @param entry
	 */
	
	@SuppressWarnings("unchecked")
	private static void getJsonNodeValue(Entry<String, JsonNode> entry) {
		if (entry.getValue().isValueNode()) {
			map.put(entry.getKey().toString(), entry.getValue().asText());
		}
		isJsonValueNode(entry.getValue());
	}

}
