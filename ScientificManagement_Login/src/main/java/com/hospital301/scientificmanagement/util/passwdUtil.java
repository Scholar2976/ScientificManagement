package com.hospital301.scientificmanagement.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class passwdUtil {

	/**
	 * 数据加密方法
	 * @param passwd 生成最终密码结构  ：  加密算法名称$盐$密码
	 * @param salt  如果是注册和修改密码则传入null
	 * @return
	 */
	public static String encryptPasswd(String passwd, String salt) {
		String encryptpasswd = "";
		
		try {
			if (null == salt || "".equals(salt)) {
				// 加密数据库密码使用的盐
				SecureRandom random = new SecureRandom();
				salt = MD5.getEncryptedPwd(String.valueOf(random.nextInt()));
			}
			encryptpasswd = SecureHashAlgorithm.shaEncode(salt + passwd);
//			encryptpasswd=  DigestUtils.sha1Hex(salt+passwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// sha1算法加密失败
			e.printStackTrace();
		}

		return "sha1$" + salt + "$" + encryptpasswd;
	}
	
	
	
	public static void main(String[] args)
	{
//		for(int i =0;i<100;i++)
		System.out.println(passwdUtil.encryptPasswd("f379eaf3c831b04de153469d1bec345e", "90268BBA4DCCA9529C75EC8099F93FE602E1FE71D1BDD37B72676A23"));
		
	}
}
