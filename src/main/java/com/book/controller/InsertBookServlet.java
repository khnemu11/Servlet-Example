package com.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.dao.BookDaoImpl;
import com.book.dto.BookDTO;

@WebServlet("/insertBook")
public class InsertBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		BookDTO dto = new BookDTO();
		dto.setIsbn(req.getParameter("isbn"));
		dto.setTitle(req.getParameter("title"));
		dto.setAuthor(req.getParameter("author"));
		dto.setCompany(req.getParameter("company"));
		dto.setPrice(Integer.valueOf(req.getParameter("price")));

		BookDao dao = new BookDaoImpl();
		int result = dao.insertBook(dto);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/listBook");
		} else {
			System.out.println("Error");
		}
	}
}
