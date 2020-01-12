package com.hospital301.scientificmanagement.services.login;

import java.util.List;

import com.ccb.sm.entities.Menu;
import com.ccb.sm.entities.User;

public interface LoginService 
{
	public boolean VerifyPasswd(String userId, String password,String UUID) throws Exception;
	
	public User GetUserByUserName(String UserName);
	
	/**
	 * 根据用户权限返回用户可以访问的功能
	 * @return
	 */
	public List<Menu> QuerUserMenu(List<String> userPermission);
}
