package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dto.LoginDTO;

import common.JdbcTemplate;

public class LoginDaoImpl implements LoginDao {
	@Override
	public LoginDTO getLoginUser(String userid, String userpwd) {
		LoginDTO dto = null;

		try {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from member where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new LoginDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setUserpwd(rs.getString("userpwd"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return dto;
	}
}
