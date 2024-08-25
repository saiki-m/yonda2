//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考
//パスワード変更のための本人確認


package servlet;

import java.io.IOException;
import java.util.Map;

import dao.RePassIdDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetParameterFromJSP;

/**
 *   パスワード変更する前の本人確認画面
 */
@WebServlet("/RePassId")
public class RePassId extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/rePassId.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 入力した名前、メールアドレス、秘密の質問を取得
		Map<String, String> info = GetParameterFromJSP.get(request, "name", "mailAd", "secret_q");
			    
	    //数をスコープに保存するため、Integerにする。
		Integer accountID = new RePassIdDAO().findAccountID(info);
		request.getSession().setAttribute("accountID", accountID);
		
		String nextURL = "WEB-INF/jsp/rePass.jsp";

		if (accountID == 0) { 
			// アカウントIDが取得できなかったとき
			request.setAttribute("errorMsg", "本人確認できませんでした。すべての項目を正しく入力してください");		
			nextURL = "WEB-INF/jsp/rePassId.jsp";
		}
	
		request.getRequestDispatcher(nextURL).forward(request, response);    
	}
}