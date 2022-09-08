package com.koreate.betty.domain.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.koreate.betty.domain.board.dao.NoticeBoardRepository;
import com.koreate.betty.domain.board.dto.form.NoticeBoardForm;
import com.koreate.betty.domain.board.vo.NoticeBoard;
import com.koreate.betty.domain.book.vo.Book;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeBoardService {

    private final NoticeBoardRepository noticeRepo;

    // 공지사항 등록
    public int write(NoticeBoardForm form) {
	NoticeBoard board = form.noticeBoard();
	return noticeRepo.noticeRegist(board);
    }

    // 공지사항 수정
    public int update(NoticeBoardForm form) {
	NoticeBoard board = form.noticeBoard();
	return noticeRepo.noticeUpdate(board);
    }

    // 공지사항 삭제
    public int remove(int bno) {
	return noticeRepo.noticeRemove(bno);
    }

    // 조회수 증가
    public int updateCnt(int bno) {
	return noticeRepo.updateCnt(bno);
    }

    // 공지사항 상세
    public NoticeBoard detail(int bno) {
	return noticeRepo.noticeDetail(bno);
    }

    // 공지사항 목록
    public Map<String, Object> noticeList(SearchCriteria cri) {
	Map<String, Object> map = new HashMap<>();
	String type = cri.getSearchType();
	String keyword = cri.getKeyword();

	int totalCount = noticeRepo.listAllCount(cri);
	System.out.println("\n\n\n totalCount : " + totalCount);
	PageMaker pm = new PageMaker(cri, totalCount);
	List<NoticeBoard> noticeList = noticeRepo.noticeList(cri);
	
	map.put("keyword", keyword);
	map.put("type", type);
	map.put("list", noticeList);
	map.put("pm", pm);
	
	return map;
    }

    // 페이징 처리
    public SearchPageMaker getPageMaker(SearchCriteria cri) {
	int totalCount = noticeRepo.listAllCount(cri);
	SearchPageMaker pm = new SearchPageMaker();
	pm.setCri(cri);
	pm.setDisplayPageNum(5);
	pm.setTotalCount(totalCount);
	return pm;
    }

}
