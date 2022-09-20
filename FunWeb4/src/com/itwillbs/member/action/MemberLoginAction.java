package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberBean;
import com.itwillbs.member.db.MemberDAO;

public class MemberLoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// MemberBean 객체생성
		MemberBean mb = new MemberBean();
		// id pw 
		mb.setId(request.getParameter("id"));
		mb.setPw(request.getParameter("pw"));

		//MemberDAO 객체
		MemberDAO dao = new MemberDAO();
		// 로그인 체크 기능-loginMember() 
		int result = dao.loginMember(mb);
		 if(result==0){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호 오류!');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				return null;
		 }else if(result==-1){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('아이디 오류!');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				return null;
		 }else{
			 //아이디 비밀번호 일치
			 //세션값 생성
			 HttpSession session=request.getSession();
			 session.setAttribute("loginID", mb.getId());
			//페이지 이동정보 저장(리턴)
			ActionForward forward = new ActionForward();
			forward.setPath("./Main.me");
			forward.setRedirect(true);
			return forward;
		 }
	}

}
