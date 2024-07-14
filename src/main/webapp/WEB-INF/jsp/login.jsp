<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% //教科書P366、P449参考  %>
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
    
    
    <div class="cert-container">
      <h2>ログイン</h2>
        <c:if test="${not empty errorMsg}">
          <p><font color="red"><c:out value="${errorMsg}" /></font></p>
        </c:if>
      <form action="Login" method="post">
        <input type="text" name="name" class="input-field" placeholder="ユーザ名" required>
        <input type="password" name="password" class="input-field" placeholder="パスワード" required><br>
        <button type="submit" class="cert-btn">OK</button>
      </form>
      <br>
      <a href="RePassId">パスワードを忘れた場合はこちら</a>
    </div>
    
  </main>
  </body>
</html>