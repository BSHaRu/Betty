package com.koreate.betty.domain.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreate.betty.domain.member.service.SignService;
import com.koreate.betty.domain.member.util.SignHelper;
import com.koreate.betty.domain.model.SessionConst;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignApiController {

	private final SignService signService;

	@GetMapping("up/idCheck")
	public boolean idCheck(String id) {
		return signService.checkIdDupl(id);
	}

	@GetMapping("up/nicknameCheck")
	public boolean nicknameCheck(String nickname) {
		System.out.println("\n\n\n\nnickname : " + nickname);
		return signService.checkNicknameDupl(nickname);
	}

	@GetMapping("up/emailCheck")
	public boolean emailCheck(String email) {
		return signService.checkEmailDupl(email);
	}
	
	@GetMapping("up/phoneCheck")
	public boolean phoneCheck(String phone) {
		return signService.checkPhoneDupl(phone);
	}

	@GetMapping("find/id")
	public String sendSMS(FindIdDto dto, HttpSession session) {
		signService.forgetId(dto.getName(), dto.getPhone());
		SignHelper.makeCodeForSMS(session);
		return "1";
	}

	@PostMapping("find/id")
	public String smsValid(FindIdDto dto, HttpSession session) {
		String sessionCode = (String)session.getAttribute(SessionConst.SMS_CODE);
		String code = dto.getCode();
		if (code.equals(sessionCode)) {
			return signService.forgetId(dto.getName(), dto.getPhone());
		}
		return "0";
	}

	@GetMapping("up/sms")
	public String sendSMS(String phone, HttpSession session) {
		signService.sendSMS(phone, session);
		return (String)session.getAttribute(SessionConst.SMS_CODE);
	}

	@PostMapping("up/sms")
	public ResponseEntity<String> smsValid(String code, HttpSession session) {
		String sessionCode 
			= (String)session.getAttribute(SessionConst.SMS_CODE);
		if(code.equals(sessionCode)) {
			session.invalidate();
			return new ResponseEntity<>("1",HttpStatus.OK);
		}
		return new ResponseEntity<>("0",HttpStatus.BAD_REQUEST);
	}

	@GetMapping("up/email")
	public String sendEmail(String email, HttpSession session) {
		signService.sendEmail(email, session);
		return (String)session.getAttribute(SessionConst.EMAIL_CODE);
	}

	@PostMapping("up/email")
	public ResponseEntity<String> emailValid(String code, HttpSession session) {
		String sessionCode 
			= (String)session.getAttribute(SessionConst.EMAIL_CODE);
		if(code.equals(sessionCode)) {
			session.invalidate();
			return new ResponseEntity<>("1",HttpStatus.OK);
		}
		return new ResponseEntity<>("0",HttpStatus.BAD_REQUEST);
	}
	
	@Data
	static class FindIdDto {
		private String name;
		private String phone;
		private String code;
	}
	
	@Data
	static class FindPwDto{
		private String id;
		private String phone;
		private String code;
	}
	
}
