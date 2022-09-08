package com.koreate.betty.domain.member.dto.form;

import java.util.Date;
import java.sql.Timestamp;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Base64Utils;

import com.koreate.betty.domain.member.util.Base64Util;
import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
	
	@NotBlank
	String id;
	
	@NotBlank
	String pw;
	
	@NotBlank
	String repw;
	
	@NotBlank
	String nickname;
	
	@NotBlank
	String name;
	
	@NotBlank
	String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date birth;
	
	@NotBlank
	String post;
	
	@NotBlank
	String addr;
	
	@Nullable
	String addrDetail;
	
	@NotBlank
	String phone;
	
	@NotBlank
	String email;
	
	@NotNull
	Integer rights;
		
	public void encode() {
		pw = Base64Util.encode(pw);
		repw = Base64Util.encode(repw);
	}
	
	public Member convertToMember(){
		return Member.builder()
				.id(id)
				.pw(pw)
				.nickname(nickname)
				.name(name)
				.gender(gender)
				.birth(new Timestamp(birth.getTime()))
				.phone(phone)
				.post(post)
				.addr(addr)
				.addrDetail(addrDetail)
				.email(email)
				.rights(rights)
				.build();
	}
	
		
}