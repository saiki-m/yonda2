//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;

import beans.AccountBean;
import dao.LoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 *	ログイン画面からマイページに移動させる
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "WEB-INF/jsp/login.jsp";
		
		// 入力した名前、パスワードを取得
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//データベースからアカウントIDを見つけて取得する。
		AccountBean accountInfo = new LoginDAO().findAccount(name, password);
		
		if (accountInfo != null) {
			//ログイン成功
			request.getSession().setAttribute("accountInfo", accountInfo);    //情報を保存。 マイページや本棚で使うため。
			
			//本棚に表示する読書記録の一覧を取得。
//    		ReadingRecAddDAO dao2 = new ReadingRecAddDAO();
//    		List<ReadingRecBean> readingRecList = dao2.findAll(accountInfo.getAccountID());
//    	
//    		//「bookShelf.jsp」、「ReadingRecAdd.java」で使うため、セッションスコープに保存。
//    		session.setAttribute("readingRecList", readingRecList);
//    	
			
			path = "WEB-INF/jsp/myPage.jsp";
		}
		else {
			request.setAttribute("errorMsg", "ユーザ名、パスワードを正しく入力してください");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}