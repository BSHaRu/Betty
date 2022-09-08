package com.koreate.betty.global.error.exception;

import com.koreate.betty.global.error.BettyNotFoundException;

public class NotFoundISBNException extends BettyNotFoundException {

	public NotFoundISBNException() {
		super();
	}

	public NotFoundISBNException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotFoundISBNException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundISBNException(String message) {
		super(message);
	}

	public NotFoundISBNException(Throwable cause) {
		super(cause);
	}

	
	
}
