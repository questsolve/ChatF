package com.chatf.pay;

import com.chatf.point.PointVO;

public class PayVO {

	private int payNo;
	private PointVO usageNo;
	private String payWay;
	private int price;
	private String payDate;
	private String payFlag;
	
	
	public PayVO() {
		// TODO Auto-generated constructor stub
	}


	public int getPayNo() {
		return payNo;
	}


	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}


	public PointVO getUsageNo() {
		return usageNo;
	}


	public void setUsageNo(PointVO usageNo) {
		this.usageNo = usageNo;
	}


	public String getPayWay() {
		return payWay;
	}


	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getPayDate() {
		return payDate;
	}


	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}


	public String getPayFlag() {
		return payFlag;
	}


	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}


	@Override
	public String toString() {
		return "PayVO [payNo=" + payNo + ", usageNo=" + usageNo + ", payWay=" + payWay + ", price=" + price
				+ ", payDate=" + payDate + ", payFlag=" + payFlag + "]";
	}
	
	

}
