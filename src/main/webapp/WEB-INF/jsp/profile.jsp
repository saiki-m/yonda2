<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<% //P366、P449参考  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <jsp:include page = "head.jsp" />
</head>

<body>
  <header>
    <jsp:include page = "header.jsp" /> 
  </header>
  
  <main>
    <jsp:include page = "myPageMenu.jsp" />
		  
    	<h2>プロフィール</h2>
    	
    	<c:if test="${not empty Msg}">
    	      <p><font color="blue"><c:out value="${Msg}" /></font></p>
		</c:if>
        
    	<table class="bookshelf-table">
    	
    		
		    <tr>
		        <th>生年月日</th>
		        <td><c:out value="${profile.birthday}" /></td>
		    </tr>
		    <tr>
		        <th>性別</th>
		        <td><c:out value="${profile.gender}" /></td>
		    </tr>
		    <tr>
		        <th>職業</th>
		        <td><c:out value="${profile.profession}" /></td>
		    </tr>
		    <tr>
		        <th>在住都道府県</th>
		        <td><c:out value="${profile.prefectures}" /></td>
		    </tr>
		    <tr>
		        <th>パーソナルタグ</th>
		        <td><c:out value="${profile.keyword}" /></td>
		    </tr>
		    <tr>
		        <th>興味のあるジャンル</th>
		        <td><c:out value="${profile.genru}" /></td>
		    </tr>
		    <tr>
		        <th>好きな作家</th>
		        <td><c:out value="${profile.author}" /></td>
		    </tr>
		    <tr>
		        <th>お気に入り1位</th>
		        <td><c:out value="${profile.book_1}" /></td>
		    </tr>
		    <tr>
		        <th>お気に入り2位</th>
		        <td><c:out value="${profile.book_2}" /></td>
		    </tr>
		    <tr>
		        <th>お気に入り3位</th>
		        <td><c:out value="${profile.book_3}" /></td>
		    </tr>
		</table>
		
		<a href="EditProfile" class="btn">編集</a><br>
		<a href="LogOut" class="logout-btn">ログアウト</a>
		
</main>
</body>
</html>