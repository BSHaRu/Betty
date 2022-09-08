package com.koreate.betty.domain.member.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlackList {
	
	private final String memberId;
	private final String cause;	

}
