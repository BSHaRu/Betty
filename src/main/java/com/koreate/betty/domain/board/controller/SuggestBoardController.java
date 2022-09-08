package com.koreate.betty.domain.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreate.betty.domain.board.dto.SuggestBoardDTO;
import com.koreate.betty.domain.board.dto.form.SuggestBoardForm;
import com.koreate.betty.domain.board.service.SuggestBoardService;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.global.util.PageMaker;
import com.koreate.betty.global.util.SearchCriteria;

@Controller
@RequestMapping("/boards/suggest")
public class SuggestBoardController {

    @Autowired
    SuggestBoardService sboardserv;

    // 게시판 목록 불러오기 : Model & View 사용
    @GetMapping
    public ModelAndView suggestBoardList(SearchCriteria cri, ModelAndView mav) throws Exception {
	mav.setViewName("board/suggest/suggest-board");
	List<SuggestBoardDTO> list = sboardserv.SuggestList(cri);
	PageMaker pm = sboardserv.getPageMaker(cri);
	mav.addObject("list", list);
	mav.addObject("pm", pm);
	return mav;
    }

    @GetMapping("new")
    public String freeBoardNew() throws Exception {
	return "board/suggest/suggest-new";
    }
     // 건의사항 등록
    @PostMapping("writeSubmit")
    @ResponseBody
    public int freeBoardNew(@RequestBody SuggestBoardForm sugboard) throws Exception {
	sugboard.setBno(0);
	System.out.println(sugboard.getNickname());
	int bno = sboardserv.suggestWrite(sugboard);
	System.out.println("endwrite \n\n\n\n\n\n\n");
	return bno;
    }

    // 조횟수 증가
    @GetMapping("suggestDetail")
    public String readCount(int bno, RedirectAttributes reatt) throws Exception {
	reatt.addAttribute("bno", bno);
	return "redirect:/boards/suggest/detail";
    }

    @Autowired
    MemberService memberService;

    // 게시판 상세보기, Model 사용
    @GetMapping("detail")
    public String sBoardDetail(int bno, Model model) throws Exception {
	SuggestBoardDTO board = sboardserv.suggestDetail(bno);
	String id = board.getMemberId();
	String memberImg = memberService.findOne(id).getImg();

	model.addAttribute("board", board);
	model.addAttribute("memberImg", memberImg);
	return "board/suggest/suggest-detail";
    }

    // 수정 페이지 요청. GET
    @GetMapping("sugedit")
    public String sugedit(int bno, Model model) throws Exception {
	SuggestBoardDTO board = sboardserv.suggestDetail(bno);
	model.addAttribute("board", board);
	return "board/suggest/suggest-edit";
    }

    // 게시물 수정 처리
    @PostMapping("sboardModify")
    @ResponseBody
    public int sboardModify(@RequestBody SuggestBoardForm sugboard) throws Exception {
	int no = sboardserv.suggestUpdate(sugboard);
	return no;
    }

    // 게시물 삭제(숨김처리)
    @PostMapping("delete")
    @ResponseBody
    public int delete(@RequestBody SuggestBoardForm sugboard) throws Exception {
	System.out.println("\n\n\n\n\n" + sugboard);

	int success = sboardserv.suggestRemove(sugboard);
	System.out.println("\n\n\n\n" + success);

	return success;
    }

}