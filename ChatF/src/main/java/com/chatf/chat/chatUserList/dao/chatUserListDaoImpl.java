package com.chatf.chat.chatUserList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.chat.chatUserList.chatUserListVO;
import com.chatf.common.DBManager;

public class chatUserListDaoImpl implements chatUserListDao {

	@Override
	public void listChatUserList(int chatServerNo) {
	//	select chat_server_no, user_id
	//	from chat_user_list
	//	where chat_server_no = ?;
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		ArrayList<chatUserListVO> list = new ArrayList<chatUserListVO>();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("select chat_server_no, user_id\r\n" + 
					"from chat_user_list\r\n" + 
					"where chat_server_no = ?;\r\n" + 
					""); 
			pstmt.setInt(1, chatServerNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				chatUserListVO mvo = new chatUserListVO();
				mvo.setChatServerNo(rs.getInt("chat_server_no"));
				mvo.setUserId(rs.getString("user_id"));
				
				list.add(mvo); 
			//	System.out.println("chatRoom read 성공");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		
	}

	@Override
	public int addChatUserList(chatUserListVO mvo) {
		
//	INSERT INTO chat_user_list (list_no, chat_server_no,user_id) VALUES (chat_list_seq, chat_server_no, ?);
		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		int res = 0;
		try {

			conn = db.dbConn();
			pstmt = conn.prepareStatement("INSERT INTO chat_user_list (list_no, chat_server_no, user_id) VALUES (chat_list_seq, ?, ?);");
			pstmt.setInt(1, mvo.getChatServerNo());
			pstmt.setString(2, mvo.getUserId());
			res = pstmt.executeUpdate();
			
			//System.out.println("chatUserList 에"+ res +"건 add 완료");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
		
	}
	@Override
	public int deleteChatUserList(chatUserListVO mvo) {
	//	delete from chat_user_list WHERE chat_server_no = ? and user_id = ?;
		
			Connection conn = null;
			PreparedStatement pstmt =null;
			DBManager db = new DBManager();
			int res = 0;
			try {
				conn = db.dbConn();
				pstmt = conn.prepareStatement("delete from chat_user_list WHERE chat_server_no = ? and user_id =?;");
				pstmt.setInt(1, mvo.getChatServerNo());
				pstmt.setString(2, mvo.getUserId());
				res = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.dbClose(conn, pstmt);
			}
			return res;
		
		
	}

	
	
	
}
