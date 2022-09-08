package com.koreate.betty.domain.board.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SuggestBoard {
	
	private final Integer bno;
	private final String memberId;
	private final String nickname;
	private final String title;
	private final String content;
	private final Integer origin;
	private final Integer depth;
	private final Timestamp regdate;
	private final Integer viewcnt;
	private final Integer recommend;
	private final String showboard;
	
}
