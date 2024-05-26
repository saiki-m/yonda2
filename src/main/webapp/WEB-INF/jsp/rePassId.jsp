<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
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
      <h2>本人確認</h2>
      <form action="RePassId" method="post">
        <input type="text" name="name" class="input-field" placeholder="ユーザ名" required>
        <input type="text" name="mailAd" class="input-field" placeholder="メールアドレス" required>
        <input type="text" name="secret_q" class="input-field" placeholder="秘密の質問「はじめて買った本は？」" required><br>
        <button type="submit" class="cert-btn">OK</button>
    </div>
  </main>
  </body>
</html>