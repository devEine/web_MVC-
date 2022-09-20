package com.itwillbs.board.action;

import java.io.ObjectInputStream.GetField;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileBoardWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : FileBoardWriteAction_execute() 호출 ");
		// 파일 업로드  프로그램 설치 => cos.jar
		// http://www.servlets.com/cos/
		// 다운 => 압축풀기 => cos-22.05\lib 폴더 안에 cos.jar
		// 설치 => WEB-INF / lib / cos.jar
		// cos.jar 파일 안에  MultipartRequest 객체생성
		// 1. request 정보를 가져옴
		// 2. 파일업로드 할 경로 - upload 물리적인 경로 
		String uploadPath=request.getRealPath("/upload");
/*//		D:\workspace_jsp\.metadata\.plugins\org.eclipse.wst.server.core
//		\tmp0\wtpwebapps\FunWeb2\ upload	 => 삽입한 이미지 파일 확인 가능 
*/		// 3. 파일업로드 최대크기 지정 => 10M 
		int maxSize=10*1024*1024;
		// 4. 한글처리  utf-8
		// 5. 업로드 파일이 동일 이름 일 경우=> 파일이름 변경  
		MultipartRequest multi=new MultipartRequest(request, uploadPath, maxSize, "utf-8",new DefaultFileRenamePolicy());
		
		// 전달정보 저장(제목,비밀번호,이름,내용)
		// BoardDTO 객체 생성
		BoardDTO dto = new BoardDTO();
		
		dto.setName(multi.getParameter("name"));
		dto.setPassword(multi.getParameter("password"));
		dto.setSubject(multi.getParameter("subject"));
		dto.setContent(multi.getParameter("content"));
		//file => 업로드 된 파일이름
		dto.setFile(multi.getFilesystemName("file"));
		
		// IP주소 추가
		dto.setIp(request.getRemoteAddr());
		
		System.out.println(" M : "+dto);
		
		// DB에 정보 저장
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();

		// DB에 글정보를 저장
		dao.boardWrite(dto);

		// 페이지 이동정보 저장(리턴)
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true);

		return forward;
	}
}
