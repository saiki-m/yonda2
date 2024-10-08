//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;
import java.util.Map;

import beans.AccountBean;
import dao.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetParameterFromJSP;

/**
 *  ログイン
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 *  TOPページのログインボタンを押したとき、ログインページに移動する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}
	
	/**
	 *	ログイン画面で認証後、該当アカウント情報を取得。マイページに移動する。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> info = GetParameterFromJSP.get(request, "name", "password");
		
		AccountBean accountInfo = new LoginDAO().findAccount(info);
		
		request.getSession().setAttribute("accountInfo", accountInfo);    //情報を保存。 マイページや本棚で使うため。

		String nextURL = "/MyPage";

		if (accountInfo == null) {
			
			request.setAttribute("errorMsg", "ユーザ名、パスワードを正しく入力してください");
			nextURL = "WEB-INF/jsp/login.jsp";
		}

		request.getRequestDispatcher(nextURL).forward(request, response);
		
	}
}