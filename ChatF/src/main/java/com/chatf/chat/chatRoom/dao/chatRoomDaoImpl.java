package com.chatf.chat.chatRoom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.chat.chatRoom.chatRoomVO;
import com.chatf.common.DBManager;

public class chatRoomDaoImpl implements chatRoomDao {

	@Override
	public void readChatRoom(String chatFlag, String activeYn) {
//		select chat_title, chat_server_no from chat_room where chat_flag=? and active_yn = ? order by ?
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs  = null;
		DBManager db = new DBManager();
		ArrayList<chatRoomVO> list = new ArrayList<chatRoomVO>();
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement("select chat_title, chat_server_no from chat_room where chat_flag=? and active_yn=?"); 
			pstmt.setString(1, chatFlag);
			pstmt.setString(2, activeYn);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				chatRoomVO mvo = new chatRoomVO();
				mvo.setChatTitle(rs.getString("chat_title"));
				mvo.setChatServerNo(rs.getInt("chat_server_no"));
				
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
	public int addChatRoom(chatRoomVO mvo) {
		
		//INSERT INTO chat_room (chat_server_no,chat_flag, chat_title, active_yn ) VALUES (chat_server_seq.nextval,?, ?, ?);

		Connection conn = null;
		PreparedStatement pstmt =null;
		DBManager db = new DBManager();
		int res = 0;
		try {

			conn = db.dbConn();
			pstmt = conn.prepareStatement("INSERT INTO chat_room(chat_server_no, chat_flag, chat_title, active_yn ) VALUES (chat_server_seq.nextval, ?, ?, ?);");
			pstmt.setString(1, mvo.getChatFlag());
			pstmt.setString(2, mvo.getChatTitle());
			pstmt.setString(3, mvo.getActiveYn());
			res = pstmt.executeUpdate();

			//System.out.println("chatRoom 에"+ res +"건 add 완료");
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return res;
		
	}

	
	

	
}
