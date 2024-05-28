<%--「スッキリわかるサーブレット＆JSP入門」P300のコード10-15を参考 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	  
	<h2>本棚</h2>

	<div class="sortSearch-container">
		<div class="sortSearch-btn">並べ替え</div>
		<input type="text" class="search-box" placeholder="キーワードを入力">
		<div class="sortSearch-btn">検索</div>
	</div>
    
    <c:if test="${not empty Msg}">
    
      <p><font color="blue"><c:out value="${Msg}" /></font></p>
    
    </c:if> 
    
    <c:if test="${not empty errorMsg}">
    
      <p><font color="red"><c:out value="${errorMsg}" /></font></p>
    
    </c:if> 
    	
    	<table class="bookshelf-table">
		    <tr>
		        <th>タイトル</th>
		        <th>作者</th>
		        <th>読書状況</th>
		    </tr>
		    
		    
		    
		    <c:forEach var="Record" items="${readingRecList}" varStatus="status">
                <tr>
                <form action="?" method="post">
                    <td><c:out value="${Record.title}" /></td>
                    <td><c:out value="${Record.author}" /></td>
                    <td><c:out value="${Record.readStatus}" /></td>
                    
                    <td><button type="submit" formaction="MyPageEdit2">編集</button></td>
		            <td><button type="submit" formaction="DeleteReadingRec">削除</button></td>
                    <input type="hidden" name="LoopIndex" value=<c:out value="${status.index}"/>>
                
                </form>
                </tr>
            </c:forEach>
		</table>
		
	<a href="ReadingRecAdd" class="btn">本を追加</a><br>
	<a href="LogOut" class="logout-btn">ログアウト</a>	

</main>
</body>
</html>