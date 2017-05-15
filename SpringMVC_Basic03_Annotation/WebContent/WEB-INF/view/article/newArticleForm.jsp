<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		why : action ="/article/newArticle.do"를 명시하지 않았을까
		
		명시하지 않아도  
		현재 주소창에 아래처럼 .... 주소를 갖고 있으면
		http://localhost:8090/SpringMVC_Basic03_Annotation/article/newArticle.do
		
		/article/newArticle.do 자동으로 action 값이 된다.
	 -->
	<h3>게시판 글쓰기 입력 폼</h3>
	<h3>Form 태그에 action이 없으면 submit 주소: url 창 값</h3>
	<form method="post">
		<input type="hidden" name="parentId" value="0">
		제목 : <input type="text" name="title"><br>
		내용 : <input type="text" name="content"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>