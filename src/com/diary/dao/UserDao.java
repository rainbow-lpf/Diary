package com.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diary.model.User;
import com.diary.util.MD5Util;
import com.diary.util.PropertiesUtil;

public class UserDao {

	public User Login(User user,Connection conn) throws Exception {
		User resultUser=null;
			String sql="select * from t_user where userName=? and password=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,user.getUserName());
			ps.setString(2, MD5Util.EncoderPwdByMd5(user.getPassword()));
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				resultUser=new User();
				resultUser.setUserId(rs.getInt("userId"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setNickName(rs.getString("nickName"));
				resultUser.setImageName(PropertiesUtil.getKey("imageFile")+rs.getString("imageName"));
				resultUser.setMood(rs.getString("mood"));
			}
			return resultUser;
		}
}
