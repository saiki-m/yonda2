<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    <div class="center-container">
    <c:if test="${not empty errorMsg}">
          <p><font color="red"><c:out value="${errorMsg}" /></font></p>
        </c:if>
      <p>登録完了</P>
      <a href="Login" class="btn">ログイン</a>
    </div>
  </main>
  </body>
</html>
