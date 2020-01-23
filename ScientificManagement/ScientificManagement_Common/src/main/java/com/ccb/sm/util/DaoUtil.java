package com.ccb.sm.util;


import java.util.regex.Matcher;

import java.util.regex.Pattern;
/*

* �շ����ƺ��»������Ƶ��໥ת��

*/

public class DaoUtil {

	

	private static Pattern linePattern = Pattern.compile("_(\\w)");
	private static Pattern humpPattern = Pattern.compile("[A-Z]");


	public static String lineToHump(String str) {

		str = str.toLowerCase();

		Matcher matcher = linePattern.matcher(str);

		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {

			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());

		}

		matcher.appendTail(sb);

		return sb.toString();

	}

	

	public static String humpToLine(String str) {
		str = str.substring(0,1).toLowerCase()+str.substring(1);
		Matcher matcher = humpPattern.matcher(str);

		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {

			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());

		}

		matcher.appendTail(sb);

		return sb.toString();

	}

 

}
