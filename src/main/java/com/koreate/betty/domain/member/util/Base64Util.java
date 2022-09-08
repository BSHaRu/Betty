package com.koreate.betty.domain.member.util;

import org.springframework.util.Base64Utils;

public class Base64Util {
	
	public static String encode(String target) {
		byte[] encoded = Base64Utils.encode(target.getBytes());
		return new String(encoded);
	}
	
	public static String decode(String target) {
		byte[] decoded = Base64Utils.decode(target.getBytes());
		return new String(decoded);
	}
}
