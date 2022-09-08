package com.koreate.betty.domain.board.notice;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.koreate.betty.domain.board.dao.NoticeBoardRepository;
import com.koreate.betty.domain.board.dto.form.NoticeBoardForm;
import com.koreate.betty.domain.board.service.NoticeBoardService;
import com.koreate.betty.domain.board.vo.NoticeBoard;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;
import com.koreate.betty.global.util.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class NoticeBoardRepoTest {

	@Autowired
	private NoticeBoardService ns;
	
	NoticeBoardForm form1;
	NoticeBoardForm form2;
	NoticeBoardForm form3;
	NoticeBoardForm form4;

	@Before
	public void init() {
		form1 = new NoticeBoardForm();
		form1.setMemberId("id002");
		form1.setNickname("nick002");
		form1.setTitle("타이틀");
		form1.setContent("콘텐츠");

		form2 = new NoticeBoardForm();
		form2.setBno(1);

		form3 = new NoticeBoardForm();
		form3.setTitle("수정했다");
		form3.setContent("수정했다고");
		form3.setBno(2);

	}
	
	@Autowired
	NoticeBoardRepository repo;
	
	@Test
	public void search() {
		SearchCriteria cri = new SearchCriteria(1, 2, "w", "id001");
		List<NoticeBoard> noticeList = repo.noticeList(cri);
		log.info("cri key : {}", cri.getKeyword());
		log.info("cri type : {}", cri.getSearchType());
		System.out.println(" -- cri는 : " + cri);
		for(NoticeBoard vo : noticeList) {
			log.info("cri vo : {}" , vo.getMemberId());
			System.out.println(" -- cri vo는 : " + vo);
			System.out.println(" -- cri vo id는 : " + vo.getMemberId());
			System.out.println(" -- cri vo title는 : " + vo.getTitle());
		}
	}
	
//	@Test
	public void add() {
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		ns.write(form1);
		
		log.info("count={}", repo.listAllCount(new SearchCriteria()));
		
	}

	// @Test
	public void remove() {
		int t = ns.remove(2);
		log.info("t={}", t);
	}

	// @Test
	public void modify() {
		// int t = ns.update(2);
		// log.info("t={}",t);
	}

}
