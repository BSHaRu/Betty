package com.koreate.betty.domain.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.SuggestBoardRepository;
import com.koreate.betty.domain.board.dto.SuggestBoardDTO;
import com.koreate.betty.domain.board.dto.form.SuggestBoardForm;
import com.koreate.betty.domain.board.vo.SuggestBoard;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

@Service
public class SuggestBoardService {

    @Autowired
    SuggestBoardRepository dao;

    // 건의사항 등록
    public int suggestWrite(SuggestBoardForm form) {
	SuggestBoard board = form.suggestBoard();
	dao.suggestRegist(board);
	dao.updateOrigin();
	return board.getBno();
    }

    // 답변글 등록
    public int suggestReply(SuggestBoardForm form) {
	form.setDepth(1);
	SuggestBoard board = form.suggestBoard();
	return dao.suggestReply(board);
    }

    // 건의사항 삭제
    public int suggestRemove(SuggestBoardForm form) {
	SuggestBoard board = form.suggestBoard();
	int asdf = dao.suggestRemove(board);
	System.out.println(asdf);
	int no = 1;
	return no;
    }

    // 건의사항 수정
    public int suggestUpdate(SuggestBoardForm form) {
	SuggestBoard vo = form.suggestBoard();
	System.out.println(vo.getBno()+"\n\n\n\n\n");
	return dao.suggestUpdate(vo);
    }

    // 건의사항 상세
    public SuggestBoardDTO suggestDetail(int bno) {
	return dao.suggestRead(bno);
    }

    // 건의사항 목록
    public List<SuggestBoardDTO> SuggestList(SearchCriteria cri) {             
	String type = cri.getSearchType();                                     
	String word = cri.getKeyword();                                        
	List<SuggestBoardDTO> list = dao.SuggestList(cri);                     
	if (type != null && !type.trim().equals("") && !type.equals("n")) {    
	    for (SuggestBoardDTO board : list) {                               
		board.setTitle(mark(board.getTitle(), word));                  
		board.setMemberId(mark(board.getMemberId(), word));            
	    }
	}
	System.out.println(list);
	return list;
    }

    // 조회수 증가
    public int updateCnt(int bno) {
	return dao.updateCnt(bno);
    }

    // 추천수 증가
    public int updateRecommend(int bno) {
	return dao.updateRecommend(bno);
    }

    // 페이징 처리
    public PageMaker getPageMaker(SearchCriteria cri) {
	int totalCount = dao.listCount(cri);
	PageMaker pm = new SearchPageMaker();
	pm.setCri(cri);
	pm.setDisplayPageNum(5);
	pm.setTotalCount(totalCount);
	return pm;
    }

    // 검색 단어 표시
    public String mark(String text, String word) {
	text = text.replace(word, "<b style='color:blue;'>" + word + "</b>");
	return text;
    }

}
