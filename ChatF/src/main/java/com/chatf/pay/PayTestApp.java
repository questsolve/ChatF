package com.chatf.pay;

import java.util.List;

import com.chatf.common.Page;
import com.chatf.pay.dao.PayDao;
import com.chatf.pay.dao.PayDaoImpl;
import com.chatf.point.PointVO;

public class PayTestApp {


	public static void main(String[] args) {
		PayDao payDao = new PayDaoImpl();
		PointVO point = new PointVO();
		point.setUsageNo(0);
		PayVO pay = new PayVO();
		pay.setPayFlag("add");
		pay.setUsageNo(point);
		pay.setPayWay("paypal");
		pay.setPrice(10000);
		
		
		//int count = payDao.addPay(pay);
		
		//System.out.println(count);
		
		Page page = new Page();
		List<PayVO> list = payDao.listPay("testuser01",page);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
				
		
	}

}
