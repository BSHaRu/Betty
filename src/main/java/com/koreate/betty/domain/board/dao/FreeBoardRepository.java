package com.koreate.betty.domain.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.board.provider.FreeBoardProvider;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.global.util.SearchCriteria;

@Mapper
public interface FreeBoardRepository {
	
	// 게시글 등록
	@InsertProvider(type=FreeBoardProvider.class, method="save")
	@Options(useGeneratedKeys = true , keyProperty = "bno")
	public int save(FreeBoard board);
	
	// 게시글 삭제
	@UpdateProvider(type=FreeBoardProvider.class, method="freeRemove")
	public int freeRemove(int bno);
	
	// 게시글 수정
	@UpdateProvider(type=FreeBoardProvider.class, method="freeUpdate")
	public int freeUpdate(FreeBoard board);
	
	// 게시글 전체 목록
	@SelectProvider(type=FreeBoardProvider.class, method="freeList")
	public List<FreeBoard> listAll(SearchCriteria cri);
	
	// 조회수 증가
	@UpdateProvider(type=FreeBoardProvider.class, method="updateCnt")
	public int updateCnt(int bno);
	
	// 전체 게시물 개수
	@SelectProvider(type=FreeBoardProvider.class, method="listAllCount")
	public int listAllCount(SearchCriteria cri);
	
	// 게시글 상세
	@SelectProvider(type=FreeBoardProvider.class, method="detail")
	public FreeBoard freeDetail(int bno);
}







