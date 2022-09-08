package com.koreate.betty.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalStatusDTO {
	
	private String code;
	private String title;
	private String rental;
	private String rentalId;
	private String reserveId;
	private String rentalDate;
	private String returnDate;
	private String reserveDate;
	
}
