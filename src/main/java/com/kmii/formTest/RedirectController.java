package com.kmii.formTest;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "/studentInput")
	public String studentInput() {
		return "studentInput";
	}
	
	
	@RequestMapping(value = "/studentCheck")
	public String studentCheck(@RequestParam("sid") String sid, Model model, HttpServletResponse response) {
		
		if(sid.endsWith("tiger")) {
			return "redirect:studentGo";  // redirect넣어주면 stduentGood 요청이 들어감 -> sid값 싫어서 jsp로보냄 / 밑에있는 studentgood요청으로 간다(jsp파일x)
			//return "studentGood"; 		  // 그냥 jsp파일 오픈
		} else {
			return "redirect:studentNg"; 
			//return "studentNg;
		}
			
	}
	
	
	@RequestMapping(value = "/studentGo")
	public String studentGood(Model model) {
		model.addAttribute("sid", "tiger");
		
		return "studentGood";
	}
	
	@RequestMapping(value = "/studentNg")
	public String studentNg(Model model) {
		model.addAttribute("sid", "tiger");
		
		return "studentNg";
	}
	
	
	
	

}
