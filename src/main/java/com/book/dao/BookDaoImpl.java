package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.dto.BookDTO;

import common.JdbcTemplate;

public class BookDaoImpl implements BookDao {

	@Override
	public int insertBook(BookDTO dto) {
		int result = 0;

		try {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			String sql = "insert into bookshop(isbn,title, author,company,price) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIsbn());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getAuthor());
			pstmt.setString(4, dto.getCompany());
			pstmt.setInt(5, dto.getPrice());

			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<BookDTO> listBook() {
		List<BookDTO> list = new ArrayList<>();

		try {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from bookshop";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setAuthor(rs.getString("author"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setCompany(rs.getString("company"));
				dto.setPrice(Integer.valueOf(rs.getString("price")));
				dto.setTitle(rs.getString("title"));

				list.add(dto);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateBook(BookDTO dto) {
		int result = 0;

		try {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			String sql = "update bookshop set isbn=?,title=?, author=?,company=?,price=? where isbn = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIsbn());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getAuthor());
			pstmt.setString(4, dto.getCompany());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setString(6, dto.getIsbn());

			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteBook(BookDTO dto) {
		int result = 0;

		try {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			String sql = "delete from bookshop where isbn = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getIsbn());

			result = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

}
