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
    	<a href="bookShelf.jsp" class="btn">本棚</a>
    	<a href="profile.jsp" class="btn">プロフィール</a>
	  </div>
    
        <h2>読書記録を追加</h2>
      	<form action="ReadingRecAdd" method="post">
	        <input type="text" name="title" class="input-field" placeholder="タイトル" required>
	        <input type="text" name="author" class="input-field" placeholder="作者" required>
	        <select name="readStatus" class="input-field" placeholder="読書状況">
				<option value="未登録">未登録</option>
				<option value="読みたい">読みたい</option>
				<option value="積読">積読</option>
				<option value="いま読んでいる">いま読んでいる</option>
				<option value="読み終わった">読み終わった</option>
				<option value="感想を書いた">感想を書いた</option>
			</select><br>
	        <button type="submit" class="cert-btn">保存</button>
	     </form>
  </main>
</body>
</html>