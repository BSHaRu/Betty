package com.koreate.betty.domain.book.provider;

import static com.koreate.betty.domain.model.TableConst.BOOK_DUMP_TBL;
import static com.koreate.betty.domain.model.TableConst.BOOK_SINGLE_TBL;
import static com.koreate.betty.domain.model.TableConst.BOOK_TBL;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.book.dto.form.BookDeleteForm;

public class BookSingleProvider {	// single, dump
	
	// 도서 1권 정보
	public String single(@Param("code")String code, @Param("num")Integer num) { // book_single 객체를 넘겨받거나, form 형태를 받음		
		return new SQL().SELECT("*").FROM(BOOK_TBL)
				.JOIN(BOOK_SINGLE_TBL)
				.WHERE("book_code = code")
				.WHERE("book_code = #{code}")
				.WHERE("num = #{num}")
				.toString();
	}
		
	// 도서 재고 추가
	public String insertWare(@Param("code")String code, @Param("id")String id) {
		return new SQL().INSERT_INTO(BOOK_SINGLE_TBL)
				.INTO_COLUMNS("book_code", "ware_member")
				.INTO_VALUES("#{code}, #{id}")
				.toString();
	}
		
	// 도서 폐기
	public String delete(BookDeleteForm form) {
		return new SQL().DELETE_FROM(BOOK_SINGLE_TBL)
				.WHERE("book_code = #{code}")
				.WHERE("num = #{bookNum}")
				.toString();
	}
	
	// 폐기 테이블에 목록 추가
	public String insertDump(BookDeleteForm form) {
		return new SQL().INSERT_INTO(BOOK_DUMP_TBL)
				.INTO_COLUMNS("book_code", "book_num", "date", "member_id", "cause")
				.INTO_VALUES("#{bookCode}, #{bookNum}, #{date}, #{member_id}, #{cause}")
				.toString();
	}
	
	// 코드로 검색 된 현재 보유 중인 책의 수
	public String countExistByCode(String code) {
		return new SQL().SELECT("count(*)").FROM(BOOK_SINGLE_TBL)
				.WHERE("book_code = #{code}")
				.WHERE("rental = 'n'")
				.toString();
	}
	
	// 코드로 검색 된 전체 책의 수
	public String countAllByCode(String code) {
		return new SQL().SELECT("count(*)").FROM(BOOK_SINGLE_TBL)
				.WHERE("book_code = #{code}")
				.toString();
	}
	
	/// 렌탈 서비스에서 참조	
	// 아무 보유중인 책 번호 하나만 찾기
	public String findExistNum(String code) {
		return new SQL().SELECT("num").FROM(BOOK_SINGLE_TBL)
				.WHERE("book_code = #{code}")
				.WHERE("rental = 'n'")
				.LIMIT(1)
				.toString();
	}
}
