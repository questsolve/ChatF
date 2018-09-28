package com.chatf.share.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chatf.common.DBManager;
import com.chatf.share.ShareVO;

public class ShareDAOImpl implements ShareDAO{

	@Override
	public int addShare(ShareVO vo) {
		Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        String sql = "insert into share (share_no,sender_id,receiver_id,review_no) values(share_seq.nextval?,?,?)"; 
        		 
        	
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, vo.getSenderId());
            pstmt.setString(2, vo.getReceiverId());
            pstmt.setInt(3, vo.getReviewNo());
			re=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		return re;
	}
	
	

}
