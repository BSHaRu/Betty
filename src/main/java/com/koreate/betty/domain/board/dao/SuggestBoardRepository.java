package com.koreate.betty.domain.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.board.dto.SuggestBoardDTO;
import com.koreate.betty.domain.board.provider.SuggestBoardProvider;
import com.koreate.betty.domain.board.vo.SuggestBoard;
import com.koreate.betty.global.util.SearchCriteria;

@Mapper
public interface SuggestBoardRepository {
	
		// 건의사항 등록
		@InsertProvider(type=SuggestBoardProvider.class, method="suggestRegist")
		@Options(useGeneratedKeys = true , keyProperty = "bno")
		public int suggestRegist(SuggestBoard vo);
		
		// 답변글 등록
		@InsertProvider(type=SuggestBoardProvider.class, method="suggestRegist")
		@Options(useGeneratedKeys = true , keyProperty = "bno")
		public int suggestReply(SuggestBoard vo);
		
		// 업데이트 오리진
		@UpdateProvider(type=SuggestBoardProvider.class, method="updateOrigin")
		public int updateOrigin();
		
		// 건의사항 삭제
		@UpdateProvider(type=SuggestBoardProvider.class, method="suggestRemove")
		public int suggestRemove(SuggestBoard vo);
		
		// 건의사항 수정
		@UpdateProvider(type=SuggestBoardProvider.class, method="suggestUpdate")
		public int suggestUpdate(SuggestBoard vo);
		
		// 건의사항 상세
		@SelectProvider(type=SuggestBoardProvider.class, method="suggestDetail")
		public SuggestBoardDTO suggestRead(int bno);
		
		// 건의사항 목록 출력
		@SelectProvider(type=SuggestBoardProvider.class, method = "suggestList")
		public List<SuggestBoardDTO> SuggestList(SearchCriteria cri);
		
		// 조회수 증가
		@UpdateProvider(type=SuggestBoardProvider.class, method="updateCnt")
		public int updateCnt(int bno);
		
		// 추천수 증가
		@UpdateProvider(type=SuggestBoardProvider.class, method="updateRecommend")
		public int updateRecommend(int bno);
		
		// 전체 게시글 개수
		@SelectProvider(type=SuggestBoardProvider.class, method = "listAllCount")
		public int listCount(SearchCriteria cri);

}
