package com.koreate.betty.domain.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.koreate.betty.domain.book.dto.BookCommentDTO;
import com.koreate.betty.domain.book.provider.BookCommentProvider;
import com.koreate.betty.domain.book.provider.BookProvider;
import com.koreate.betty.domain.book.vo.BookComment;
import com.koreate.betty.global.util.Criteria;

@Mapper
public interface BookCommentRepository {
	
	@SelectProvider(type=BookCommentProvider.class, method="findCommentByCode")
	public List<BookCommentDTO> findCommentByCode(@Param("code")String code, @Param("cri")Criteria cri);
	
	@SelectProvider(type=BookCommentProvider.class, method="findCommentByCodeCount")
	public int findCommentByCodeCount(String code);
	
	@InsertProvider(type=BookCommentProvider.class, method="insertComment")
	public int insertComment(BookComment bookComment);
	
	@DeleteProvider(type=BookCommentProvider.class, method="deleteComment")
	public int deleteComment(Integer num);
	
}
