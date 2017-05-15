package com.service;

import org.springframework.stereotype.Service;

import com.model.NewArticleCommand;


/*
 @Service 을 사용한다면 bean 생성하는 코드 생략
 단 (반드시) : <context:component-scan base-package="com.service"/>
  
 */



public class ArticleService {
	
	public ArticleService(){
		System.out.println("ArticleService 생성자 호출");
	}
	
	//controller -> service -> dao(dto) 리턴
	public void writeArticle(NewArticleCommand command){
		//DAO 객체 생성
		//DAO 객체 함수 호출(insert 함수 실행)
		
		System.out.println("신규 글쓰기 작업 완료 :" +command.toString());
	}
}
