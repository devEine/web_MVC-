package com.itwillbs.board.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.itwillbs.board.db.BoardDAO;
import com.itwillbs.board.db.BoardDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class BoardListMainAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
System.out.println(" M : BoardListMainAction_execute() 호출");
		
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		// 페이징 처리----------------------------------------
		
		// 한 페이지에 보여줄 글의 개수 설정 
		// 5개 가져오기
		String urlPageSize = "5";
		int pageSize = Integer.parseInt(urlPageSize);
		
		// 현 페이지가 몇번째 페이지인지 계산
		//  >> 페이지 정보가 없을경우 항상 1페이지
		// 1페이지 
		String pageNum = "1";
		// 시작하는 행번호 1
		int startRow=1;
		
		// 페이징 처리----------------------------------------
		
		//최근글 5개 가져오기(1행부터 5개 글 가져오기)
		// dao 메서드 중에서  게시판 글정보를 모두 가져오는 메서드 호출
		//List<BoardDTO> boardList = dao.getBoardList(); 
		List<BoardDTO> boardList = dao.getBoardList(startRow,pageSize); 
		
		System.out.println(" M : 게시판 글정보 저장완료! ");
		
		// 페이징 처리 2(하단 페이지 링크)---------------------------------------
		// Json 변경해서 출력
		JSONArray boardList2=new JSONArray();
		for(int i=0;i<boardList.size();i++){
			BoardDTO dto=boardList.get(i);
			
			JSONObject dto2=new JSONObject();
			dto2.put("bno", dto.getBno());
			dto2.put("subject", dto.getSubject());
			//날짜를 패턴에 맞게 문자로 변경해서 저장  yyyy.MM.dd
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
			dto2.put("date", dateFormat.format(dto.getDate()));
			
			// 하나의 글을 => 배열 한칸에 저장
			boardList2.add(dto2);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(boardList2);
		out.close();
		
		return null;
	
	}
}
