package com.koreate.betty.domain.board.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class FreeBoardCommentDto {
	
	private Integer cno;
	private Integer freeBno;
	private String memberId;
	private String comment;
	private Integer origin;
	private Integer depth;
	private Integer seq;
	private Timestamp regdate;
	private String showboard;		
	
}
