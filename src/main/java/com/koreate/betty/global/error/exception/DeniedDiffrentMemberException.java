package com.koreate.betty.global.error.exception;

import com.koreate.betty.global.error.BettyAccessDeniedException;

public class DeniedDiffrentMemberException extends BettyAccessDeniedException{

	public DeniedDiffrentMemberException() {
		super();
	}

	public DeniedDiffrentMemberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DeniedDiffrentMemberException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeniedDiffrentMemberException(String message) {
		super(message);
	}

	public DeniedDiffrentMemberException(Throwable cause) {
		super(cause);
	}
	
}
