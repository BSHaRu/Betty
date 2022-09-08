package com.koreate.betty.domain.board.suggest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.koreate.betty.domain.board.dto.form.SuggestBoardForm;
import com.koreate.betty.domain.board.service.SuggestBoardService;
import com.koreate.betty.domain.board.vo.SuggestBoard;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class SuggestBoardRepoTest {
	
	@Autowired
	private WebApplicationContext wc;
	
	@Autowired
	private SuggestBoardService ss;
	
	SuggestBoardForm form1;
	SuggestBoardForm form2;
	SuggestBoardForm form3;
	
	@Before
	public void init() {
		form1 = new SuggestBoardForm();
		form1.setMemberId("id001");
		form1.setTitle("dadf");
		form1.setContent("sdfsdfsdf");
		
		form2 = new SuggestBoardForm();
		form2.setMemberId("id002");
		form2.setTitle("답글이다");
		form2.setContent("답글이다");
		form2.setDepth(1);
		
	}
	
	
	@Test
	@Transactional
	public void registTest() {
	 	int result = ss.suggestWrite(form1);
		log.info("result={}",result);
		System.out.println("=============="+result);
	}
	
	@Test
	public void replyTest() {
	}
	
	//@Test
	public void test() {
		SuggestBoardForm form = new SuggestBoardForm();
		
		System.out.println(form.suggestBoard());
	}
	
	
}
