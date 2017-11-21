package com.coc.utils;

import java.util.UUID;

import org.junit.Test;

/**
 * 生成随机字符串工具类
 * @author Administrator
 *
 */
public class UUIDUtils {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	@Test
	public void test1(){
		System.out.println(getUUID());
	}
}
