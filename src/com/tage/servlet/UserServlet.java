package com.tage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tage.bean.User;
import com.tage.dao.UserDAO;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 7045526109624065308L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		request.setCharacterEncoding("utf8");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("password");
		User user = UserDAO.findUser(username, userpwd);
		if (user != null) {
			request.getSession().setAttribute("userid", user.getUserid());
			request.getSession().setAttribute("organize", user.getOrganize());
//			request.getRequestDispatcher("/index?method=init").forward(request, response);
//			if (user.getRight()==1) {
//				response.sendRedirect("/application/manage.html");
//			}else{
//				response.sendRedirect("/application/index.html");
//			}
			response.sendRedirect("/application/index.html");
		} else {
			response.getWriter().write("登陆失败!密码或用户名错误!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
