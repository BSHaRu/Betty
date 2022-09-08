package com.koreate.betty.global.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class BookPageMaker extends PageMaker{

	@Override
	public String makeQuery(int page) {
		BookCriteria bcr = (BookCriteria)super.getCri();
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", bcr.getPerPageNum())
				.queryParam("searchOption",bcr.getSearchOption())
				.queryParam("searchText",bcr.getSearchText())
				.queryParam("auth",bcr.getAuth())
				.queryParam("pub", bcr.getPub())
				.queryParam("pubDate", bcr.getPubDate())
				.queryParam("genre",bcr.getGenre())
				.build();
		return uri.toUriString();
	}
	
	
	
}
