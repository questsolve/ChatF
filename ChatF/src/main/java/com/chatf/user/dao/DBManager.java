package com.chatf.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	public Connection dbConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "chatf", "0000");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void dbClose(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	
	}
	
	public void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs !=null) 	rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	
	}
	
}
