<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/update.jsp</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/subpage.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./script/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#join').submit(function(){
// 			alert("전송");
			if($('.id').val()==""){
				alert('아이디 입력하세요');
				$('.id').focus();
				return false;
			}
			if($('.pw').val()==""){
				alert('비밀번호 입력하세요');
				$('.pw').focus();
				return false;
			}
			if($('.name').val()==""){
				alert('이름 입력하세요');
				$('.name').focus();
				return false;
			}
			if($('.email').val()==""){
				alert('이메일 입력하세요');
				$('.email').focus();
				return false;
			}
		});//
		
		
	});//
</script> 
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 본문메인이미지 -->
<div id="sub_img_member"></div>
<!-- 본문메인이미지 -->
<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Join us</a></li>
<li><a href="#">Privacy policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
<article>
<h1>Update Us</h1>
<form action="./MemberUpdateAction.me" id="join" method="post">
<fieldset>
<legend>Basic Info</legend>
<label>User ID</label>
<input type="text" name="id" class="id" readonly value="${mb.id }"><br>
<label>Password</label>
<input type="password" name="pw" class="pw"><br>
<label>Name</label>
<input type="text" name="name" class="name" value="${mb.name }"><br>
<label>E-Mail</label>
<input type="email" name="email" class="email" value="${mb.email }"><br>
</fieldset>

<fieldset>
<legend>Optional</legend>
<label>Address</label>
<input type="text" name="address"><br>
<label>Phone Number</label>
<input type="text" name="phone"><br>
<label>Mobile Phone Number</label>
<input type="text" name="mobile"><br>
</fieldset>
<div class="clear"></div>
<div id="buttons">
<input type="submit" value="Submit" class="submit">
<input type="reset" value="Cancel" class="cancel">
</div>
</form>
</article>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->

<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>