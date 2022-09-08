package com.koreate.betty.domain.member.dto.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminSearchForm {

	String allowOption;
	String rightsOption;
	String gradeOption;
	String searchOption;
	String searchText;
	Integer page;
}