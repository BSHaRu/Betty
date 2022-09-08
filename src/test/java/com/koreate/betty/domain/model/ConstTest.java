package com.koreate.betty.domain.model;

import org.junit.Test;

public class ConstTest {

	@Test
	public void constTest() {
		String book = "book";
		
		System.out.println(TableConst.BOOK_TBL == "book");
		System.out.println(TableConst.BOOK_TBL == book);
		System.out.println(TableConst.BOOK_TBL == Const.BOOK);
	}
	
	static interface Const {
		String BOOK = "book";
	}
}
