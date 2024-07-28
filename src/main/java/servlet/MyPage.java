//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  マイページを表示するクラス。
 */
@WebServlet("/MyPage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	/**
	 *	顔写真アイコンをおしたときマイページに戻る
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		CountReadStatusDAO dao = new CountReadStatusDAO();
//		
//		AccountBean accountInfo = (AccountBean)request.getSession().getAttribute("accountInfo");
//		
//		Map<String, Integer> readStatus = dao.countReadStatus(accountInfo.getAccountID()); 
//		
		request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp").forward(request, response);
	}
	
	/**
	 *	ログイン後マイページに移動する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		CountReadStatusDAO dao = new CountReadStatusDAO();
//		
//		AccountBean accountInfo = (AccountBean)request.getSession().getAttribute("accountInfo");
//		
//		Map<String, Integer> readStatus = dao.countReadStatus(accountInfo.getAccountID()); 
//		
		request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp").forward(request, response);
	}
	
	
}