package com.koreate.betty.domain.member.dto.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import com.koreate.betty.domain.member.util.Base64Util;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.member.vo.Member.MemberBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateForm {
	
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
	
	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date birth;
	
	@NotBlank
	String post;
	
	@NotBlank
	String addr;
	
	@Nullable
	String addrDetail;
	
	@Nullable
	MultipartFile img;
	
	public void encode() {
		pw = Base64Util.encode(pw);
		repw = Base64Util.encode(repw);
	}
	
	public Member createMember() {
		MemberBuilder builder = Member.builder()
		.id(id)
		.pw(pw)
		.nickname(nickname)
		.name(name)
		.gender(gender)
		.birth(new Timestamp(birth.getTime()))
		.post(post)
		.addr(addr)
		.addrDetail(addrDetail);
		
		String fileName =  id + "_" + img.getOriginalFilename();
		if(img != null) {
			builder.img(fileName);
		}
		return builder.build();
	}
}