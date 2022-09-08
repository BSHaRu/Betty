package com.koreate.betty.domain.member.dto.form;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;
import org.springframework.util.Base64Utils;

import com.koreate.betty.domain.member.util.Base64Util;
import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInForm {
	
	@NotBlank
	String id;
	
	@NotBlank
	String pw;
	
	boolean loginCookie;
	
	public void encode() {
		pw = Base64Util.encode(pw);
	}
	
	public Member convertToMember(){
		return Member.builder()
				.id(id)
				.pw(pw)
				.build();
	}
}
