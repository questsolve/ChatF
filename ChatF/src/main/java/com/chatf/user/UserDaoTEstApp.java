package com.chatf.user;

import java.util.List;

import com.chatf.common.Search;
import com.chatf.user.dao.UserDAO;
import com.chatf.user.dao.UserDAOImpl;

import oracle.net.aso.s;

public class UserDaoTEstApp {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		UserVO vo = new UserVO();
		
		vo.setUserBirthday("1988/04/28");
		vo.setUserId("testADDUser");
		vo.setUserPw("0000");
		vo.setUserEmail("qwerty@abc.com");
		vo.setUserImage("a/b/c");
		vo.setUserName("hiyo");
		
		int res = 0; 
//		res = userDAO.adduser(vo);
//		System.out.println(res);
		
		vo = userDAO.readUser("testADDUser");
		System.out.println(vo);

		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(10);
		
		System.out.println(search.getStartRowNum());
		System.out.println(search.getEndRowNum());
		List<UserVO> list = userDAO.listUser(search);
		System.out.println(list.size());
		List<UserVO> userlist = userDAO.listUser("est",search);
		System.out.println(userlist.size());
		
		res = userDAO.update(vo);
		System.out.println(res);
		
		res = userDAO.delete("testADDUser");
		System.out.println(res);
		
	}

}
