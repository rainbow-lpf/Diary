package com.diary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	public static Connection getConnection() throws Exception {
		Class.forName(PropertiesUtil.getKey("jdbcName"));
	    Connection	conn = DriverManager.getConnection(PropertiesUtil.getKey("dbUrl"),PropertiesUtil.getKey("dbUserName") , PropertiesUtil.getKey("dbPassword"));
	    return conn;
	}
	
	public static void setClonse(Connection conn) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
	}
	
	public static void main(String args[]) {
		
		try {
			getConnection();
			System.out.println("链接数据库成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
