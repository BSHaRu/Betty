package com.koreate.betty.domain.offline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreate.betty.domain.book.service.BookService;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.member.vo.MemberCard;
import com.koreate.betty.domain.offline.service.OfflineService;
import com.koreate.betty.domain.rental.service.RentalService;
import com.koreate.betty.global.error.BettyNotFoundException;
import com.koreate.betty.global.resolver.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/offline/{id}")
public class OfflineController {
	
	@Autowired
	OfflineService os;
	
	@Autowired
	MemberService ms;
	
	@Autowired
	BookService bs;
	
	@Autowired
	RentalService rs;
	
	@GetMapping
	public String offline(@PathVariable String id, @User Member user, Model model) {
		String userId = user.getId();
		model.addAttribute("reserves", rs.reserveByMemberId(userId));	// List<ReserveBook>
		model.addAttribute("rentals", rs.rentalByMemberId(userId));		// List<RentalBook>
		return "offline/offline";
	}
	
	@GetMapping("room")
	@ResponseBody
	public List<Integer> initSeat(){
		return os.seatStatus();
	}
	
	@PostMapping("receipt")
	@Transactional
	public String rentalReceipt(@PathVariable String id, rentalDto rsv) {
		String code = rsv.getCode();
		int result = rs.reserveCancle(id, code);
		Integer num = bs.findExistNum(code);
		result += rs.rentalBook(id, code, num);
		MemberCard mc = ms.findGradeById(id);		
		result += ms.updateLend(id, mc.getPremiumGrade());		
		return "redirect:/offline/"+id;
	}
	
	
	@PostMapping("return")
	public String rentalReturn(@PathVariable String id, rentalDto rental) {
		String code = rental.getCode();
		int result = rs.returnBook(id, code);
		return "redirect:/offline/"+id;
	}
	
	@PostMapping("checkIn")
	@ResponseBody
	public int checkIn(@PathVariable String id, Integer seat) {
		int result = os.checkIn(id, seat);
		return result;
	}
	
	@PostMapping("checkOut")
	@ResponseBody
	public int checkOut(@User Member user) {
		log.info("@User ={}", user);
		int result = os.checkOut(user.getId());
		return result;
	}
	
	@GetMapping("checkReal")
	@ResponseBody
	public boolean checkReal(@User Member user) {
		log.info("@User ={}", user);
		return os.checkMember(user.getId());
	}
	
	// Rental 가져올 곳 많으면 따로 클래스 만들어도됨
	@Data
	@NoArgsConstructor
	static class rentalDto{
		private String code;
		private String num;
	}
	
}
