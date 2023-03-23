package com.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.LoginDao;
import com.book.dao.LoginDaoImpl;
import com.book.dto.LoginDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String userid = req.getParameter("userid");
		String userpwd = req.getParameter("userpwd");

		LoginDao dao = new LoginDaoImpl();

		LoginDTO dto = dao.getLoginUser(userid, userpwd);

		if (dto == null) {
			resp.sendRedirect(req.getContextPath() + "/login/fail.jsp");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("userid", dto.getUserid());
			resp.sendRedirect(req.getContextPath() + "/login/loginOK.jsp");
		}
	}
}
