package com.koreate.betty.domain.member.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private String id;
	private String pw;
	private String nickname;
	private String name;
	private String gender;
	private Timestamp birth;
	private String phone;
	private String post;
	private String addr;
	private String addrDetail;
	private String email;
	private Timestamp regDate;
	private String del;
	private String img;
	private Integer rights;
	
}