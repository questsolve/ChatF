package com.chatf.chat.chatLog.dao;

import com.chatf.chat.chatLog.chatLogVO;

public interface chatLogDao {

	public void readChatLog(int chatServerNo, String userId);
	public int addChatLog(chatLogVO mvo);
	
	
}
