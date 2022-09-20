package com.itwillbs.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.member.action.MemberInsertAction;
import com.itwillbs.member.action.MemberUpdate;

public class BoardFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println(" GET,POST방식 모두 호출 - doProcess() 실행 ");
		
		System.out.println("\n 1. 가상주소 계산 - 시작");
		// 1. 가상주소 계산------------------------------------------------
		String requestURI = request.getRequestURI();
		System.out.println(" C : requestURI : "+requestURI);
		
		String ctxPath = request.getContextPath();
		System.out.println(" C : ctxPath : "+ctxPath);
		
		String command = requestURI.substring(ctxPath.length());
		System.out.println(" C : command : "+command);						
		// 1. 가상주소 계산------------------------------------------------
		System.out.println(" 1. 가상주소 계산 - 끝 \n");
		
		System.out.println("\n  2. 가상주소 매핑 - 시작");
		// 2. 가상주소 매핑------------------------------------------------
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/BoardWrite.bo")){
			// 글쓰기 페이지 보여주기 (DB정보 필요없음)
			System.out.println(" C : /BoardWrite.bo 호출 ");
			System.out.println(" C : DB정보가 필요없음-view페이지로 이동 ");
			
			forward = new ActionForward();
			forward.setPath("./center/write.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/BoardWriteAction.bo")){
			System.out.println(" C : /BoardWriteAction.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardWriteAction() 객체 생성
			action = new BoardWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BoardList.bo")){
			System.out.println(" C : /BoardList.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardListAction() 객체 생성
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BoardListMain.bo")){
			System.out.println(" C : /BoardListMain.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardListMainAction() 객체 생성
			action = new BoardListMainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BoardContent.bo")){
			System.out.println(" C : /BoardContent.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardContentAction() 객체 생성
			action = new BoardContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BoardUpdate.bo")){
			System.out.println(" C : /BoardUpdate.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardUpdateAction() 객체 생성
			action = new BoardUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BoardUpdateActionPro.bo")){
			System.out.println(" C : /BoardUpdateActionPro.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardUpdateActionPro() 객체 생성
			action = new BoardUpdateActionPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BoardDelete.bo")){
			System.out.println(" C : /BoardDeleteAction.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardDeleteAction() 객체 생성
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BoardListSearch.bo")){
			System.out.println(" C : /BoardListSearch.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// BoardListSearchAction() 객체 생성
			action = new BoardListSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FileBoardWrite.bo")){
			System.out.println(" C : /FileBoardWrite.bo 호출 ");
			System.out.println(" C : DB정보가 필요없음 -view페이지로 이동");
			
			// 첨부파일 있는 글쓰기 화면 보여주기
			forward = new ActionForward();
			forward.setPath("./center/fwrite.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/FileBoardWriteAction.bo")){
			System.out.println(" C : /FileBoardWriteAction.bo 호출 ");
			System.out.println(" C : DB작업 o, 페이지 이동");
			
			// 첨부파일 있는 글쓰기 동작 실행하기
			action = new FileBoardWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("\n  3. 가상주소 이동 - 시작");
		// 3. 가상주소 이동------------------------------------------------
		if(forward != null){
			// 페이지 이동정보가 있을때
			
			if(forward.isRedirect()){
				// true - sendRedirect() 방식으로 이동
				// 주소변경되면서 이동( 가상주소 )
				System.out.println(" C : true-"+forward.getPath()+"이동, sendRedirect() 방식");
				response.sendRedirect(forward.getPath());
				
			}else{
				// false - forward() 방식으로 이동	
				// 주소변동 없이 request값을 가지고 이동 (jsp 페이지 이동)
				System.out.println(" C : false-"+forward.getPath()+"이동, forward() 방식");
				RequestDispatcher dis 
				   = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);					
			}				
			
		}			
		// 3. 가상주소 이동------------------------------------------------		
		System.out.println("\n  3. 가상주소 이동 - 끝");
	
		
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
