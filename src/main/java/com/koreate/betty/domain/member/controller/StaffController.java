package com.koreate.betty.domain.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreate.betty.domain.book.dto.form.BookSearchForm;
import com.koreate.betty.domain.book.service.BookService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	BookService bs;

	@GetMapping
	public String staffMain() {
		return "staff/staff-main";
	}

	@GetMapping("{memberId}")
	public String userInfo() {
		return "staff/staff-info";
	}

	@GetMapping("members")
	public String staffInfo() {
		return "staff/staff-member-list";
	}

	@GetMapping("{memberId}/edit")
	public String staffUpdate() {
		return "staff/staff-edit";
	}

	@GetMapping("books")
	public String bookInfo() {
		return "staff/staff-book-list";
	}

	// 직원이 확인하는 도서 현황 페이지
	@GetMapping("books/cond")
	@ResponseBody
	public Map<String, Object> bookCond(String searchText, String searchOption, String pubDate, String pubDateOption,
			String genre, Integer page) { // json	// key : list, pm, nowCount, allCount // VO : BOOK 참조

		BookSearchForm form = new BookSearchForm();
		form.setSearchText(searchText);
		form.setSearchOption(searchOption);
		form.setPubDate(pubDate);
		form.setPubDateOption(pubDateOption);
		form.setGenre(genre);
		System.out.println("\n\n\nform : " + form);
		Map<String, Object> map = bs.bookSearch(form, page);
		
		return map;
	}

	@GetMapping("books/new")
	public String newBooks() {
		return "staff/staff-book-new";
	}

	@GetMapping("books/{isbn}/edit")
	public String updateBooks(@PathVariable String isbn, Model model) { // key : book
		model.addAttribute("book", bs.bookDetail(isbn));
		return "staff/staff-book-edit";
	}

	@GetMapping("rentals")
	public String rentalList() {
		return "staff/staff-rental-list";
	}

	// 직원이 확인하는 대여 현황 페이지
	@GetMapping("rentals/cond")
	@ResponseBody
	public Map<String, Object> rentalCond(String searchText, String searchOption, String pubDate, String pubDateOption,
			String rentOption, Integer page) { // json		// key : list, pm  // 컬럼이 다릅니다. VO : RentalStatusDTO 참조

		BookSearchForm form = new BookSearchForm();
		form.setSearchText(searchText);
		form.setSearchOption(searchOption);
		form.setPubDate(pubDate);
		form.setPubDateOption(pubDateOption);
		form.setRentOption(rentOption);

		return bs.rentalBookSearch(form, page);
	}

}
