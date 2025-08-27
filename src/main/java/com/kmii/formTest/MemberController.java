package com.kmii.formTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, Model model) {  // 두객체는 사용하지 않아도 미리 써놓는게 좋다 (HttpServletRequest request, Model model)
		return "login";
	}
	
	@RequestMapping(value="/login2")
	public String login2(HttpServletRequest request, Model model) {  // 두객체는 사용하지 않아도 미리 써놓는게 좋다 (HttpServletRequest request, Model model)
		return "login2";
	}
	
	@RequestMapping(value="/join")
	public String join(HttpServletRequest request, Model model) {  // 두객체는 사용하지 않아도 미리 써놓는게 좋다 (HttpServletRequest request, Model model)
		return "join";
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
		
	@RequestMapping(value="/loginOk2")
	public String loginOk2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpSession session, HttpServletResponse response) {
			
//		String mid = request.getParameter("mid");   // 위에 @request~("mid") 넣어줘서 밑에 따로 안써줘도 된다
//		String mpw = request.getParameter("mpw");   // 위에 @request~("mpw") 넣어줘서 밑에 따로 안써줘도 된다
		model.addAttribute("id",mid);

		if(mid.equals("admin") && mpw.equals("12345")) {  // 참이면 로그인 성공
			session.setAttribute("sid", mid);  // 세션에 로그인한 아이디 올리기
			return "loginOk";
		} else {
			return "loginFail";
	
	}
		
		
	}
	
	//파마미터 이름없이 전달되는 값 받아올때 / ex) 페이지번호
	@RequestMapping(value="/boardlist/{bnum}")
	public String boardlist(@PathVariable String bnum, Model model) {  // 파라미터 이름 없이 전달된 값받아오기
		model.addAttribute("bnum",bnum);
		
		
		return "boardlist";
	}
	
	
	//post방식으로 넘어올때 처리
	@RequestMapping(value="/joinOk", method = RequestMethod.POST)  // join에서 get방식으로으로넘어오면 에러
	public String loginOk(MemberDto memberDto, Model model) {   
		// memberDto 넣으면 밑에 5즐모두 생략가능(넘어 오는 파라미터값과 DTO의 멤버변수 이름이 같아야함)
	//public String loginOk(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw,@RequestParam("mname") String mname,@RequestParam("mage") String mage)	
		
		
//		String mid = request.getParameter("mid");
//		String mpw = request.getParameter("mpw");
//		String mname = request.getParameter("mname");
//		String mage = request.getParameter("mage");
//		
//		MemberDto memberDto = new MemberDto(mid, mpw, mname, mage);
		
		model.addAttribute("memberDto",memberDto);
		
		return "joinOk";
	}
	
	//get방식으로 넘어올때 처리  // 위에랑 똑같은 요청이지만 방식을 다르게해서 - 다른 결과값을 낼 수 있다. / 여러개 결과값을 낼 수 있다.
	@RequestMapping(value="/joinOk", method = RequestMethod.GET) 
	public String loginOk2(MemberDto memberDto, Model model) {   
		// memberDto 넣으면 밑에 5즐모두 생략가능(넘어 오는 파라미터값과 DTO의 멤버변수 이름이 같아야함)
	//public String loginOk(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw,@RequestParam("mname") String mname,@RequestParam("mage") String mage)	
		
		
//		String mid = request.getParameter("mid");
//		String mpw = request.getParameter("mpw");
//		String mname = request.getParameter("mname");
//		String mage = request.getParameter("mage");
//		
//		MemberDto memberDto = new MemberDto(mid, mpw, mname, mage);
		
		model.addAttribute("memberDto",memberDto);
		
		return "joinOk";
	}
	
	
	
  // modelattribute - > 긴이름 줄일수도 있고, 밑에 model.~ 이거 안써줘도 된다.
	@RequestMapping(value="/student") 
	public String studentInfo(@ModelAttribute("sInfo") StudentInfomationDto studentInfomationDto, Model model) {   

		
		// model.addAttribute("Dto",studentInfomationDto);   // 위에서 @ModelAttribute("sInfo")가 대신해준다 - ok.jsp에서 줄여서 쓸 수 있다
		
		return "studentOk";
	}
	
	
	

}
