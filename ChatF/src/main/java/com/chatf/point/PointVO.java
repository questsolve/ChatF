package com.chatf.point;

public class PointVO {

	private int usageNo;
	private int chatServerNo;
	private String userId;
	private int point;
	private String usageFlag;
	private String usageTime;
	
		
	public PointVO() {
		
	}


	public int getUsageNo() {
		return usageNo;
	}


	public void setUsageNo(int usageNo) {
		this.usageNo = usageNo;
	}


	public int getChatServerNo() {
		return chatServerNo;
	}


	public void setChatServerNo(int chatServerNo) {
		this.chatServerNo = chatServerNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getUsageFlag() {
		return usageFlag;
	}


	public void setUsageFlag(String usageFlag) {
		this.usageFlag = usageFlag;
	}


	public String getUsageTime() {
		return usageTime;
	}


	public void setUsageTime(String usageTime) {
		this.usageTime = usageTime;
	}


	@Override
	public String toString() {
		return "PointVO [usageNo=" + usageNo + ", chatServerNo=" + chatServerNo + ", userId=" + userId + ", point="
				+ point + ", usageFlag=" + usageFlag + ", usageTime=" + usageTime + "]";
	}
	
	
	

}
