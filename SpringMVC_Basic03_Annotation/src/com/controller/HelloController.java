package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//@Controller 가지는 클래스 안에서 함수 단위 url-mapping
	//@RequestMapping 사용가능
	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		System.out.println("[hello.do Start]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", getGreeting());
		mv.setViewName("Hello"); //ViewResolver 통해서 조합
		return mv;
	}
	
	//별도의 함수 구현 가능
	private String getGreeting(){
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour >=6 && hour <= 10){
			return "아침";
		}else if(hour >=11 && hour <= 15){
			return "배고픈 시간";
		}else if(hour >= 16){
			return "졸려운 시간";
		}else
			return "go home";
	}
	
}
