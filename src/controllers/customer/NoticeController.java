package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Notice;
import dao.NoticeDao;

//게시물 목록보기
//class 하나가 기능하나 (handleRequest 하나로 처리)

public class NoticeController implements Controller {

	
    private NoticeDao noticedao;
    public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		//게시물 목록보기
		//NoticeDao dao = new NoticeDao();
		//dao.getNotices(page, field, query)
		
		//처리 (가능 : 객체의 참조 : DI setter 주입)
		//noticedao.getNotices(page, field, query)
		
		//검색 처리를 위한 코드
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("q");
		
		System.out.println(_page + "/" + _field + "/"+_query);
		
		//게시판 검색 설정을 위한 기본값 설정
		int page=1;
		String field="TITLE";
		String query="%%";
		
		//조건에 대한 조합
		if(_page != null && !_page.equals("")){
			page = Integer.parseInt(_page);
		}
		if(_field != null && !_field.equals("")){
			field = _field;
		}
		if(_query != null && !_query.equals("")){
			query = _query;
		}
		
		List<Notice> list = noticedao.getNotices(page, field, query);
		
		//SpringMVC(ModelAndView 객체)
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("notice.jsp");
		//view 현재 웹 에서 경로 가져와서 처리 : 
		//http://localhost:8090/SpringMVC_Basic02_WebSite/customer/notice.htm
		
		//내부적으로 forward
		//요청 주소
		//customer/notice.htm => 결과는 주소는 바뀌지 않아요
		//결국 client 는  notice.jsp 내용을 출력
		
		return mv;
	}

}





