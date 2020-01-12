package com.hospital301.scientificmanagement.services.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;

import com.ccb.sm.entities.Menu;
import com.ccb.sm.entities.User;
import com.hospital301.scientificmanagement.Redis.Redis;
import com.hospital301.scientificmanagement.dao.login.Logindao;
import com.hospital301.scientificmanagement.dao.login.Menudao;
import com.hospital301.scientificmanagement.services.BaseServiceImpl;
import com.hospital301.scientificmanagement.services.login.LoginService;
import com.hospital301.scientificmanagement.util.passwdUtil;
import com.hospital301.scientificmanagement.util.TreeUtil;
import com.hospital301.scientificmanagement.util.Util;


@Service
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {
	private final Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	private Logindao logindao;
	@Autowired
	private Menudao menudao;
	
	@Resource
	private Redis redis;
	
//	@Autowired
//	private ValueOperations valueOperations;

	/**
	 * 通过用户名获取用户密码
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public  boolean VerifyPasswd(String username, String password,String UUID) throws Exception {
		// 数据库存储的加密后的密码
		Map conditionMap = new HashMap<String,String>();
		String dbpasswd = "";
		conditionMap.put("username",username);
		List<User> userlist = Util.ListmapToBean(queryByMap("user", conditionMap),User.class);
		if(userlist == null || userlist.size()==0)
		{
			return false;
		}
		User user = (User) userlist.get(0);
//		valueOperations.set("token:"+UUID.randomUUID().toString().trim(),user);
		redis.setStringType("token:"+UUID,user);
//		dbpasswd = logindao.getPasswdByUserId(userId);
		dbpasswd = user.getPassword();
		String[] array = dbpasswd.split("\\$");	
		if ("".equals(dbpasswd)) {
			return false;
		}
		if (!dbpasswd.equals(passwdUtil.encryptPasswd(password.trim(),array[1].toString().trim())))
			return false;
		return true;
	}

	/**
	 * 通过用户名获取用户所有信息
	 */
	public User GetUserByUserName(String UserName)
	{
		Map conditionMap = new HashMap<String,String>();
		conditionMap.put("username", UserName);
		List<User> userlist =  Util.ListmapToBean(logindao.baseQueryByMap("user", conditionMap),User.class);
//		user = logindao.getUserByuserId(UserName);
		if (userlist.size()==0) {
			logger.info("数据库获取用户user对象为空");
		}
		return userlist.get(0);

	}

	@Override
	/**
	 * 根据用户权限返回菜单的json字符串
	 */
	public List<Menu> QuerUserMenu(List<String> userPermission) 
	{
		List<Menu> listMenu = menudao.QueryMenuByUserPermission(userPermission);
		listMenu = TreeUtil.data(listMenu);
		return listMenu;
	}
	
 
}
