package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.NewArticleCommand;
import com.service.ArticleService;

@Controller
@RequestMapping("/article/newArticle.do") //GET , POST
public class NewArticleController {
   //하나의 요청 주소로 : 2가지 (GET , POST)	
   //글쓰기 , 글쓰기 완료
   //GET , POST (form method="post") 외는 다 GET 방식	
   //같은 URL :  GET (Form 화면) , POST (입력 처리)
	
   //GET 화면 처리
   @RequestMapping(method=RequestMethod.GET)
   public String form(){
	   System.out.println("GET 방식에 대한 요청 처리 함수");
	   
	   return "article/newArticleForm";
	   //  /WEB-INF/view/ + [ ] + .jsp
	   //  forward 방식으로 ..
   }
   
   ////////////////////////////////////////
   //Controller (요청) -> Service -> ..
   private ArticleService articleservice;
   @Autowired
   public void setArticleservice(ArticleService articleservice) {
	   this.articleservice = articleservice;
   }

   /*
    1. form 태그 : title , content > request.getParameter("title")
    2. ArticleService 서비스 객체의 > writeArticle 함수 실행
    3. 결과 보여주기   
    
    submit(NewArticleCommand command)
    Parameter : dto 객체 사용 
    
    전제 조건 : parameter 명이  dto 의 멤버변수명과 동일
    자동 setter 자동 자동 dto 객체 생성 데이터 처리 
   */
   @RequestMapping(method=RequestMethod.POST)
   	   //public String submit(NewArticleCommand command){
	   //NewArticleCommand command = new NewArticleCommand();
	   //command.setTitle(request.getParameter("title"))
	   //위 두줄 생략
   
   		//@ModelAttribute("Articledata")
   		//나는 자동으로 객체 만들어지고 이름 부여하는 것 반대
   		//내가 객체의 이름을 부여하겠다.
   public String submit(@ModelAttribute("Articledata")NewArticleCommand command){
	   System.out.println("submit");
	   System.out.println("전송방식 : post");
	   System.out.println("command (dto) : " + command.toString());
	
	   System.out.println("service : " + articleservice);
	   articleservice.writeArticle(command); //DB Insert 가정
	   
	   
	   return "article/newArticleSubmitted";
   }
	
}





