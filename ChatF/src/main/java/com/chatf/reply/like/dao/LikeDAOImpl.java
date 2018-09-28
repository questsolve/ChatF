package com.chatf.reply.like.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String sql = "insert into like(like_no,user_id,review_no,like_flag) values(reivew_like_seq.nextval,?,?,ok)";
		
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
	public void readLike(int reviewNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		
		String sql = "select count(column) from like where review_no =?";
		
		try {
			conn = db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
	}
	
	
	public int update(LikeVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
	
		int re=0;
		String sql = "update like set like_flag=no where review_no=?";
		
		try {
			conn = db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getReviewNo());
			re=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally {
			db.dbClose(conn, pstmt);
		}
		return re;
	}

}
