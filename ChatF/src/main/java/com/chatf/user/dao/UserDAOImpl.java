package com.chatf.user.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.common.DBManager;
import com.chatf.user.UserVO;


//DAO : Data Access Object
public class UserDAOImpl {

	public UserVO adduser(UserVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("add into user_id, user_name, user_roll, user_image, user_birthday, user_pw, user_regdate, user_email, from chatf_user where user_id=? and user_pw=?");
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			pstmt.setString(3, mvo.getUserName());
			pstmt.setString(4, mvo.getUserEmail());
			pstmt.setString(5, mvo.getUserImage());
			pstmt.setString(6, mvo.getUserRegdate());
			pstmt.setString(7, mvo.getUserBirthday());
			pstmt.setString(8, mvo.getUserRoll());
			pstmt.setString(9, mvo.getActiveYn());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserName(rs.getString("user_name"));
				mvo.setUserBirthday(rs.getString("user_birthday"));
				mvo.setUserEmail(rs.getString("user_email")); 
				mvo.setUserPw(rs.getString("user_pw")); 
				mvo.setUserImage(rs.getString("user_image")); 
				mvo.setUserRegdate(rs.getString("user_regdate")); 
				mvo.setUserRoll(rs.getString("user_roll")); 
				mvo.setActiveYn(rs.getString("Active_yn")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return mvo;
	}
	
	public int delete(UserVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		int res = 0;
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("update chatf_user set active_yn=n where user_id=?");
			pstmt.setString(1, mvo.getUserId());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
	}


	
	public ArrayList<UserVO> read() {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("select * from chatf_user"); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO mvo = new UserVO();
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserName(rs.getString("user_name"));
				mvo.setUserBirthday(rs.getString("user_birthday"));
				mvo.setUserEmail(rs.getString("user_email")); 
				mvo.setUserPw(rs.getString("user_pw")); 
				mvo.setUserImage(rs.getString("user_image")); 
				mvo.setUserRegdate(rs.getString("user_regdate")); 
				mvo.setUserRoll(rs.getString("user_roll")); 
				mvo.setActiveYn(rs.getString("active_yn")); 
				list.add(mvo); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}


	public ArrayList<UserVO> read(String searchGubn, String searchStr) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement
									   //name  like '%무개%'
("select * from chatf_user where " + searchGubn +" like '%" + searchStr +"%'");
			//pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				UserVO mvo = new UserVO();
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserName(rs.getString("user_name"));
				mvo.setUserBirthday(rs.getString("user_birthday"));
				mvo.setUserEmail(rs.getString("user_email")); 
				mvo.setUserPw(rs.getString("user_pw")); 
				mvo.setUserImage(rs.getString("user_image")); 
				mvo.setUserRegdate(rs.getString("user_regdate")); 
				mvo.setUserRoll(rs.getString("user_roll")); 
				mvo.setActiveYn(rs.getString("Active_yn")); 
				list.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}


	public UserVO read(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		UserVO mvo = new UserVO();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("select * from chatf_user where user_id=?");
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserName(rs.getString("user_name"));
				mvo.setUserBirthday(rs.getString("user_birthday"));
				mvo.setUserEmail(rs.getString("user_email")); 
				mvo.setUserPw(rs.getString("user_pw")); 
				mvo.setUserImage(rs.getString("user_image")); 
				mvo.setUserRegdate(rs.getString("user_regdate")); 
				mvo.setUserRoll(rs.getString("user_roll")); 
				mvo.setActiveYn(rs.getString("Active_yn")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return mvo;
	}


	public int add(UserVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		int res = 0;
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("insert into chatf_user(user_id, user_pw, user_name, user_email, user_image, user_regdate, birthday, roll) values(member_seq.nextval,?,?,?,?,?,?,?,'u',sysdate)");
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			pstmt.setString(3, mvo.getUserName());
			pstmt.setString(4, mvo.getUserEmail());
			pstmt.setString(5, mvo.getUserImage());
			pstmt.setString(6, mvo.getUserRegdate());
			pstmt.setString(7, mvo.getUserBirthday());
			pstmt.setString(8, mvo.getUserRoll());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
	}


	public int update(UserVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		int res = 0;
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement
			("update chatf_user set user_name=?, user_birthday=?, user_pw=?, user_image =?, WHERE user_id = ?");
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserPw());
			pstmt.setString(3, mvo.getUserName());
			pstmt.setString(4, mvo.getUserEmail());
			pstmt.setString(5, mvo.getUserImage());
			pstmt.setString(6, mvo.getUserRegdate());
			pstmt.setString(7, mvo.getUserBirthday());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
	}

	







}
