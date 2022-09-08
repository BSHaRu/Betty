package com.koreate.betty.global.error;

public class BettyInvalidValueException extends BettyException {

	public BettyInvalidValueException() {
		super();
	}

	public BettyInvalidValueException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BettyInvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public BettyInvalidValueException(String message) {
		super(message);
	}

	public BettyInvalidValueException(Throwable cause) {
		super(cause);
	}

}
