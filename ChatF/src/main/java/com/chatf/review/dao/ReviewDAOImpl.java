package com.chatf.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chatf.common.DBManager;
import com.chatf.review.ReviewVO;

public class ReviewDAOImpl implements ReviewDAO{

	@Override
	//게시판 작성
	public int addReview(ReviewVO vo) {
        Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        DBManager db = new DBManager();
        int re =0;
        String sql = "insert into review(review_no,local_code,tag_code,user_id,write_date,review_title,review_contents" + 
        		                         "upload_file,upload_map_x,uploadmap_y,activity_yn)" + 
        		                         "values(review_seq.nextval,?,?,?,sysdate,?,?,?,?,?,y)";


        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getLocalCode());
			pstmt.setInt(2, vo.getTagCode());
			pstmt.setString(3, vo.getUserId());
			pstmt.setString(4, vo.getReviewTitle());
			pstmt.setString(5, vo.getReviewContents());
			pstmt.setString(6, vo.getUploadFile());
			pstmt.setString(7, vo.getUploadMapX());
			pstmt.setString(8, vo.getUploadMapY());
			re = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
        
		return re;
	}

	@Override
	//게시판 수정
	public int updateReview(ReviewVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		int re = 0;
		String sql ="update reveiw set reveiw_title= ?,review_contents=?,upload_file=?,upload_map_x=?,upload_map_y=? where reveiw_no=? ";
		try {
			conn = db.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getReviewTitle());
			pstmt.setString(2, vo.getReviewContents());
			pstmt.setString(3, vo.getUploadFile());
			pstmt.setString(4, vo.getUploadMapX());
			pstmt.setString(5, vo.getUploadMapY());
			pstmt.setInt(6, vo.getReviewNo());
			re = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		
		return re;
	}

	@Override
	//게시글 삭제
	public int deleteReview(int reviewNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		int re = 0;
		String sql="update review set active_yn='n' where review_no=?";
        try {
        	conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			re=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn,pstmt);
			}
		
		
		return re;
	}

	@Override
	//게시글 인기글
	public ArrayList<ReviewVO> listBestReview() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		
		String sql = "select review_no,local_code,tag_code,user_id,write_date,review_title from review where review_no in\r\n" + 
				     "(SELECT review_no FROM like WHERE like_flag =’ok’AND ROWNUM <= 10 GROUP BY review_no ORDER BY COUNT(review_no) DESC)";
		
		try {
			conn=db.dbConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setReviewNo(rs.getInt("review_no"));
				vo.setReviewTitle(rs.getString("review_title"));
				vo.setLocalCode(rs.getInt("local_code"));
				vo.setTagCode(rs.getInt("tag_code"));
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}

	//지역별 게시글 불러오기 
	@Override
	public ArrayList<ReviewVO> listLocalReview(int area) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		
		String sql = "select review_no, tag_code, user_id, write_date, review_title from review where local_code= ? and active_yn=y order by review_no  desc";
		
		try {
			conn=db.dbConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, area);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			 ReviewVO vo = new ReviewVO();
			 vo.setReviewNo(rs.getInt("review_no"));
			 vo.setTagCode(rs.getInt("tag_code"));
			 vo.setUserId(rs.getString("user_id"));
			 vo.setWriteDate(rs.getString("write_date"));
			 vo.setReviewTitle(rs.getString("review_title"));
			 
			 list.add(vo);
			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}
	
	//게시글 상세보기 

	public ReviewVO readReview(int reviewNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		ReviewVO vo = new ReviewVO();
	   
		String sql ="select review_title, review_contents, upload_file, upload_map_x, upload_map_y, write_date, user_id, from review where review_no = ? and active_yn=y";
	
		try {
			conn = db.dbConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			
			 vo.setReviewTitle(rs.getString("review_title"));
			 vo.setReviewContents(rs.getString("review_contents"));
			 vo.setUploadFile(rs.getString("upload_file"));
			 vo.setUploadMapX(rs.getString("upload_map_x"));
			 vo.setUploadMapY(rs.getString("upload_map_y"));
			 vo.setWriteDate(rs.getString("write_date"));
			 vo.setUserId(rs.getString("user_id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return vo;
	}
}
