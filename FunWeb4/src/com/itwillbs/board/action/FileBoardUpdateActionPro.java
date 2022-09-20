package com.itwillbs.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileBoardUpdateActionPro implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//업로드 MultipartRequest객체생성
		// 1. request 정보를 가져옴
		// 2. 파일업로드 할 경로 - upload 물리적인 경로 
		String uploadPath=request.getRealPath("/upload");
		// 3. 파일업로드 최대크기 지정 => 10M 
		int maxSize=10*1024*1024;
		// 4. 한글처리  utf-8
		// 5. 업로드 파일이 동일 이름 일 경우=> 파일이름 변경  
		MultipartRequest multi=new MultipartRequest(request, uploadPath, maxSize, "utf-8",new DefaultFileRenamePolicy());
		
		//BoardDTO 객체생성
		BoardDTO dto=new BoardDTO();
		// 파라미터값 저장
		dto.setBno(Integer.parseInt(multi.getParameter("bno")));
		dto.setPassword(multi.getParameter("password"));
		dto.setName(multi.getParameter("name"));
		dto.setSubject(multi.getParameter("subject"));
		dto.setContent(multi.getParameter("content"));
		// file 
		if(multi.getFilesystemName("file")!=null){
			//수정할 첨부파일 있는 경우
			dto.setFile(multi.getFilesystemName("file"));
		}else{
			//수정할 첨부파일 없는 경우=>기존 oldfile 가져와서 저장
			dto.setFile(multi.getParameter("oldfile"));
		}
		
//		BoardDAO 객체생성
		BoardDAO dao=new BoardDAO();
		// updateBoard(dto)
		int result=dao.updateBoard(dto);
		
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
