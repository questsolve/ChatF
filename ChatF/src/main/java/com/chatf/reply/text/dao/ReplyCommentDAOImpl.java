package com.chatf.reply.text.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.common.DBManager;
import com.chatf.reply.text.ReplyCommentVO;
import com.chatf.reply.text.ReplyVO;

public class ReplyCommentDAOImpl implements ReplyCommentDAO{

	@Override
	public int addReplyCommnet(ReplyCommentVO vo) {
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        String sql = "insert into reply_comment(comment_no, user_id, reply_comment, regdate,active_yn) values(comment_no.nextval,?,?,sysdate,y) where reply_no=?"; 
        	
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, vo.getUserId());
            pstmt.setString(2, vo.getReplyComment());
            re=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		return re;
	}

	@Override
	public int updateReplyComment(ReplyCommentVO vo) {
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        
        String sql = "update reply set comment=?, regdate =sysdate where comment_no=? AND reply_no=? ;";
        
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCommentNo());
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
	public int deleteReplyComment(int replyCommNo) {

		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        
        String sql ="update  reply_ comment set active_yn=n wherecomment_no=?";
        
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, replyCommNo);
			re=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		
		
		return re;
	}

	@Override
	public ArrayList<ReplyCommentVO> listReplyComment(int replyNo) {
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
    	ArrayList<ReplyCommentVO> list = new ArrayList<ReplyCommentVO>();
		
		String sql = "select  user_id, reply_comment, regdate, comment_no from reply_comment where reply_no=? and active_yn=’y’";
			
		
		try {
			conn=db.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				ReplyCommentVO vo = new ReplyCommentVO();
				vo.setUserId(rs.getString("user_id"));
				vo.setReplyComment(rs.getString("reply_comment"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCommentNo(rs.getInt("Comment_no"));
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
