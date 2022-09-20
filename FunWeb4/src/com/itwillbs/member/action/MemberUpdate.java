package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberBean;
import com.itwillbs.member.db.MemberDAO;

public class MemberUpdate implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션값 가져오기
		 HttpSession session=request.getSession();
		 String loginID=(String)session.getAttribute("loginID");
		
		// MemberDAO 객체생성 
		MemberDAO dao=new MemberDAO();
		// 회원정보 조회 - getMember(id) 호출
		MemberBean mb = dao.getMember(loginID);
		
		// 회원정보를 담아서 => update.jsp 이동 정보 저장
		request.setAttribute("mb", mb);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./member/update.jsp");
		forward.setRedirect(false);
		return forward;
	}
	

}
