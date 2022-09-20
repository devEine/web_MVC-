<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center/content.jsp</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/subpage.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Notice</a></li>
<li><a href="#">Public News</a></li>
<li><a href="#">Driver Download</a></li>
<li><a href="#">Service Policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->

<!-- 게시판 -->
<article>
<h1>Notice Content</h1>
<table id="notice">
 <tr><td>글쓴이</td><td>${dto.name }</td></tr>
 <tr><td>글쓴날짜</td><td>${dto.date }</td></tr>
 <tr><td>조회수</td><td>${dto.readcount }</td></tr>  
 <tr><td>제목</td><td>${dto.subject }</td></tr>
 <!-- 파일 첨부  -->  
 <tr><td>파일</td>
     <td><a href="./upload/${dto.file }" download>${dto.file }</a>
     <!-- 파일명에 하이퍼링크 걸어서 누르면 표시되도록 설정 -->
         <img src="./upload/${dto.file }">
         <!-- 화면에 이미지 표시되도록 설정  -->
     </td></tr>  
 <!-- 파일 첨부  -->  
 <tr><td>내용</td><td>${dto.content }</td></tr>
</table>

<div id="table_search">

<c:if test="${sessionScope.loginID eq  dto.name}">
<input type="button" value="글수정" class="btn" 
   onclick="location.href='./BoardUpdate.bo?bno=${dto.bno }'">
   
<input type="button" value="글수정(파일)" class="btn" 
   onclick="location.href='./FileBoardUpdate.bo?bno=${dto.bno }'"> 
   
<input type="button" value="글삭제" class="btn" 
   onclick="location.href='./BoardDelete.bo?bno=${dto.bno }'">
</c:if>

<input type="button" value="글목록" class="btn" onclick="location.href='./BoardList.bo'">
</div>

<div class="clear"></div>
<div id="page_control">
</div>
</article>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>