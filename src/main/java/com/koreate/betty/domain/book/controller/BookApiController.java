package com.koreate.betty.domain.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.koreate.betty.domain.book.dto.form.BookDeleteForm;
import com.koreate.betty.domain.book.service.BookCommentService;
import com.koreate.betty.domain.book.service.BookService;
import com.koreate.betty.domain.book.vo.JBookSingle;

@RestController
public class BookApiController {

	@Autowired
	BookService bs;
	
	@Autowired
	BookCommentService bcs;
	
	// 한 도서의 목록 출력(삭제용)
	@GetMapping("{isbn}/single")
	public List<JBookSingle> delBookList(@PathVariable String isbn){ // json
		return bs.findBookSingleByCode(isbn);
	}
	
	// 선택 도서 삭제
	@DeleteMapping("{isbn}/single")
	public String delBooks(List<BookDeleteForm> bookList) {
		int result = bs.deleteBook(bookList);
		
		String message = "";
		if (result > 0) {
			message = String.valueOf(result) + "개의 책이 삭제되었습니다.";
		} else {
			message = "삭제에 실패했습니다.";
		}
		
		return message;
	}
	
	
}
