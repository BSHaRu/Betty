package com.koreate.betty.domain.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.board.provider.NoticeBoardProvider;
import com.koreate.betty.domain.board.vo.NoticeBoard;
import com.koreate.betty.global.util.SearchCriteria;

@Mapper
public interface NoticeBoardRepository {
	
	// 공지사항 등록
	@InsertProvider(type=NoticeBoardProvider.class, method="noticeRegist")
	@Options(useGeneratedKeys = true , keyProperty = "bno")
	public int noticeRegist(NoticeBoard board);
	
	// 공지사항 수정
	@UpdateProvider(type=NoticeBoardProvider.class, method="noticeUpdate")
	public int noticeUpdate(NoticeBoard board);
	
	// 공지사항 삭제
	@UpdateProvider(type=NoticeBoardProvider.class, method="noticeRemove")
	public int noticeRemove(int bno);		

	// 공지사항 상세
	@SelectProvider(type=NoticeBoardProvider.class, method="noticeDetail")
	public NoticeBoard noticeDetail(int bno);
	
	// 공지사항 목록
	@SelectProvider(type=NoticeBoardProvider.class, method = "noticeList")
	public List<NoticeBoard> noticeList(SearchCriteria cri);
	
	// 조회수 증가
	@UpdateProvider(type=NoticeBoardProvider.class, method="updateCnt")
	public int updateCnt(int bno);
	
	// 전체 게시물 수
	@SelectProvider(type=NoticeBoardProvider.class, method="listAllCount")
	public int listAllCount(SearchCriteria cri);
}
