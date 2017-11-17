package com.diary.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String getKey(String key) {
		Properties pro=new Properties();
		//读取文件流
		InputStream input=new PropertiesUtil().getClass().getResourceAsStream("/diary.properties");
		
		try {
			//加载配置文件
			pro.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String)pro.get(key);
	}
}
