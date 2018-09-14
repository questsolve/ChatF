package com.chatf.chat.chatUserList.dao;

import com.chatf.chat.chatUserList.chatUserListVO;

public interface chatUserListDao {

	public void listChatUserList(int chatServerNo);
	public int addChatUserList(chatUserListVO mvo);
	public int deleteChatUserList(chatUserListVO mvo);
	 
}
