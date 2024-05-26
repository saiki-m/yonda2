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
    <div class="cert-container">
      <h2>ログイン</h2>
      <form action="Login" method="post">
        <input type="text" name="name" class="input-field" placeholder="ユーザ名">
        <input type="password" name="password" class="input-field" placeholder="パスワード"><br>
        <button type="submit" class="cert-btn">OK</button>
      </form>
      <br>
      <a href="rePassId.jsp">パスワードを忘れた場合はこちら</a>
    </div>
    
  </main>
  </body>
</html>