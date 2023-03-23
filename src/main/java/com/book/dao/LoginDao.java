package com.book.dao;

import com.book.dto.LoginDTO;

public interface LoginDao{
	public LoginDTO getLoginUser(String userid, String userpwd);
}
