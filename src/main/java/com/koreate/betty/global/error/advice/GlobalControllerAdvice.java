package com.koreate.betty.global.error.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.koreate.betty.global.error.BettyNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler({NoHandlerFoundException.class, BettyNotFoundException.class})
	public ModelAndView noHandlerMappingHandle(Exception ex) {
		return new ModelAndView("error/404");
	}
	
}
