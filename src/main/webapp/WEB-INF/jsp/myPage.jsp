<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <jsp:include page = "head.jsp" />
</head>

<body>
  <header>
    <% //教科書P344～349の動的インクルード %>
    <jsp:include page = "header.jsp" /> 
  </header>
  
  <main>
	  <jsp:include page = "myPageMenu.jsp" />

  	<h3>読書状況</h3>
  	<table class="rounded-table">
	    <tr>
	        <td><b>未登録</b><br> <c:out value="${readStatus.未登録}"/> </td>
	        <td><b>読みたい</b><br> <c:out value="${readStatus.読みたい}"/> </td>
	        <td><b>積読</b><br> <c:out value="${readStatus.積読}"/> </td>
	    </tr>
	    <tr>
	        <td><b>いま読んでいる</b><br> <c:out value="${readStatus.いま読んでいる}"/> </td>
	        <td><b>読み終わった</b><br> <c:out value="${readStatus.読み終わった}"/> </td>
	        <td><b>感想を書いた</b><br> <c:out value="${readStatus.感想を書いた}"/> </td>
	    </tr>
	</table>

    	<h3>友達</h3>
    	<table class="rounded-table">
		    <tr>
		        <td><b>フォロー</b><br>86</td>
		        <td><b>フォロワー</b><br>31</td>
		        <td><b>いいねされた数</b><br>15</td>
		    </tr>
		</table>
    	<h3>今週のランキング</h3>
    	<div class="ranking-content">1位　変な家　雨穴</div>
    	<div class="ranking-content">2位　なぜ働いていると本が読めなくなるのか　三宅香帆</div>
    	<div class="ranking-content">3位　あいにくあんたのためじゃない　柚木麻子</div>
    	<div class="ranking-content">4位　ｓｐｒｉｎｇ　恩田陸</div>
    	<div class="ranking-content">5位　きみのお金は誰のため: ボスが教えてくれた「お金の謎」と「社会のしくみ」　田内学</div>

	<a href="LogOut" class="logout-btn">ログアウト</a>	
  </main>
</body>
</html>
