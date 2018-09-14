package com.chatf.reply.text.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.common.DBManager;
import com.chatf.reply.like.LikeVO;
import com.chatf.reply.text.ReplyVO;

public class ReplyDAOImpl implements ReplyDAO{

	@Override
	//댓글 작성
	public int addReply(ReplyVO vo) {
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        String sql = "insert into reply(reply_no,user_id,review_no,reply,regdate,active_yn)values(reply_seq.nextval,?,?,?,sysdate,y)";
        
        
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setInt(2, vo.getReviewNo());
			pstmt.setString(3, vo.getReply());
			re=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		return re;
	}

	@Override
	//댓글 수정
	public int updateReply(ReplyVO vo) {
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        
        String sql = "update reply set reply=? where reply_no=?";
        
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getReply());
			pstmt.setInt(2, vo.getReplyNo());
			re=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		
		return re;
	}

	@Override
	
	//댓글 삭제
	public int deleteReply(int replyNo) {
	
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        
        String sql ="update reply set activity_yn=n where reply_no=?";
        
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		
		
		return re;
	}
	
	//댓글 불러오기 
	
	public ArrayList<ReplyVO> listReply(int reviewNo){
		
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
		
		String sql = "select  user_id, reply, regdate, reply_no from reply where review_no=? and active_yn=y";
		
		try {
			conn=db.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				ReplyVO vo = new ReplyVO();
				vo.setUserId(rs.getString("user_id"));
				vo.setReply(rs.getString("reply"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReplyNo(rs.getInt("reply_no"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return list;
		
	}

}
