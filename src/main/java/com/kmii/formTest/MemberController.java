package com.kmii.formTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, Model model) {  // 두객체는 사용하지 않아도 미리 써놓는게 좋다 (HttpServletRequest request, Model model)
		return "login";
	}
	
	@RequestMapping(value="/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response) {
		
		String mid = request.getParameter("mid");   // 클라이언트가 입력한 아이디값 불러오기
		String mpw = request.getParameter("mpw");   // 클라이언트가 입력한 비밀번호값 불러오기
		model.addAttribute("id",mid);

		if(mid.equals("admin") && mpw.equals("12345")) {  // 참이면 로그인 성공
			session.setAttribute("sid", mid);  // 세션에 로그인한 아이디 올리기
			return "loginOk";
		} else {
			return "loginFail";
		}
		
		
		
	}

}
