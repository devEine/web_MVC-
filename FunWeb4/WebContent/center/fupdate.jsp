<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center/fupdate.jsp</title>
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
<h1>Notice Update</h1>
<form action="./FileBoardUpdateActionPro.bo" method="post" enctype="multipart/form-data">
<!-- 이동 가상 주소 -> 파일 수정 가상주소로 변경, enctype 설정 -->
<input type="hidden" name="bno" value="${dto.bno }">
<input type="hidden" name="pass" value="1234">
<table id="notice">
 <tr><td>글쓴이</td>
     <td><input type="text" name="name" readonly value="${dto.name }"></td></tr>  
 <tr><td>제목</td>
     <td><input type="text" name="subject" value="${dto.subject }"></td></tr>  
     <!-- 파일 수정위해 지정  -->
 <tr><td>파일</td>
     <td><input type="file" name="file">${dto.file }  
     <!-- 파일 수정위해 지정  -->
     	<input type="hidden" name="oldfile" value="${dto.file }"></td></tr>
 <tr><td>내용</td>
     <td><textarea name="content" rows="10" cols="20">${dto.content }</textarea></td></tr>
</table>
<div id="table_search">
<input type="submit" value="글수정" class="btn">
</div>
</form>
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