package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberBean;
import com.itwillbs.member.db.MemberDAO;

public class MemberIdcheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//member/idcheck.jsp
		// 'id':$('.id').val()
		String id=request.getParameter("id");
		// MemberDAO 객체생성
		MemberDAO dao=new MemberDAO();
		// getMember(id) 메서드호출
		MemberBean mb=dao.getMember(id);
		String result="";
		if(mb.getId()!=null){
			//아이디 있음, 아이디 중복
			result="아이디 중복";
		}else{
			//아이디 없음, 아이디 사용가능
			result="아이디 사용가능";
		}
		
		//결과 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(result);
//		out.println("<script>");
//		out.println("alert('자바스크립트')");
//		out.println("</script>");
		out.close();
		
		// 이동 없음
		return null;
	}

}
