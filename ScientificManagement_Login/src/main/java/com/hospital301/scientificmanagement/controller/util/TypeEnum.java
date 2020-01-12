package com.hospital301.scientificmanagement.controller.util;

/**
 * @author 作者
 * @version 创建时间：2020年1月2日 上午10:28:59 类说明
 */
public enum TypeEnum {
	EQUIPMENT("equipment"), LAB("lab"), ACADEMY("academy"), COOPERATION("cooperation"), EXCHANGE("exchange"), PAPER(
			"paper"), PATENT("patent"), PROJECT("project"), REWARD("reward"), SOFTWARE("software"), WORK("work");

	private String name;

	private TypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
