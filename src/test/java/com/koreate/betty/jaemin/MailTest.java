package com.koreate.betty.jaemin;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.EmailConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class, RootConfig.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MailTest {
	
		@Test
		public void context_load() {
		}
		
		
		@Data
		@Configuration
		@PropertySource("classpath:mail.properties")
		static class MailProperties {

			@PostConstruct
			public void init() {
				log.info("host={}", host);
				log.info("username={}", username);
				log.info("password={}", password);
				log.info("port={}", port);
			}
			
		    // SMTP 서버
			@Value("${host}")
		    private String host;

		    // 계정
			@Value("${username}")
		    private String username;

		    // 비밀번호
			@Value("${password}")
		    private String password;

		    // 포트번호
			@Value("${port}")
		    private int port;

		}
	
}
