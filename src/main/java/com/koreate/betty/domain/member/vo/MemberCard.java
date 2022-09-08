package com.koreate.betty.domain.member.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberCard {
	
 	private final String memberId;
 	private final String premiumGrade;
 	private final String premiumDate;
    private final Integer demerit;
	private final Integer point;
	private final Integer spending;
}
