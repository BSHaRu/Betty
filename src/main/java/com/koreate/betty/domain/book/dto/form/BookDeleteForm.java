package com.koreate.betty.domain.book.dto.form;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BookDeleteForm {
	
	private String bookCode;
	private Integer bookNum;
	private Timestamp date;
	private String memberId;
	private String cause;
}
