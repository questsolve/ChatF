package com.chatf.pay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chatf.common.DBManager;
import com.chatf.common.Page;
import com.chatf.common.Search;
import com.chatf.pay.PayVO;
import com.chatf.point.PointVO;



public class PayDaoImpl implements PayDao {


	
	public PayDaoImpl() {
		System.out.println(this.getClass().getName()+".defaultConstructor()");
	}



	public int addPay(PayVO pay) {
		int res =0;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO");
		sb.append(" pay(pay_no,usage_no,pay_way,price,pay_date,pay_flag)");
		sb.append(" VALUES(pay_seq.nextval,?,?,?,SYSDATE,?)");

		DBManager dbm = new DBManager();
		Connection con =null;
		PreparedStatement pstate = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setInt(1, pay.getUsageNo().getUsageNo());
			pstate.setString(2, pay.getPayWay());
			pstate.setInt(3, pay.getPrice());
			pstate.setString(4, pay.getPayFlag());
						
			res = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate);
		}


		return res;

	}





	public PayVO readPay(int payNo) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" pay_no,usage_no,pay_way,price,TO_CHAR(pay_date,'YYYY/MM/DD') AS pay_date,pay_flag");
		sb.append(" FROM");
		sb.append(" pay");
		sb.append(" WHERE");
		sb.append(" pay_no = ?");
		
		
		PayVO pay = new PayVO();
		DBManager dbm = new DBManager();
		Connection con =null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setInt(1, payNo);
			rs = pstate.executeQuery();
			
			while(rs.next()) {
				pay.setPayNo(rs.getInt("pay_no"));
				PointVO point = new PointVO();
				point.setUsageNo(rs.getInt("usage_no"));
				pay.setUsageNo(point);
				pay.setPrice(rs.getInt("price"));
				pay.setPayWay(rs.getString("pay_way"));
				pay.setPayFlag(rs.getString("pay_flag"));
				pay.setPayDate(rs.getString("pay_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate,rs);
		}
		
		
		
		return pay;
	}



	//TODO
	public List<PayVO> listPay(String userId,Search search){
		List<PayVO> payList = new ArrayList<PayVO>();

		int total =0;
		StringBuilder sb = new StringBuilder();
				
		sb.append("SELECT * ");
		sb.append(" FROM (");
		sb.append(" SELECT ROWNUM AS row_no, inner.*");
		sb.append(" FROM (");
		sb.append(" SELECT");
		sb.append(" pay_no,u.usage_no,pay_way,price,TO_CHAR(pay_date,'YYYY/MM/DD') AS pay_date,pay_flag");
		sb.append(" FROM");
		sb.append(" pay p, point_usage u");
		sb.append(" WHERE p.usage_no = u.usage_no AND");
		sb.append(" u.user_id = ?");
		sb.append(" ) inner");
		sb.append(" )");
		sb.append(" WHERE row_no BETWEEN ? AND ?");
		
		DBManager dbm = new DBManager();
		Connection con =null;
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
				
				PayVO pay = new PayVO();
				pay.setPayNo(rs.getInt("pay_no"));
				
				if(rs.getInt("usage_no") != 0 ) {
					PointVO point = new PointVO();
					point.setUsageNo(rs.getInt("usage_no"));
					pay.setUsageNo(point);
				}
			
				pay.setPrice(rs.getInt("price"));
				pay.setPayWay(rs.getString("pay_way"));
				pay.setPayFlag(rs.getString("pay_flag"));
				pay.setPayDate(rs.getString("pay_date"));
				payList.add(pay);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate,rs);
		}
				
		
		return payList;
	}
	
	public int listCount(String userId) {
		int rowCount =0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(1) AS cnt");
		sb.append(" FROM pay p, point_usage u");
		sb.append(" WHERE p.usage_no = u.usage_no AND");
		sb.append(" u.user_id = ?");
		
		DBManager dbm = new DBManager();
		Connection con =null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setString(1, userId);
			rs = pstate.executeQuery();
			while(rs.next()) {
				rowCount = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rowCount;
	}
	


}
