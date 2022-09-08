package com.koreate.betty.domain.board.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoticeBoard {
	
	private final Integer bno;
	private final String memberId;
	private final String nickname;
	private final String title;
	private final String content;
	private final Timestamp regdate;
	private final Integer viewcnt;
	private final String showboard;
	
	
	
}
