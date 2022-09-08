package com.koreate.betty.domain.board.dto.form;

import javax.validation.constraints.NotBlank;

import com.koreate.betty.domain.board.vo.FreeBoardComment;

import lombok.Data;

@Data
public class FreeBoardCommentForm {
	
	private Integer cno;
	
	@NotBlank
	private Integer freeBno;
	
	@NotBlank
	private String memberId;
	
	@NotBlank
	private String comment;
	
	@NotBlank
	private String nickname;
	
	private Integer origin;
	
	
	public FreeBoardComment freeBoardComment() {
		return FreeBoardComment.builder()
				.cno(cno)
				.freeBno(freeBno)
				.memberId(memberId)
				.comment(comment)
				.nickname(nickname)
				.origin(origin)
				.build();
	}
	
}








