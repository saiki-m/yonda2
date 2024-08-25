//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;

import beans.AccountBean;
import dao.CountReadStatusDAO;
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

		commonlogic(request, response);
	}
	
	/**
	 *	ログイン後マイページに移動する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		commonlogic(request, response);	
	}	

	private void commonlogic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		AccountBean accountInfo = (AccountBean)request.getSession().getAttribute("accountInfo");
		
		CountReadStatusDAO dao = new CountReadStatusDAO();
						
		request.getSession().setAttribute("readStatus", dao.count(accountInfo.getAccountID()));    //情報を保存。 マイページや本棚で使うため。
		
		request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp").forward(request, response);
	
	}
	
}