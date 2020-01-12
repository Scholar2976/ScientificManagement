package com.hospital301.scientificmanagement.util;

/**
 * Report枚举类
 * 
 * @author ypy
 * @date 2019年12月23日
 * @version 1.0
 */
public enum Report {
	REWARD("奖励级别分布", "reward", 0), PAPER("论文类型分布", "paper", 1), WORK("著作类分布", "work", 2), PATENT("专利类别分布", "patent",
			3), SOFTWARE("软件开发方式分布", "software", 4), ACADEMY("学术任职级别", "academy",
					5), PROJECT("项目级别", "project", 6), EXCHANGE("学术活动", "exchange", 7), LAB("实验室", "lab", 8),
	USER("个人信息统计","user",9);
	private String name;
	private String alias;
	private int index;

	// 构造方法
	private Report(String name, String alias, int index) {
		this.name = name;
		this.alias = alias;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getIndex() {
		return index;
	}

	// public static Report getEnum(int i)
	// {
	// return Report.class.getEnumConstants()[i];
	// }

	public static Report getReportEnumByIndex(int index) {
		for (Report report : Report.values()) {
			if (report.getIndex() == index) {
				return report;
			}
		}
		return null;
	}

//	public static void main(String[] args) {
//		for(int i =0;i<5;i++)
//		{
//			System.out.println(Report.getReportEnumByIndex(i));
//		}
//		
//	}
}
