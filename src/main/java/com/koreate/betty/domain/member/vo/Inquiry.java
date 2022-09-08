package com.koreate.betty.domain.member.vo;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {

	@Nullable
	private Integer bno;
	
	@NotBlank
	private String memberId;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
}
