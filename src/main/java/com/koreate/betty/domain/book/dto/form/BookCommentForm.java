package com.koreate.betty.domain.book.dto.form;

import javax.validation.constraints.NotBlank;

import com.koreate.betty.domain.book.vo.BookComment;

import lombok.Data;

@Data
public class BookCommentForm {
	
	@NotBlank
	private String bookCode;
	
	@NotBlank
	private String memberId;
	
	@NotBlank
	private String nickname;
	
	@NotBlank
	private String comment;
	

	public BookComment makeComment() {
		return BookComment.builder()
				.bookCode(bookCode)
				.memberId(memberId)
				.nickname(nickname)
				.comment(comment)
				.build();
	}
}
