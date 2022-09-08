package com.koreate.betty.global.error.exception;

import com.koreate.betty.global.error.BettyNotFoundException;

public class NotFoundIdException extends BettyNotFoundException {

	public NotFoundIdException() {
		super();
	}

	public NotFoundIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotFoundIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundIdException(String message) {
		super(message);
	}

	public NotFoundIdException(Throwable cause) {
		super(cause);
	}
	
	

}
