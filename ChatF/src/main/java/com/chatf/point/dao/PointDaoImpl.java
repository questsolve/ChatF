package com.chatf.point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chatf.common.DBManager;
import com.chatf.point.PointVO;

public class PointDaoImpl implements PointDao {

	public PointDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public int addPoint(PointVO point) {
		int res = 0;
		//TODO
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	public PointVO readPoint(int usage_no) {
		PointVO point = new PointVO();
		//TODO
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
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return point;
	}
	
	public List<PointVO> listPoint(String userId){
		List<PointVO> pointList = new ArrayList<PointVO>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT usage_no, user_id,chat_server_no,point,usage_flag,TO_CHAR(usage_time,'YYYY/MM/DD') AS usage_time");
		sb.append(" FROM point_usage");
		sb.append(" WHERE user_id = ?");
		
		
		DBManager dbm = new DBManager();
		Connection con = null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setString(1, userId);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pointList;
	}
	
	
	
}
