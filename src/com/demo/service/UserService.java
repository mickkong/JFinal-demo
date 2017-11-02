package com.demo.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import com.demo.common.model.User;
import sun.misc.BASE64Encoder;

public class UserService {

	private static final User dao = new User();

	/**
	 * 成功
	 */
	public static final String SUCCESS = "success";
	/**
	 * 密码错误
	 */
	public static final String PWDERROR = "密码错误！";
	/**
	 * 用户不存在
	 */
	public static final String NONEXIST = "用户不存在！";
	/**
	 * 用户已注册
	 */
	public static final String REGISTERED = "用户已注册！";
	/**
	 * 信息不匹配
	 */
	public static final String UNMISMATCH = "信息不匹配！";

	/**
	 * 异常
	 */
	public static final String EXCEPTION = "操作异常！";

	/**
	 * 利用MD5进行加密
	 * 
	 * @param str
	 * @return encoderStr
	 */
	private String EncoderByMd5(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			String encoderStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			return encoderStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return dao.findFirst("select * from user where username='" + username + "'");
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username, String password) {
		User user = findByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(EncoderByMd5(password))) {
				return SUCCESS;
			}
			return PWDERROR;
		}
		return NONEXIST;
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	public String register(User user) {
		if (findByUsername(user.getUsername()) != null) {
			return REGISTERED;
		}
		user.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setPassword(EncoderByMd5(user.getPassword()));
		if (user.save()) {
			return SUCCESS;
		} else {
			return EXCEPTION;
		}
	}

	/**
	 * 找回密码
	 * 
	 * @param user
	 * @return
	 */
	public String findPwd(User user) {
		User obj = findByUsername(user.getUsername());
		if (obj != null) {
			if (obj.getPhone().equals(user.getPhone()) && obj.getEmail().equals(user.getEmail())) {
				user.setPassword(EncoderByMd5(user.getPassword()));
				if(user.update()) {
					return SUCCESS;
				} else {
					return EXCEPTION;
				}
			}
			return UNMISMATCH;
		}
		return NONEXIST;
	}

}
