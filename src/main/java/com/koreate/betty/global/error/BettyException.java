package com.koreate.betty.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BettyException extends RuntimeException{

	public BettyException() {
		super();
	}

	public BettyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BettyException(String message, Throwable cause) {
		super(message, cause);
	}

	public BettyException(String message) {
		super(message);
	}

	public BettyException(Throwable cause) {
		super(cause);
	}

}
