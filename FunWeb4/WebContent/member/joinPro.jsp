<%@page import="com.itwillbs.member.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.itwillbs.member.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//member/joinPro.jsp
// request 한글처리
request.setCharacterEncoding("utf-8");
// MemberBean 객체생성
MemberBean mb = new MemberBean();
// id pw name email regdate
mb.setId(request.getParameter("id"));
mb.setPw(request.getParameter("pw"));
mb.setName(request.getParameter("name"));
mb.setEmail(request.getParameter("email"));
mb.setRegdate(new Timestamp(System.currentTimeMillis()));
// MemberDAO 객체생성
MemberDAO dao=new MemberDAO();
// insertMember(mb) 메서드 호출
dao.insertMember(mb);
// login.jsp
response.sendRedirect("login.jsp");
%>
