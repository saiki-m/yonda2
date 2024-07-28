//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;

import beans.AccountBean;
import dao.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
		String URL = "WEB-INF/jsp/login.jsp";
		
		// 入力した名前、パスワードを取得
		final String name = request.getParameter("name");
		final String password = request.getParameter("password");
		
		//データベースからアカウントIDを見つけて取得する。
		AccountBean accountInfo = new LoginDAO().findAccount(name, password);
		
		if (accountInfo != null) {
			
			request.getSession().setAttribute("accountInfo", accountInfo);    //情報を保存。 マイページや本棚で使うため。
			URL = "/MyPage";
		}
		else {
			
			request.setAttribute("errorMsg", "ユーザ名、パスワードを正しく入力してください");
		}

		request.getRequestDispatcher(URL).forward(request, response);
		
	}
}