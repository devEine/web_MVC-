package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class BoardWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BoardWriteAction_execute() 호출 ");
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 전달정보 저장(제목,비밀번호,이름,내용)
		// BoardDTO 객체 생성
		BoardDTO dto = new BoardDTO();
		
		dto.setName(request.getParameter("name"));
		dto.setPassword(request.getParameter("password"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		// postcode address  address2  address3 파라미터 가져오기
		// dto 멤버변수 정의 <= 저장
		
		// IP주소 추가
		dto.setIp(request.getRemoteAddr());
		
		System.out.println(" M : "+dto);
		
		// DB에 정보 저장
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		// DB에 글정보를 저장
		// insert postcode address  address2  address3 저장
		dao.boardWrite(dto);
		
		//페이지 이동정보 저장(리턴)
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true);
		
		return forward;
	}
}
