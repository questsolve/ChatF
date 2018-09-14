package com.chatf.chat.chatRoom;

public class chatRoomVO {
	private int chatServerNo;
	private String chatFlag;
	private String chatTitle;
	private String activeYn;
	public int getChatServerNo() {
		return chatServerNo;
	}
	public void setChatServerNo(int chatServerNo) {
		this.chatServerNo = chatServerNo;
	}
	public String getChatFlag() {
		return chatFlag;
	}
	public void setChatFlag(String chatFlag) {
		this.chatFlag = chatFlag;
	}
	public String getChatTitle() {
		return chatTitle;
	}
	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}
	public String getActiveYn() {
		return activeYn;
	}
	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}
	
}
