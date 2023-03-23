package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.dao.BookDaoImpl;
import com.book.dto.BookDTO;

@WebServlet("/listBook")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDao dao = new BookDaoImpl();
		List<BookDTO> list = dao.listBook();
		System.out.println(list);
		RequestDispatcher rq = req.getRequestDispatcher("/book/bookList.jsp");
		req.setAttribute("list", list);
		rq.forward(req, resp);
	}
}
