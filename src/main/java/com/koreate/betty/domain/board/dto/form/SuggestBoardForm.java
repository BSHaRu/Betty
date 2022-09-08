package com.koreate.betty.domain.board.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.koreate.betty.domain.board.vo.SuggestBoard;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class SuggestBoardForm {
	
	@Nullable
	private Integer bno;
	
	@NotBlank
	private String memberId;
	
	private String nickname;
	
	@Size(max = 50)
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private Integer depth;
	
	
	private Integer origin;
	
	public SuggestBoard suggestBoard() {
		return SuggestBoard.builder()
				.bno(bno)
				.memberId(memberId)
				.nickname(nickname)
				.title(title)
				.content(content)
				.depth(depth)
				.origin(origin)
				.build();
	} 
}
