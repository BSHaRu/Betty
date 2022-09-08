package com.koreate.betty.domain.board.dto.form;

import com.koreate.betty.domain.board.vo.NoticeBoard;

import lombok.Data;
@Data
public class NoticeBoardForm {
	
	private Integer bno;
	
	private String memberId;
	
	private String nickname;
	
	private String title;

	private String content;
	
	
	public NoticeBoard noticeBoard() {
		return NoticeBoard.builder()
				.bno(bno)
				.memberId(memberId)
				.nickname(nickname)
				.title(title)
				.content(content)
				.build();
	}
	
}
