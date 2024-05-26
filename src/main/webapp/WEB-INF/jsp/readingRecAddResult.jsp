<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  	<h3>${account.name}さん</h3>
    	<a href="BookShelf" class="btn">本棚</a>
    	<a href="Profile" class="btn">プロフィール</a>
	  </div>
    
    <div class="center-container">
      <p>本の追加完了</P>
    </div>
  </main>
</body>
</html>