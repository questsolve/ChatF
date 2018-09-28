package com.chatf.point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chatf.common.DBManager;
import com.chatf.common.Search;
import com.chatf.point.PointVO;

public class PointDaoImpl implements PointDao {

	public PointDaoImpl() {

	}

	public int addPoint(PointVO point) {
		int res = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO");
		sb.append(" point_usage(usage_no,chat_server_no,user_id,point, usage_flag,usage_time)");
		sb.append(" VALUES(usage_seq.nextval,?,?,?,?,sysdate)");
		
		DBManager dbm = new DBManager();
		Connection con = null;
		PreparedStatement pstate = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setInt(1, point.getChatServerNo());
			pstate.setString(2, point.getUserId());
			pstate.setInt(3, point.getPoint());
			pstate.setString(4, point.getUsageFlag());
			
			res = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	public PointVO readPoint(int usage_no) {
		PointVO point = new PointVO();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT usage_no, user_id,chat_server_no,point,usage_flag,TO_CHAR(usage_time,'YYYY/MM/DD') AS usage_time");
		sb.append(" FROM point_usage");
		sb.append(" WHERE usage_no = ?");
		
		
		DBManager dbm = new DBManager();
		Connection con = null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setInt(1,usage_no);
			rs = pstate.executeQuery();
			
			while(rs.next()) {
				point.setUsageNo(rs.getInt("usage_no"));
				point.setChatServerNo(rs.getInt("chat_server_no"));
				point.setUserId(rs.getString("user_id"));
				point.setUsageFlag(rs.getString("usage_flag"));
				point.setUsageTime(rs.getString("usage_time"));
				point.setPoint(rs.getInt("point"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return point;
	}
	
	public List<PointVO> listPoint(String userId,Search search){
		List<PointVO> pointList = new ArrayList<PointVO>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * ");
		sb.append(" FROM (");
		sb.append(" SELECT ROWNUM AS row_no, inner.*");
		sb.append(" FROM(");
		sb.append(" SELECT usage_no, user_id,chat_server_no,point,usage_flag,TO_CHAR(usage_time,'YYYY/MM/DD') AS usage_time");
		sb.append(" FROM point_usage");
		sb.append(" WHERE user_id = ?");
		sb.append(" ) inner");
		sb.append(" )");
		sb.append(" WHERE row_no BETWEEN ? AND ?");
		
		
		DBManager dbm = new DBManager();
		Connection con = null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setString(1, userId);
			pstate.setInt(2, search.getStartRowNum());
			pstate.setInt(3, search.getEndRowNum());
			rs = pstate.executeQuery();
			
			while(rs.next()) {
				PointVO point = new PointVO();
				point.setUsageNo(rs.getInt("usage_no"));
				point.setChatServerNo(rs.getInt("chat_server_no"));
				point.setUserId(rs.getString("user_id"));
				point.setUsageFlag(rs.getString("usage_flag"));
				point.setUsageTime(rs.getString("usage_time"));
				pointList.add(point);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pointList;
	}
	
	
	public int readCurrentPointNO(String userId) {
		int currentUsageNo = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM(");
		sb.append(" SELECT usage_no");
		sb.append(" FROM point_usage");
		sb.append(" WHERE user_id = ?");
		sb.append(" ORDER BY usage_time DESC )");
		sb.append(" WHERE ROWNUM <2");
		
		
		DBManager dbm = new DBManager();
		Connection con = null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setString(1,userId);
			rs = pstate.executeQuery();
			
			if(rs.next()) {
				currentUsageNo = rs.getInt("usage_no");
				System.out.println("pointDAO : "+currentUsageNo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return currentUsageNo;
	}
	
	public int readPoint(String userId) {
		int totalPoint = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" ((SELECT SUM(point)");
		sb.append(" FROM point_usage");
		sb.append(" WHERE user_id = ?");
		sb.append(" AND usage_flag = 'add')");
		
		sb.append(" -(SELECT NVL(SUM(point),0)");
		sb.append(" FROM point_usage");
		sb.append(" WHERE user_id = ?");
		sb.append(" AND usage_flag = 'use')) AS total");
		sb.append(" FROM dual");
		
		
		
		DBManager dbm = new DBManager();
		Connection con = null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setString(1,userId);
			pstate.setString(2,userId);
			rs = pstate.executeQuery();
			
			if(rs.next()) {
				totalPoint = rs.getInt("total");
				System.out.println("pointDAO : "+totalPoint);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return totalPoint;
	}
	
	
	
	
	
	
}
