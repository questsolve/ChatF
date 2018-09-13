package com.chatf.point.dao;

import java.util.List;

import com.chatf.point.PointVO;

public interface PointDao {

	public int addPoint(PointVO point);
	public PointVO readPoint(int usage_no);
	public List<PointVO> listPoint(String userId);
	
}
