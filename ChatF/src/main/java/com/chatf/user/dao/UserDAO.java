package com.chatf.user.dao;

import com.chatf.user.UserVO;

public interface UserDAO {
	
	public int adduser(UserVO mvo);
	public UserVO read(String user_id);
	public int update(UserVO mvo);
	public int delete(UserVO mvo);
}
