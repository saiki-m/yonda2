<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //教科書P366、P449参考  %>
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
    <div class="cert-container">
      <h2>新規登録</h2>
          <c:if test="${not empty errorMsg}">
            <p><font color="red"><c:out value="${errorMsg}" /></font></p>
          </c:if>
      	<form action="EntryAccount" method="post">
	        <input type="text" name="name" class="input-field" placeholder="ユーザ名" required>
	        <input type="password" name="password" class="input-field" placeholder="パスワード" required>
	        <input type="email" name="mailAd" class="input-field" placeholder="メールアドレス" required>
	        <input type="text" name="secret_q" class="input-field" placeholder="秘密の質問「はじめて買った本は？」" required><br>
	        <button type="submit" class="cert-btn">OK</button>
        </form>
    </div>
  </main>
  </body>
</html>
