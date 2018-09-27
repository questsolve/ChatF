package com.chatf.chat.chatLog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.chat.chatLog.chatLogVO;
import com.chatf.common.DBManager;
public class chatLogDaoImpl implements chatLogDao {
	@Override
	public void readChatLog(int chatServerNo, String userId) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		ArrayList<chatLogVO> list = new ArrayList<chatLogVO>();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("select u.user_id, c.chat_text, c.chat_time, c.upload_file, c.upload_map_x, upload_map_y, u.user_image\r\n" + 
					"from chat_log c, chatf_user u\r\n" + 
					"where c.user_id=u.user_id and c.chat_server_no= ? and u.user_id = ?;"); 
			pstmt.setInt(1, chatServerNo);
			pstmt.setString(2, userId);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				chatLogVO mvo = new chatLogVO();
				mvo.setUserId(rs.getString("u.user_id"));
				mvo.setChatText(rs.getString("c.chat_text"));
				mvo.setChatTime(rs.getString("c.chat_time"));
				mvo.setUploadFile(rs.getString("c.upload_file"));
				mvo.setUploadMapX(rs.getString("c.upload_map_x"));
				mvo.setUploadMapY(rs.getString("c.upload_map_y"));
				mvo.setUserImage(rs.getString("u.user_image"));
				list.add(mvo); 
			//	System.out.println("chatlog read 성공");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		
	}
	
	@Override
	public int addChatLog(chatLogVO mvo) {
//		insert into chat_log(log_no, user_id, chat_server_no, chat_text, chat_time, upload_file, upload_map_x, upload_map_y) 
//		values(log_seq.nextval, ?,?,?, sysdate, NULL, NULL, NULL);
	
		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		int res = 0;
		try {

			conn = db.dbConn();
			pstmt = conn.prepareStatement("INSERT INTO chat_log (\r\n" + 
					"LOG_NO,\r\n" + 
					"USER_ID,\r\n" + 
					"CHAT_SERVER_NO,\r\n" + 
					"CHAT_TEXT,\r\n" + 
					"CHAT_TIME,\r\n" + 
					"UPLOAD_FILE,\r\n" + 
					"UPLOAD_MAP_X,\r\n" + 
					"UPLOAD_MAP_Y)\r\n" + 
					"VALUES (chat_log_seq.nextval,?,?,?,sysdate, null, null, null)");
			pstmt.setString(1, mvo.getUserId());
			pstmt.setInt(2, mvo.getChatServerNo());
			pstmt.setString(3, mvo.getChatText());
			
			res = pstmt.executeUpdate();

			System.out.println("chatLog 에"+ res +"건 add 완료");
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
		
	}
}
