package com.hospital301.scientificmanagement.dao.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ccb.sm.entities.Menu;
import com.hospital301.scientificmanagement.dao.BaseMapper.FatherMapper;

@Mapper
public interface Menudao extends FatherMapper
{
	/**
	 * 根据用户权限(userpermission)查询用户可以访问的菜单 
	 */
	public List<Menu> QueryMenuByUserPermission(@Param("userPermission")List<String> userPermission);
}
