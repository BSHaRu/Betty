package com.koreate.betty.domain.book.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.book.dao.BookCommentRepository;
import com.koreate.betty.domain.book.dto.form.BookCommentForm;
import com.koreate.betty.domain.book.vo.BookComment;
import com.koreate.betty.global.util.Criteria;
import com.koreate.betty.global.util.PageMaker;

@Service
public class BookCommentService {
	
	@Autowired
	BookCommentRepository bookCommentRepository;
	
	public Map<String, Object> findCommentByCode(String code, Integer page) {
		Map<String, Object> map = new HashMap<>();
		
		Criteria cri = new Criteria();
		if(page != null) {
			cri.setPage(page);
		}
		int totalCount = bookCommentRepository.findCommentByCodeCount(code);
		PageMaker pageMaker = new PageMaker(cri, totalCount);
		
//		List<BookComment>
		map.put("list", bookCommentRepository.findCommentByCode(code, cri));	// img, nickname, regdate, comment
		map.put("pm", pageMaker);
		return map;
	}
	
	public int insertComment(BookCommentForm form) {
		BookComment bookComment = form.makeComment();		
		return bookCommentRepository.insertComment(bookComment);
	}
	
	public int deleteComment(Integer num) {
		return bookCommentRepository.deleteComment(num);
	}
	
}