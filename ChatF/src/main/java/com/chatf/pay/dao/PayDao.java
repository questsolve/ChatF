package com.chatf.pay.dao;

import java.util.List;

import com.chatf.pay.PayVO;

public interface PayDao {

	public int addPay(PayVO pay);
	public PayVO readPay(int payNo);
	public List<PayVO> listPay(String userId);
	
}
