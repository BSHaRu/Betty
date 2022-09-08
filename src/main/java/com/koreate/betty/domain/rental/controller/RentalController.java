package com.koreate.betty.domain.rental.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreate.betty.domain.book.dto.form.BookSearchForm;
import com.koreate.betty.domain.book.service.BookService;
import com.koreate.betty.domain.rental.dto.ReserveBookDto;
import com.koreate.betty.domain.rental.service.RentalService;
import com.koreate.betty.domain.rental.vo.ReserveBook;
import com.koreate.betty.global.error.exception.NotFoundISBNException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {
	
	@Autowired
	BookService bs;
	
	@Autowired
	RentalService rs;
	
	@GetMapping
	@ResponseBody
	public Map<String, Object> rentalList(BookSearchForm form, Integer page) {
		Map<String, Object> map = bs.rentalBookSearch(form, page);
		return map;
	}
	
	@PostMapping		// 기존 예약 페이지를 대여 페이지로 하였음
	public String rental(String memberId, String isbn) {
		Integer num = bs.findExistNum(isbn);
		if (num == null) {
			return "redirect:/"; // 일단 홈으로
		}
		int result = rs.rentalBook(memberId, isbn, num);
		return "redirect:/books/" + isbn;
	}
	
	@PostMapping("reserve")		// 예약을 /rentals/reserve로 하였음
	@ResponseBody
	public ReserveBook reserve(@RequestBody ReserveBookDto reserveBookDto) {
		Integer num = bs.findExistNum(reserveBookDto.getIsbn());
		ReserveBook reserve = reserveBookDto.createReservBook(num);
		int result = rs.reserveBook(reserve);
		return reserve;
	}
	
	
		
}