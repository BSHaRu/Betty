package com.koreate.betty.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.model.PathConst;
import com.koreate.betty.domain.model.SessionConst;
import com.koreate.betty.global.resolver.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		String path = request.getServletContext().getContextPath();
		HttpSession session = request.getSession(false);
		Member user = (Member)session.getAttribute(SessionConst.USER);
		
		
		if(session == null || user == null) {
			response.sendRedirect(path+"/sign/in?redirectURL="+uri);
			return false;
		}
		
		int right = user.getRights();
		String area = uri.substring(path.length());
		
		
		boolean memberPath = area.startsWith(PathConst.MEMBERS);  
		boolean staffPath = area.startsWith(PathConst.STAFF);
		boolean adminPath = area.startsWith(PathConst.ADMIN);  
		boolean offlinePath = area.startsWith(PathConst.OFFLINE);
		boolean isMember = (right == 0);
		boolean isStaff = (right == 2);
		boolean isAdmin = (right == 3);
		
		if(offlinePath || memberPath && isMember) {
			String pathVariable = uri.split("/")[3];
			if(!user.getId().equals(pathVariable)) {
				request.setAttribute("message", "요청 실패");
				response.sendRedirect(path);
				return false;
			}
		}
		
		if(memberPath && !isMember) {
			request.setAttribute("message", "일반회원만 접근할 수 있습니다.");
			response.sendRedirect(path);
			return false;
		} else if (staffPath && !isStaff) {
			request.setAttribute("message", "직원회원만 접근할 수 있습니다.");
			response.sendRedirect(path);
			return false;
		} else if(offlinePath && !isMember) {
			request.setAttribute("message", "일반회원만 접근할 수 있습니다.");
			response.sendRedirect(path);
			return false;
		} else if(adminPath && !isAdmin) {
			request.setAttribute("message", "관리자만 접근할 수 있습니다.");
			response.sendRedirect(path);
			return false;
		}
			
		request.setAttribute("nav", uri.split("/")[2]);
		return true;
	}

	
	
}
