<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/front.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="./script/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('.brown').click(function(){
// 			alert("클릭");
			$.ajax({
				url:'./BoardListMain.bo',
				dataType:'json',
				success:function(rdata){
					$.each(rdata,function(index,item){
$('table').append('<tr><td class="contxt"><a href="#">'+item.subject+'</a></td><td>'+item.date+'</td></tr>');						
					});
				}
			});
			$(this).unbind();
		});
	});
</script>
</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src="./images/main_img.jpg"
 width="971" height="282"></div>
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">
<div id="hosting">
<h3>Web Hosting Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="security">
<h3>Web Security Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="payment">
<h3>Web Payment Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
</div>
<div class="clear"></div>
<div id="sec_news">
<h3><span class="orange">Security</span> News</h3>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
</div>
<div id="news_notice">
<h3 class="brown">News &amp; Notice</h3>
<table>
<!-- <tr><td class="contxt"><a href="#">Vivans....</a></td> -->
<!--     <td>2012.11.02</td></tr> -->
<!-- <tr><td class="contxt"><a href="#">Vivans....</a></td> -->
<!--     <td>2012.11.02</td></tr> -->
<!-- <tr><td class="contxt"><a href="#">Vivans....</a></td> -->
<!--     <td>2012.11.02</td></tr> -->
<!-- <tr><td class="contxt"><a href="#">Vivans....</a></td> -->
<!--     <td>2012.11.02</td></tr> -->
<!-- <tr><td class="contxt"><a href="#">Vivans....</a></td> -->
<!--     <td>2012.11.02</td></tr> -->
</table>
</div>
</article>
<!-- 메인 콘텐츠 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>