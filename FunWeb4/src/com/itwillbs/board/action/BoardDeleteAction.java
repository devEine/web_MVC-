package com.itwillbs.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class BoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//BoardDTO 객체생성
		BoardDTO dto=new BoardDTO();
		// 파라미터값 저장
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setPassword("1234");
		
//		BoardDAO 객체생성
		BoardDAO dao=new BoardDAO();
		// updateBoard(dto)
		int result=dao.deleteBoard(dto);
		
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
			out.println("alert('글 없음!');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
	 }else{
			// 이동 
//			/BoardList.bo
			ActionForward forward=new ActionForward();
			forward.setPath("./BoardList.bo");
			forward.setRedirect(true);
			return forward;
	 }

	}

}
