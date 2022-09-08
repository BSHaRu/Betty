package com.koreate.betty.domain.book.dto.form;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.koreate.betty.domain.book.vo.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
	
	@Size(max = 50)
	@NotBlank
	private String code;
	
	@Size(max = 50)
	@NotBlank
	private String title;
	
	@Size(max = 30)
	@NotBlank
	private String auth;
	
	@Size(max = 50)
	@NotBlank
	private String pub;
	
	@Size(max = 50)
	@NotBlank
	private String pubDate;
	
//	@NotBlank // 필수 X
	private Integer page;
	
	@NotBlank
	private Integer genre;
	
//	@NotBlank // 필수 X
	private String intro;
	
	public Book createBook() {
		
		return Book.builder()
				.code(code)
				.title(title)
				.auth(auth)
				.pub(pub)
				.pubDate(Timestamp.valueOf(pubDate + " 00:00:00"))
				.page(page)
				.genre(genre)
				.intro(intro)
				.build();
	}
}
