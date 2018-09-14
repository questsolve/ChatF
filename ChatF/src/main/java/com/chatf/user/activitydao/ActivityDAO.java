package com.chatf.user.activitydao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosmo.activity.ActivityVO;
import com.kosmo.member.DBManager;
import com.kosmo.member.MemberVO;

//DAO : Data Access Object
public class ActivityDAO {
	
	public ActivityVO adduser(ActivityVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("add into user_regdate, Act_no, from chatf_user where user_id=? and user_pw=?");
			pstmt.setInt(1, mvo.getAct_no());
	
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo.setUser_id(rs.getString("user_id"));
				mvo.setUser_name(rs.getString("user_name"));
				mvo.setUser_birthday(rs.getString("user_birthday"));
				mvo.setUser_email(rs.getString("user_email")); 
				mvo.setUser_pw(rs.getString("user_pw")); 
				mvo.setUser_image(rs.getString("user_image")); 
				mvo.setUser_regdate(rs.getString("user_regdate")); 
				mvo.setUser_roll(rs.getString("user_roll")); 
				mvo.setActive_yn(rs.getString("Active_yn")); 
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
			pstmt.setString(1, mvo.getUser_id());
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
				mvo.setUser_id(rs.getString("user_id"));
				mvo.setUser_name(rs.getString("user_name"));
				mvo.setUser_birthday(rs.getString("user_birthday"));
				mvo.setUser_email(rs.getString("user_email")); 
				mvo.setUser_pw(rs.getString("user_pw")); 
				mvo.setUser_image(rs.getString("user_image")); 
				mvo.setUser_regdate(rs.getString("user_regdate")); 
				mvo.setUser_roll(rs.getString("user_roll")); 
				mvo.setActive_yn(rs.getString("active_yn")); 
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
				mvo.setUser_id(rs.getString("user_id"));
				mvo.setUser_name(rs.getString("user_name"));
				mvo.setUser_birthday(rs.getString("user_birthday"));
				mvo.setUser_email(rs.getString("user_email")); 
				mvo.setUser_pw(rs.getString("user_pw")); 
				mvo.setUser_image(rs.getString("user_image")); 
				mvo.setUser_regdate(rs.getString("user_regdate")); 
				mvo.setUser_roll(rs.getString("user_roll")); 
				mvo.setActive_yn(rs.getString("Active_yn")); 
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
				mvo.setUser_id(rs.getString("user_id"));
				mvo.setUser_name(rs.getString("user_name"));
				mvo.setUser_birthday(rs.getString("user_birthday"));
				mvo.setUser_email(rs.getString("user_email")); 
				mvo.setUser_pw(rs.getString("user_pw")); 
				mvo.setUser_image(rs.getString("user_image")); 
				mvo.setUser_regdate(rs.getString("user_regdate")); 
				mvo.setUser_roll(rs.getString("user_roll")); 
				mvo.setActive_yn(rs.getString("Active_yn")); 
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
			pstmt.setString(1, mvo.getUser_id());
			pstmt.setString(2, mvo.getUser_pw());
			pstmt.setString(3, mvo.getUser_name());
			pstmt.setString(4, mvo.getUser_email());
			pstmt.setString(5, mvo.getUser_image());
			pstmt.setString(6, mvo.getUser_regdate());
			pstmt.setString(7, mvo.getUser_birthday());
			pstmt.setString(8, mvo.getUser_roll());
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
			pstmt.setString(1, mvo.getUser_id());
			pstmt.setString(2, mvo.getUser_pw());
			pstmt.setString(3, mvo.getUser_name());
			pstmt.setString(4, mvo.getUser_email());
			pstmt.setString(5, mvo.getUser_image());
			pstmt.setString(6, mvo.getUser_regdate());
			pstmt.setString(7, mvo.getUser_birthday());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
	}

	







}
