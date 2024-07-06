<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <% //教科書P344～349の動的インクルード %>
    <div class="top-container">
	  	<a href="MyPage"><img src="./img/myicon.png" alt="マイページ"></a>
	  	
	  	<h3><c:out value="${accountInfo.name}" />さん</h3>
    	
    	<a href="BookShelf" class="btn">本棚</a>
    	<a href="EditProfile" class="btn">プロフィール</a>
	</div>