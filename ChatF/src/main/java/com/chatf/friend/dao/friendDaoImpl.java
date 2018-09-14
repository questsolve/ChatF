package com.chatf.friend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.chat.chatRoom.chatRoomVO;
import com.chatf.common.DBManager;
import com.chatf.friend.friendVO;

public class friendDaoImpl implements friendDao {

	@Override
	public int addFriend(friendVO vo) {

		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		int res = 0;
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("insert into friend(friend_no,reciever_id,sender_id,friend_flag) values(friend_no_seq.nextval,?,?,?);");
			pstmt.setString(1, vo.getReceiverId());
			pstmt.setString(2, vo.getSenderId());
			pstmt.setString(3, vo.getFriendFlag());
			res = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
	
	}

	
	
	@Override
	public void readFriend(friendVO vo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		ArrayList<friendVO> list = new ArrayList<friendVO>();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("select receiver_id, sender_id from friend where receiver_id=? or sender_id=? and friend_flag=?;"); 
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserId());
			pstmt.setString(3, vo.getFriendFlag());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				friendVO mvo = new friendVO();
				mvo.setReceiverId(rs.getString("receiver_id"));
				mvo.setSenderId(rs.getString("sender_id"));
				
				list.add(mvo); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}		
	}

	@Override
	public int updateFriend(friendVO vo) {
		//update friend set friend_flag=1 where friend_no=?;
			Connection conn = null;
			PreparedStatement pstmt =null;
			DBManager db = new DBManager();
			int res = 0;
			try {

				conn = db.dbConn();
				pstmt = conn.prepareStatement("update friend set friend_flag=? where friend_no=?;");
				pstmt.setString(1, vo.getFriendFlag());
				pstmt.setInt(2, vo.getFriendNo());
				res = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.dbClose(conn, pstmt);
			}
			return res;
			}

}
