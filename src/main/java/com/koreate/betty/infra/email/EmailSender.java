package com.koreate.betty.infra.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.koreate.betty.domain.member.vo.Inquiry;
import com.koreate.betty.global.error.exception.MessageException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@PropertySource("classpath:/mail.properties")
public class EmailSender {
	
	private final JavaMailSender mailSender;

	@Value("${mail.username}")
	private String adminEmail;

	public void send(String email, String code) {
		try {
			MimeMessage mesage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mesage, "UTF-8");
			helper.setFrom(adminEmail);
			helper.setTo(email);
			helper.setSubject("이메일 인증 코드 확인");
			helper.setText("인증 번호 [" + code + "]", true);
			System.out.println("이메일 인증 코드" + code);
			mailSender.send(mesage);
		} catch (MessagingException e) {
			throw new MessageException(e);
		}
	}
	
	public void inquiry(Inquiry inquiry) {
		String id = inquiry.getMemberId();
		String title = inquiry.getTitle();
		String content = inquiry.getContent();
		
		try {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");
		helper.setFrom(adminEmail); 
		helper.setTo(adminEmail);
		helper.setSubject(String.format("[betty 이메일 문의] %s님의 %s",id,title));
		helper.setText(content, true);
		mailSender.send(message);
		} catch (MessagingException e) {
			throw new MessageException(e);
		}
		
	}

}
