package com.chatf.reply.like.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.common.DBManager;
import com.chatf.reply.like.LikeVO;

public class LikeDAOImpl implements LikeDAO {

	@Override
	public int addLike(LikeVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
	
		int re=0;
		String sql = "insert into review_like(like_no,user_id,review_no,like_flag) values(reivew_like_seq.nextval,?,?,'ok')";
		
		try {
			conn = db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setInt(2, vo.getReviewNo());
			re=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			db.dbClose(conn, pstmt);
		}
		return re;
	}
	
	

	@Override
	public int readLike(int reviewNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		int re=0;
		ArrayList list = new ArrayList();
		String sql = "select count(*) as countlike from review_like where review_no=?";
		
		try {
			conn = db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				 re = rs.getInt("countlike");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		return re;
	
	}
	
	
	public int update(int reviewNO , String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
	
		int re=0;
		String sql = "update review_like set like_flag='no' where review_no=? and user_id=?";
		
		try {
			conn = db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNO);
			pstmt.setString(2, userId);
			re=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			db.dbClose(conn, pstmt);
		}
		return re;
	}

}
