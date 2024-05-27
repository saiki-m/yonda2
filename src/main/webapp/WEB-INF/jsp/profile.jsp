<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<% //P366、P449参考  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>yonda！</title>
</head>

<body>
  <header>
    <jsp:include page = "header.jsp" /> 
  </header>
  
  <main>
    <jsp:include page = "myPageMenu.jsp" />
	  
    	<h2>プロフィール</h2>

    	<table class="bookshelf-table">
		    <tr>
		        <th>生年月日</th>
		        <td>1990/1/1</td>
		    </tr>
		    <tr>
		        <th>性別</th>
		        <td>男</td>
		    </tr>
		    <tr>
		        <th>職業</th>
		        <td>会社員</td>
		    </tr>
		    <tr>
		        <th>在住都道府県</th>
		        <td>熊本県</td>
		    </tr>
		    <tr>
		        <th>パーソナルタグ</th>
		        <td>#文学青年#歴史#SE</td>
		    </tr>
		    <tr>
		        <th>興味のあるジャンル</th>
		        <td>ミステリー/海外/古典</td>
		    </tr>
		    <tr>
		        <th>好きな作家</th>
		        <td>東野圭吾</td>
		    </tr>
		    <tr>
		        <th>お気に入りベスト3</th>
		        <td>容疑者Xの献身/沈黙/星の王子さま</td>
		    </tr>
		</table>
		
		<a href="Profile?edit=done" class="btn">編集</a><br>
		<a href="LogOut" class="logout-btn">ログアウト</a>
		
</main>
</body>
</html>