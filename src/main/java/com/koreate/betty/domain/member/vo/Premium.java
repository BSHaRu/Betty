package com.koreate.betty.domain.member.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Premium {
	
	private final String grade;		
    private final Integer fee; 					
    private final Integer lendBookcnt; 
    private final Integer lendPeriod;
    private final Integer dueSale;
    private final Integer lendPrice;
	
}
