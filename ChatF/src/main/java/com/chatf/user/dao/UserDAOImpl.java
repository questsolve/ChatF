package com.chatf.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.common.DBManager;
import com.chatf.common.Search;
import com.chatf.user.UserVO;


//DAO : Data Access Object
public class UserDAOImpl implements UserDAO{

	public int adduser(UserVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		
		DBManager db = new DBManager();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(" chatf_user( ");
		sql.append(" user_id,user_name,user_birthday,user_email");
		sql.append(",user_pw,user_image,user_regdate,user_roll,	active_yn");
		sql.append(")");
		sql.append(" VALUES(?,?,TO_DATE(?,'YYYY/MM/DD'),?,?,?,SYSDATE,'u','y')");
		
		int joinYN =0;
		
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, mvo.getUserId());
			pstmt.setString(2, mvo.getUserName());
			pstmt.setString(3, mvo.getUserBirthday());
			pstmt.setString(4, mvo.getUserEmail());
			pstmt.setString(5, mvo.getUserPw());
			pstmt.setString(6, mvo.getUserImage());
			joinYN = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return joinYN;
	}
	
	public int delete(String userId) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE");
		sql.append(" chatf_user");
		sql.append(" SET");
		sql.append(" active_yn = 'n'");
		sql.append(" WHERE");
		sql.append(" user_id =?");
		
		int res = 0;
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
	}


	
	public ArrayList<UserVO> listUser(Search search) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT * ");
		sb.append(" FROM (");
		sb.append(" SELECT ROWNUM AS row_no, inner.*");
		sb.append(" FROM (");
		sb.append(" SELECT");
		sb.append(" user_id, user_name, TO_CHAR(user_birthday,'YYYY/MM/DD') AS user_birthday, user_email,");  
		sb.append(" user_image, TO_CHAR(user_regdate,'YYYY/MM/DD') AS user_regdate, user_roll");
		sb.append(" FROM");
		sb.append(" chatf_user");
		sb.append(" WHERE active_yn = 'y'");
		sb.append(" ) inner");
		sb.append(" )");
		sb.append(" WHERE row_no BETWEEN ? AND ?");
		
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement(sb.toString()); 
			pstmt.setInt(1, search.getStartRowNum());
			pstmt.setInt(2, search.getEndRowNum());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO mvo = new UserVO();
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserName(rs.getString("user_name"));
				mvo.setUserBirthday(rs.getString("user_birthday"));
				mvo.setUserEmail(rs.getString("user_email")); 
				mvo.setUserImage(rs.getString("user_image")); 
				mvo.setUserRegdate(rs.getString("user_regdate")); 
				mvo.setUserRoll(rs.getString("user_roll")); 
				
				list.add(mvo); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}

	
	public ArrayList<UserVO> listUser(String userId,Search search) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT * ");
		sb.append(" FROM (");
		sb.append(" SELECT ROWNUM AS row_no, inner.*");
		sb.append(" FROM (");
		sb.append(" SELECT");
		sb.append(" user_id, user_name, TO_CHAR(user_birthday,'YYYY/MM/DD') AS user_birthday, user_email,");  
		sb.append(" user_image, TO_CHAR(user_regdate,'YYYY/MM/DD') AS user_regdate, user_roll");
		sb.append(" FROM");
		sb.append(" chatf_user");
		sb.append(" WHERE active_yn = 'y'");
		sb.append(" AND user_id LIKE ?");
		sb.append(" ) inner");
		sb.append(" )");
		sb.append(" WHERE row_no BETWEEN ? AND ?");
		
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, "%"+userId+"%");
			pstmt.setInt(2, search.getStartRowNum());
			pstmt.setInt(3, search.getEndRowNum());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO mvo = new UserVO();
				mvo.setUserId(rs.getString("user_id"));
				mvo.setUserName(rs.getString("user_name"));
				mvo.setUserBirthday(rs.getString("user_birthday"));
				mvo.setUserEmail(rs.getString("user_email")); 
				mvo.setUserImage(rs.getString("user_image")); 
				mvo.setUserRegdate(rs.getString("user_regdate")); 
				mvo.setUserRoll(rs.getString("user_roll")); 
				list.add(mvo); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}


	public UserVO readUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		
		UserVO mvo = new UserVO();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append(" user_id, user_name, TO_CHAR(user_birthday,'YYYY/MM/DD') AS user_birthday,user_email,");
		sql.append(" user_pw, user_image, TO_CHAR(user_regdate,'YYYY/MM/DD') AS user_regdate, user_roll");
		sql.append(" FROM");
		sql.append(" chatf_user");
		sql.append(" WHERE user_id = ?");
		
		
		
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
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
			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return mvo;
	}

	public int update(UserVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE");
		sql.append(" chatf_user");
		sql.append(" SET");
		sql.append(" user_pw = ?");
		
		if(mvo.getUserName() != null) {
			sql.append(" ,user_name = ?");
		}
		
		if(mvo.getUserEmail() != null) {
			sql.append(" ,user_email = ?");
		}
		
		if(mvo.getUserImage() != null) {
			sql.append(" ,user_image =?");
		}
		
		sql.append(" WHERE user_id = ?");
		int index = 1;
		
		int res = 0;
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(index++, mvo.getUserPw());
			
			if(mvo.getUserName() != null) {
				pstmt.setString(index++, mvo.getUserName());
			}
			
			if(mvo.getUserEmail() != null) {
				pstmt.setString(index++, mvo.getUserEmail());
			}
			
			if(mvo.getUserImage() != null) {
				pstmt.setString(index++, mvo.getUserImage());
			}
			pstmt.setString(index, mvo.getUserId());
			
			res = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
	}

	







}
