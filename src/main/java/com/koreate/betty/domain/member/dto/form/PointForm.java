package com.koreate.betty.domain.member.dto.form;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointForm {

	@NotBlank
	String id;
	
	@Nullable
	String bankAccount;
	
	@NotBlank
	Integer point;
	
}
