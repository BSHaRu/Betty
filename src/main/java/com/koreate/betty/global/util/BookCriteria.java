package com.koreate.betty.global.util;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper=true)
public class BookCriteria extends Criteria {
	
	{
		this.setPerPageNum(8);
	}
	
	private String genre;
	private String searchOption;
	private String searchText;
	private String auth;
	private String pub;
	private String pubDate; // 타임스탬프로 변환
	
	
	public BookCriteria(int page, int perPageNum, String genre, String searchOption, String searchText) {
		super(page, perPageNum);
		this.genre = genre;
		this.searchOption = searchOption;
		this.searchText = searchText;
	}
	public BookCriteria(int page, int perPageNum, String searchOption, String searchText, String pub, String pubDate) {
		super(page, perPageNum);
		this.searchOption = searchOption;
		this.searchText = searchText;
		this.pub = pub;
		this.pubDate = pubDate;
		this.auth = auth;
	}
	
	
}