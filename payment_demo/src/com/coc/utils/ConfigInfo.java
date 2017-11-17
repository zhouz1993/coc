package com.coc.utils;

import java.util.Properties;

/**
 * 读取配置文件
 *
 */
public class ConfigInfo {
	
	private static Properties properties = new Properties();
	static {
		try {
			properties.load(ConfigInfo.class.getClassLoader().getResourceAsStream("merchantInfo.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取指定key的值
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return properties.getProperty(key).trim();
	}
	
	public static void main(String[] args) {
		System.out.println(ConfigInfo.getValue("queryRefundReqURL"));
	}
	
}






