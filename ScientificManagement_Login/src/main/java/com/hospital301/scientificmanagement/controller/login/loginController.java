package com.hospital301.scientificmanagement.controller.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.maven.shared.artifact.filter.StatisticsReportingArtifactFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccb.sm.entities.Menu;
import com.ccb.sm.entities.User;
import com.ccb.sm.response.ErrorResponseCommInfo;
import com.ccb.sm.response.SuccessResponseCommInfo;
import com.ccb.sm.util.ParesJsonUtil;
import com.hospital301.scientificmanagement.Redis.Redis;
import com.hospital301.scientificmanagement.controller.BaseController.BaseController;
import com.hospital301.scientificmanagement.menu.UserMenu;
import com.hospital301.scientificmanagement.services.login.LoginService;

@RestController
public class loginController extends BaseController
{
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private Redis redis;

	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * 验证用户登录信息
	 * 
	 * @param txnBodyCom
	 *            前台登录相关信息json字符串
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object userlogin(@RequestBody String requestPayload) throws Exception {
		Map map = ParesJsonUtil.JsonTOMap(requestPayload);
		String password = map.get("password").toString();
		String username = map.get("loginno").toString();
		boolean flag = false;
		if(null == password && null == username && "" == password && "" == username)
		{
			return "用户名或密码输入为空";
		}
		String tokenuuid =UUID.randomUUID().toString().trim().replace("-", "");
		flag = loginservice.VerifyPasswd(username,password,tokenuuid);
		if (flag) 
		{
			SuccessResponseCommInfo sResponseCommInfo= new SuccessResponseCommInfo();
			sResponseCommInfo.setToken(tokenuuid);
			return sResponseCommInfo;
		}
		ErrorResponseCommInfo errorResponseCommInfo = new ErrorResponseCommInfo();
		errorResponseCommInfo.setErrorDescription("用户名或者密码错误");
		return errorResponseCommInfo;
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Object userLogout(@RequestHeader("C-Dynamic-Password-Foruser")String tokenid ,@RequestBody String requestPayload) 
	{
		redis.deleteKey("token:"+tokenid);
		return "用户退出登录成功";
	}

	/**
	 * 返回用户信息json报文
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/getUserInfo", method = RequestMethod.POST)
	public Object returnUserInfo(@RequestHeader(value="C-Dynamic-Password-Foruser") String tokenId ,@RequestBody String requestPayload) 
	{
		
		User user1 = (User) httpServletRequest.getAttribute("user");
		List list  = new ArrayList();
		User user = null;
		String username ="";
		Map map = ParesJsonUtil.JsonTOMap(requestPayload);
		
		if(map.containsKey("loginno"))
		{
			username = map.get("loginno").toString().trim();
			user = loginservice.GetUserByUserName(username);
		}else
		{
			user = (User) redis.getUserInfo("token:"+tokenId);
		}
		list.add("user");
		List menulist = loginservice.QuerUserMenu(list);
		return getMenuMessObj(menulist);
	}

	/**
	 * 获取菜单返回报文结构
	 * @param menulist 
	 * @return
	 */
	private UserMenu getMenuMessObj(List<Menu> menulist)
	{
		List perlist = new ArrayList();
		perlist.add("superuser");
		perlist.add("user");
		UserMenu usermenu = new UserMenu();
		usermenu.setImage("ssdfs");
		usermenu.setLoginNo("admin");
		usermenu.setMenuTree(menulist);
		usermenu.setStaffid(6);
		usermenu.setStaffName("admin");
		usermenu.setPermission(perlist);
		return usermenu;
	}
}
