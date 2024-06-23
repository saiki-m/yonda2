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

/**
 *   パスワード変更する前の本人確認画面
 */
@WebServlet("/RePassId")
public class RePassId extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	String path = "WEB-INF/jsp/rePassId.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 入力した名前、メールアドレス、秘密の質問を取得
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    String mailAd = request.getParameter("mailAd");
	    String secret_q = request.getParameter("secret_q");
	    
	    //該当するアカウントIDを取得。
	    RePassIdDAO dao = new RePassIdDAO();
	    //数をスコープに保存するため、Integerにする。
		Integer accountID = dao.findAccountID(name, mailAd, secret_q);
		
		if (accountID == 0) { 
			// アカウントIDが見つからず、取得できなかったとき。
			request.setAttribute("errorMsg", "本人確認できませんでした。すべての項目を正しく入力してください");		
		}
	    else {
	    	//アカウントIDが見つかったとき
	    	//パスワード再設定画面へ
	    	request.setAttribute("accountID", accountID);
	    	path = "WEB-INF/jsp/rePass.jsp";
	    }
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);    
	}
}