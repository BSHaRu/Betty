package com.koreate.betty.global.error;

public class BettyAccessDeniedException extends BettyException{

	public BettyAccessDeniedException() {
		super();
	}

	public BettyAccessDeniedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BettyAccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public BettyAccessDeniedException(String message) {
		super(message);
	}

	public BettyAccessDeniedException(Throwable cause) {
		super(cause);
	}
	
}
