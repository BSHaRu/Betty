package com.koreate.betty.global.error.exception;

import com.koreate.betty.global.error.BettyInvalidValueException;

public class MessageException extends BettyInvalidValueException {

	public MessageException() {
		super();
	}

	public MessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(Throwable cause) {
		super(cause);
	}

}
