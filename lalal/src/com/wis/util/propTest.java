package com.wis.util;

public class propTest {

	public static void main(String[] args) {
		 String url = StringUtils.readConfigFile("/jdbc.properties","url");;
		 String driver = StringUtils.readConfigFile("/jdbc.properties","driver");
		 String username = StringUtils.readConfigFile("/jdbc.properties","username");
		 String password = StringUtils.readConfigFile("/jdbc.properties","password");
		 
		 System.out.println(url);
		 System.out.println(driver);
		 System.out.println(username);
		 System.out.println(password);
		 
		 String[] sss = StringUtils.getObjectProperties("USerName");
		 for(String s : sss){
			 System.out.println(s);
			 
		 }
		 
	}

}
