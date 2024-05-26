<%--「スッキリわかるサーブレット＆JSP入門」P300のコード10-15を参考 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% //P366、P449参考  urlではなくuri%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import="beans.ReadingRecBean" %>
<%@ page import="java.util.List"%>
    
<%
//Login.javaでセッションスコープに保存したデータを取得
 List<ReadingRecBean> readingRecList = (List<ReadingRecBean>)session.getAttribute("readingRecList");
%>

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
  
	  <div class="top-container">
	  	<a href="myPage.jsp"><img src="./img/myicon.png" alt="マイページ"></a>
	  	
	  	<% //P366、P449参考  %>
	  	<h3><c:out value="${account.name}" />さん</h3>
	  
    	<a href="bookShelf.jsp" class="btn">本棚</a>
    	<a href="profile.jsp" class="btn">プロフィール</a>
	  </div>
	  
	<h2>本棚</h2>

	<div class="sortSearch-container">
		<div class="sortSearch-btn">並べ替え</div>
		<input type="text" class="search-box" placeholder="キーワードを入力">
		<div class="sortSearch-btn">検索</div>
	</div>

    	
    	<table class="bookshelf-table">
		    <tr>
		        <th>タイトル</th>
		        <th>作者</th>
		        <th>読書状況</th>
		    </tr>
		    
		    <!-- 
		    <tr>
		        <td><a href="readingRec.jsp">容疑者Xの献身</a></td>
		        <td>東野圭吾</td>
		        <td>感想を書いた</td>
		    </tr>
		    -->
		    
		    <%-- dbフォルダ内の「ReadingStatus.sql」のVALUESが表示される --%>
		    <%for(ReadingRecBean book : readingRecList){ %>
	            <tr>
	                <td><%=book.getTitle()%></td>
	                <td><%=book.getAuthor()%></td>
	                <td><%=book.getReadStatus()%></td>
		        </tr>
	        <% } %>
		    
		</table>
		
	<a href="ReadingRecAdd" class="btn">本を追加</a><br>
	<a href="LogOut" class="logout-btn">ログアウト</a>	

</main>
</body>
</html>