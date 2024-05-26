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
      <h2>新規登録</h2>
      <p><font color="red">すべての項目を正しく入力してください</font>
      	<form action="AccountEntry" method="post">
	        <input type="text" name="name" class="input-field" placeholder="ユーザ名">
	        <input type="password" name="password" class="input-field" placeholder="パスワード">
	        <input type="text" name="mailAd" class="input-field" placeholder="メールアドレス">
	        <input type="text" name="secret_q" class="input-field" placeholder="秘密の質問「はじめて買った本は？」"><br>
	        <button type="submit" class="cert-btn">OK</button>
        </form>
    </div>
  </main>
  </body>
</html>
