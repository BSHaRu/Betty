package com.koreate.betty.global.error;

public class BettyNotFoundException extends BettyException {

	public BettyNotFoundException() {
		super();
	}

	public BettyNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BettyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BettyNotFoundException(String message) {
		super(message);
	}

	public BettyNotFoundException(Throwable cause) {
		super(cause);
	}

}
