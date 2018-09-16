package com.chatf.pay.dao;

import java.util.List;

import com.chatf.common.Page;
import com.chatf.common.Search;
import com.chatf.pay.PayVO;

public interface PayDao {


	public int addPay(PayVO pay);
	public PayVO readPay(int payNo);
	public List<PayVO> listPay(String userId,Search search);
	public int listCount(String userId);
	public int readCurrentPay(int usage_no);
}
