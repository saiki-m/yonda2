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
    <jsp:include page = "./WEB-INF/jsp/header.jsp" /> 
  </header>
  <main>
    <div class="center-container">
      <p>読書がもっと好きになる</P>
      <div class="home-icon">
        <img src="./img/nokosu.png" alt="記録">
        <img src="./img/sagasu.png" alt="検索">
        <img src="./img/tsunagaru.png" alt="フォロー">
      </div>
      <p>
        <a href="Login" class="btn">ログイン</a>
        <a href="EntryAccount" class="btn">新規登録</a>
      </p>
    </div>
  </main>
  
  </body>
</html>
