package com.koreate.betty.jaemin;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.Base64Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestTest {

	public static void main(String[] args) {
		String message  = "안녕하이";
		byte[] encodeMessage = Base64Utils.encode(message.getBytes());
		System.out.println(new String(encodeMessage));
		
		String encoding = new String(encodeMessage);
		System.out.println(encoding); // 얘를 줘야함
		
		byte[] result = Base64Utils.decode(encodeMessage);
		System.out.println(result);
		
		String decodeing = new String(result);
		System.out.println(decodeing); // 얘로 비교해야함.
		
		
	}
}
