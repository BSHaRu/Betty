package com.koreate.betty.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreate.betty.domain.member.dto.form.PointForm;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.service.SignService;
import com.koreate.betty.domain.member.util.SignHelper;
import com.koreate.betty.domain.member.vo.Inquiry;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.rental.service.RentalService;
import com.koreate.betty.global.error.BettyInvalidValueException;
import com.koreate.betty.global.error.exception.NotFoundIdException;
import com.koreate.betty.global.resolver.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members/{id}")
public class MemberApiController {
	
	
	private final MemberService memberService;
	private final SignService SignService;
	private final RentalService rentalService;
	
	
	@PostMapping("inquiry")
	public String inquiry(@PathVariable String id, @Valid Inquiry inquiry, BindingResult bindingResult) {
		log.info("inquiry = {}", inquiry);
		if (bindingResult.hasErrors()) {
			throw new BettyInvalidValueException("요청 실패");
		}
		memberService.inquiry(inquiry);
		return "1";
	}
	
	@GetMapping("rentals/cond")
	public Map<String, Object> rentalCond(String id, String rentOption){
		System.out.println("\n\n\n\n" + id + rentOption);
		Map<String, Object> map = new HashMap<>();
		if (rentOption.equals("rent")) {
			map.put("rentals", rentalService.rentalByMemberId(id));			
		} else if (rentOption.equals("reserv")) {
			map.put("reserves", rentalService.reserveByMemberId(id));
		} else {
			map.put("rentals", rentalService.rentalByMemberId(id));
			map.put("reserves", rentalService.reserveByMemberId(id));
		}
		
		return map;
	}

	@DeleteMapping
	public Map<String,String> deleteMember(String id, @PathVariable("id") String userId, HttpServletRequest request, HttpServletResponse response) {
		log.info("id = {}, userId = {}",id,userId);
		if(userId.equals(id)) {
			int result = memberService.deleteMember(id); 
			
			SignHelper.logout(request, response);
			
			Map<String, String> map = new HashMap<>();
			map.put("code","success");
			return map;
		}
		throw new NotFoundIdException();
	}
  
	@PutMapping("charge/add")
	public int pointAdd(
			@PathVariable("id") String userId,
			@RequestBody Map<String,Object> map) {
		log.info("-- userId : {} ", userId);
		log.info("-- point : {} ", map.get("point").toString());
		PointForm form = new PointForm();
		form.setId(userId);
		Integer point = Integer.parseInt((String)map.get("point"));
		form.setPoint(point);
		memberService.addPoint(form);
		
		return memberService.findPointById(userId);
	}
	
	@PostMapping("grade/update")
	public int gradeUpdate(@User Member user, String grade) {
		memberService.updateMembership(user.getId(), grade);
		return 1;
	}

	
}


