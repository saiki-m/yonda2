//「スッキリわかるサーブレット＆JSP入門」P239～241、P291～294のコード10-5を参考

package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *    画面下部にあるログアウトボタンを押したとき実行するサーブレットクラス
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//セッションスコープとして保存したインスタンスをすべて破棄
		request.getSession().invalidate();
		
		request.getRequestDispatcher("WEB-INF/jsp/logout.jsp").forward(request, response);
	}
}