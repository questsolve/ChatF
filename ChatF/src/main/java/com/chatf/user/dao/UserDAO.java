package com.chatf.user.dao;

import java.util.ArrayList;

import com.chatf.common.Search;
import com.chatf.user.UserVO;

public interface UserDAO {
	public int adduser(UserVO mvo);
	public int delete(String userId);
	public ArrayList<UserVO> listUser(Search search);
	public ArrayList<UserVO> listUser(String userId,Search search);
	public UserVO readUser(String userId);
	public int update(UserVO mvo);

}
