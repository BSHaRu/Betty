package com.koreate.betty.domain.book.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSearchForm {

	@Nullable
	private String searchText;

	@Nullable
	private String searchOption;

	@Nullable
	private String rentOption;

	@Nullable	// 태그의 입력 형태에 따라 바뀔 수 있음 > provider 변경 필요
	private String pubDate;

	@Nullable
	private String pubDateOption;

	@Nullable
	private String genre;
}