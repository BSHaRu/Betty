package com.koreate.betty.domain.board.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class SuggestBoardDTO {
	
	private Integer bno;
	private String memberId;
	private String nickname;
	private String title;
	private String content;
	private Integer origin;
	private Integer depth;
	private Timestamp regdate;
	private Integer viewcnt;
	private Integer recommend;
	private String showboard;
	
}
