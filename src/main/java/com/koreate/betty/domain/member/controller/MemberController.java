package com.koreate.betty.domain.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreate.betty.domain.member.dto.form.UpdateForm;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.ChkLog;
import com.koreate.betty.domain.member.vo.Inquiry;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.member.vo.MemberCard;
import com.koreate.betty.domain.model.SessionConst;
import com.koreate.betty.domain.rental.service.RentalService;
import com.koreate.betty.domain.rental.vo.RentalBook;
import com.koreate.betty.domain.rental.vo.ReserveBook;
import com.koreate.betty.infra.email.EmailSender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members/{id}")
public class MemberController {
	
	private final EmailSender emailSender;
	private final MemberService memberService;
	private final RentalService rentalService;

	@GetMapping
	public String memberInfo() { return "member/member-info"; }
	
	@GetMapping("edit")
	public String memberEdit() { return "member/member-edit"; }

	@GetMapping("charge")
	public String memberCharge(@PathVariable String id, Model model) {
		int result = memberService.findPointById(id);
		model.addAttribute("point", result);
		return "member/member-charge"; 
	}

	@GetMapping("rentals")
	public String memberRental() { return "member/member-rental-list"; }
	
	@GetMapping("dashboard")
	public String memberDashboard(@PathVariable String id, Model model) {

		MemberCard memberCard = memberService.findGradeById(id);
		model.addAttribute("memberCard", memberCard);
		
		List<RentalBook> rentalList =  rentalService.rentalByMemberId(id);
		model.addAttribute("rentalList", rentalList);
		
		List<ReserveBook> reserveList = rentalService.reserveByMemberId(id);
		model.addAttribute("reserveList", reserveList);
		
		return "member/member-dashboard";
	}

	@GetMapping("dashboard/chkLog")
	@ResponseBody
	public List<ChkLog> memberChkLog(@PathVariable String id){
		return memberService.findMyChkLog(id);
	}

	@PostMapping("membership")
	public String registerMembership(@PathVariable String memberId, String id, String membershipGrade) {
		int result = memberService.updateMembership(id, membershipGrade);
		return "redirect:/members/" + memberId;
	}
	
	@PostMapping("edit")
	public String memberEdit(@PathVariable String id, UpdateForm form, HttpSession session, RedirectAttributes rttr) {
		form.encode();
		Member user = memberService.updateMember(form);
		if(user != null) {
			session.setAttribute(SessionConst.USER, user);
			rttr.addFlashAttribute("message","요청 성공");
			return "redirect:/members/"+user.getId();
		}
		rttr.addFlashAttribute("message","요청 실패");
		return "member/member-info";
	}
	
}
