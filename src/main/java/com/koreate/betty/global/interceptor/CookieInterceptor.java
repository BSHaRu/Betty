package com.koreate.betty.global.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.util.Base64Util;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.model.CookieConst;
import com.koreate.betty.domain.model.SessionConst;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CookieInterceptor implements HandlerInterceptor {

	private final MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute(SessionConst.USER) != null) { return true; }
		
		Cookie cookie = WebUtils.getCookie(request, CookieConst.COOKIE_USER);
		if (cookie != null) {
			String encodedId = cookie.getValue();
			String decodedId = Base64Util.decode(encodedId);
			Member user = memberService.findOne(decodedId);
			session.setAttribute(SessionConst.USER, user);
		}
		return true;
	}
}
