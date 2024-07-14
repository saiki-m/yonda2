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
      <h2>パスワードの再設定</h2>
        <c:if test="${not empty errorMsg}">
          <p><font color="red"><c:out value="${errorMsg}" /></font></p>
        </c:if>
      <form action="RePass" method="post">
        <input type="password" name="password" class="input-field" placeholder="新しいパスワード" required>
        <input type="password" name="confirmPassword" class="input-field" placeholder="新しいパスワードの確認" required><br>
        <button type="submit" class="cert-btn">OK</button>
        
    </div>
  </main>
  </body>
</html>