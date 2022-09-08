package com.koreate.betty.domain.rental.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.koreate.betty.domain.rental.vo.ReserveBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveBookDto{
	@NotBlank
	private String memberId;
	@NotBlank
	private String isbn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	public ReserveBook createReservBook(Integer num) {
		return ReserveBook.builder()
				.id(memberId)
				.code(isbn)
				.date(new Timestamp(date.getTime()))
				.num(num)
				.build();
	}
}