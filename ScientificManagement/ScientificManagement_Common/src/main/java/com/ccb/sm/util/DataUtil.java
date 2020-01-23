package com.ccb.sm.util;

import java.util.Date;

public class DataUtil 
{
	private static final String DataModle="%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
	
	
	/**
	 * 将日期转换为‘年月日  时分秒毫秒’格式的字符串
	 * @param date
	 * @return 格式 年月日  时分秒毫秒   （20191127 18:56:32:270）
	 */
	public static String  DateToString(Date date)
	{
		String dateString = String.format(DataModle, date);
		return dateString;
		
	}
}
