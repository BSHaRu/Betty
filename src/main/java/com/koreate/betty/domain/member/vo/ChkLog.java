package com.koreate.betty.domain.member.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ChkLog {

	private final Integer num;
	private final String memberId;
	private final String checkTime;
	private final String checkoutTime;
	private final String seat;
	
}