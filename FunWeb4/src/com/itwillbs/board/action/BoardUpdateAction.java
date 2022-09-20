package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class BoardUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno=Integer.parseInt(request.getParameter("bno"));
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		//메서드 호출
		BoardDTO dto=dao.getBoard(bno);
		// 데이터 저장 => 이동할정보 저장
		request.setAttribute("dto", dto);
		
		ActionForward forward=new ActionForward();
		forward.setPath("./center/update.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
