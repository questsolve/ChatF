package com.chatf.point;


import java.util.List;

import com.chatf.common.Search;
import com.chatf.point.dao.PointDao;
import com.chatf.point.dao.PointDaoImpl;

public class PointTestApp {

	public PointTestApp() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		PointVO point = new PointVO();
		
		point.setUsageFlag("add");
		point.setPoint(1000);
		point.setUserId("testuser01");
		point.setChatServerNo(0);
		
		PointDao pointDao = new PointDaoImpl();
		//int rest = pointDao.addPoint(point);
		//System.out.println(rest);
		
		point = pointDao.readPoint(4100000);
		System.out.println(point);
		Search search = new Search(); 
		search.setCurrentPage(1);
		search.setPageSize(2);
		List<PointVO> list = pointDao.listPoint("testuser01",search);
		for (PointVO pointVO : list) {
			
		}
		
	}

}
