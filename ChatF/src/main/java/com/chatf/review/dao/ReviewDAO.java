package com.chatf.review.dao;

import java.util.ArrayList;

import com.chatf.review.ReviewVO;

public interface ReviewDAO {

	
	//게시판 작성
	public int addReview(ReviewVO vo);
	//게시판 수정
	public int updateReview(ReviewVO vo);
	//게시판 삭제
	public int deleteReview(int reviewNo);
	//게시글 인기글 보기
	public ArrayList<ReviewVO> listBestReview();
	//지역별 게시글 가져오기
	public ArrayList<ReviewVO> listLocalReview(int area);
	//게시글 상세 보기
	public ReviewVO readReview(int reviewNo);
	
}
