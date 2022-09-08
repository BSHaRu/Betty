package com.koreate.betty.domain.board.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FreeBoardDto {
	
	private Integer bno;
	private String memberId;
	private String tag;
	private String title;
	private String content;
	private Timestamp regdate;
	private Integer viewcnt;
	private String showboard;
	
}
