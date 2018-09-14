package com.chatf.chat.chatLog;

public class chatLogVO {
	private int logNo;
	private String userId;
	private int chatServerNo;
	private String chatText;
	private String chatTime;
	private String userImage;
	private String uploadFile;
	private String uploadMapX;
	private String uploadMapY;
	public int getLogNo() {
		return logNo;
	}
	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getChatServerNo() {
		return chatServerNo;
	}
	public void setChatServerNo(int chatServerNo) {
		this.chatServerNo = chatServerNo;
	}
	public String getChatText() {
		return chatText;
	}
	public void setChatText(String chatText) {
		this.chatText = chatText;
	}
	public String getChatTime() {
		return chatTime;
	}
	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadMapX() {
		return uploadMapX;
	}
	public void setUploadMapX(String uploadMapX) {
		this.uploadMapX = uploadMapX;
	}
	public String getUploadMapY() {
		return uploadMapY;
	}
	public void setUploadMapY(String uploadMapY) {
		this.uploadMapY = uploadMapY;
	}
}
