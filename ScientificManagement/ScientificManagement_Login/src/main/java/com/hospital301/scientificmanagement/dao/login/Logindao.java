package com.hospital301.scientificmanagement.dao.login;

import org.apache.ibatis.annotations.Mapper;

import com.ccb.sm.entities.User;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;


@Mapper
public interface Logindao extends FatherMapper
{
	/**
	 * 通过用户ID获取用户密码
	 * @param userId
	 * @return
	 */
	public String getPasswdByUserId(String userId);
	
	/**
	 * 通过用户名获取用户所有信息
	 * @param userId
	 * @return
	 */
	public User getUserByuserId(String userId);

}
