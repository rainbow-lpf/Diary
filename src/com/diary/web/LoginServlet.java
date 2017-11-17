package com.diary.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diary.dao.UserDao;
import com.diary.model.User;
import com.diary.util.DbUtil;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao=new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			String remberme=request.getParameter("remberme");
			HttpSession session=request.getSession();
			User user=new User(userName,password);
			User resultUser=userDao.Login(user,conn);
			if(resultUser==null) {
				request.setAttribute("user", user);
				request.setAttribute("error", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				if("rember-me".equals(remberme)) {
					remberMe(response,resultUser);
				}
				session.setAttribute("resultUser", resultUser);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtil.setClonse(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private  void  remberMe(HttpServletResponse response,User user) {
		Cookie cookie=new Cookie("user",user.getUserName()+"-"+user.getPassword());
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}


	
}
