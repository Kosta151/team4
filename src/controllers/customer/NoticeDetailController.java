package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeDetailController implements Controller{
	private NoticeDao noticedao;
    public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest requset,
			HttpServletResponse response) throws Exception {
		String seq = requset.getParameter("seq");
		
		System.out.println(seq);
		
		Notice notice = noticedao.getNotice(seq);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("notice", notice);
		mv.setViewName("noticeDetail.jsp");
		
		return mv;
	}

}
