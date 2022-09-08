package com.koreate.betty.domain.book.vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JBookSingle {

	private final String code;
	private final String title;
	private final String auth;
	private final String pub;
	private final Timestamp pubDate;
	private final Integer page;
	private final Integer genre;
	private final String intro;
	private final String bookCode;
	private final Integer num;
	private final String rental;
	private final String stat;
	private final String wareMember;
	private final Timestamp wareDate;
	
}
