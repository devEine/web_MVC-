package com.itwillbs.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberBean;
import com.itwillbs.member.db.MemberDAO;

public class MemberInsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberInsertAction_execute() 호출 ");
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 전달정보 저장
		// MemberBean 객체 생성
		MemberBean dto = new MemberBean();
		
		// id pw name email regdate
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setRegdate(new Timestamp(System.currentTimeMillis()));
		
		System.out.println(" M : "+dto);
		
		// DB에 정보 저장
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		
		// DB에 글정보를 저장
		dao.insertMember(dto);
		
		//페이지 이동정보 저장(리턴)
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true);
		
		return forward;
	}

}
