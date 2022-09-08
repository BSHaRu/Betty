package com.koreate.betty.domain.board.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class NoticeBoardDto {
	
	private Integer bno;
	private String memberId;
	private String title;
	private String content;
	private Timestamp regdate;
	private Integer viewcnt;
	private String showboard;
}
