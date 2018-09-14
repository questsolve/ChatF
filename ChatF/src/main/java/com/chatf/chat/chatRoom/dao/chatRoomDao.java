package com.chatf.chat.chatRoom.dao;

import com.chatf.chat.chatLog.chatLogVO;
import com.chatf.chat.chatRoom.chatRoomVO;

public interface chatRoomDao {
	
	public void readChatRoom(String chatFlag, String activeYn);
	public int addChatRoom(chatRoomVO mvo);
	
	
}
