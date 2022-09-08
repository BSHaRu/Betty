package com.koreate.betty.domain.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreate.betty.domain.board.service.NoticeBoardService;
import com.koreate.betty.domain.board.vo.NoticeBoard;
import com.koreate.betty.global.util.SearchCriteria;
import com.koreate.betty.global.util.SearchPageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/boards/notice")
@RequiredArgsConstructor
@Slf4j
public class NoticeBoardController {

	private final NoticeBoardService noticeBoardService;
	
	@GetMapping
	public ModelAndView noticeBoardList(
			ModelAndView mav,
			SearchCriteria cri) {
		mav.setViewName("board/notice/notice-board");
		SearchPageMaker pm = noticeBoardService.getPageMaker(cri);
		mav.addObject("pm",pm);
		return mav;
	}
	
	@GetMapping("noticeList")
	@ResponseBody
	public Map<String, Object> boardList(String keyword, String searchType, Integer perPageNum, Integer page){
	    System.out.printf("\n\n\n\n\n"+" keyword : "+keyword);
	    
	    System.out.println("searchType : "+searchType);
	    System.out.println("page : "+page);
	    System.out.println("perPageNum : "+perPageNum);
	    
	    SearchCriteria cri = new SearchCriteria();
	    cri.setKeyword(keyword);
	    cri.setSearchType(searchType);
	    cri.setPage(page);
	    cri.setPerPageNum(perPageNum);
	    System.out.println("\n\n\n\n\n\n\n cri :"+cri);
	    Map<String, Object> map = noticeBoardService.noticeList(cri) ;
	    System.out.println(map);
	    return map;
	}
	
	
	@GetMapping("new")
	public String noticeBoardNew() {
		return "board/notice/notice-new";
	}
	
	@GetMapping("{bno}")
	public String noticeBoardDetail(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable int bno,
			@ModelAttribute("cri") SearchCriteria cri) {
		
		NoticeBoard vo = noticeBoardService.detail(bno);
		request.setAttribute("noticeBoard", vo);
		
		return "board/notice/notice-detail";
	}

	//pathvariable
	@GetMapping("{bno}/edit")
	public String noticeBoardEdit() {
		return "board/notice/notice-edit";
	}
	
}
