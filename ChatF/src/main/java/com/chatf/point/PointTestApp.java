package com.chatf.point;

import java.util.Iterator;
import java.util.List;

import com.chatf.point.dao.PointDao;
import com.chatf.point.dao.PointDaoImpl;

import oracle.net.aso.p;

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
		
		List<PointVO> list = pointDao.listPoint("testuser01");
		for (PointVO pointVO : list) {
			System.out.println(pointVO);
		}
		
	}

}
