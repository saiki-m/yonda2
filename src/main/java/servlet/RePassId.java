//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考
//パスワード変更のための本人確認


package servlet;

import java.io.IOException;

import dao.RePassIdDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RePassId")
public class RePassId extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/rePassId.jsp");
      dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 入力した名前、メールアドレス、秘密の質問を取得
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String mailAd = request.getParameter("mailAd");
    String secret_q = request.getParameter("secret_q");
    
    
    //データベースに接続し、該当するアカウントIDを取得。
    RePassIdDAO dao = new RePassIdDAO();
    //数をスコープに保存するため、Integerにする。
	Integer accountID = dao.findAccountID(name, mailAd, secret_q);
	
	// アカウントIDが見つからず、取得できなかったとき。
	// 失敗
	if (accountID == 0) { 
		request.setAttribute("errorMsg", "本人確認できませんでした。すべての項目を正しく入力してください");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/rePassId.jsp");
        dispatcher.forward(request, response); 
	}
	
	//アカウントIDが見つかったとき
    //パスワード再設定画面へ
    else {
    	//リクエストスコープに保存
    	request.setAttribute("accountID", accountID);
   
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/rePass.jsp");
        dispatcher.forward(request, response);    
    }
	
  }
}