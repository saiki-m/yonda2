//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import beans.ReadingRecBean;
import dao.ShowReadingRecDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  データベースから読書状況を取得し、本棚ページに移動する
 */
@WebServlet("/BookShelf")
public class BookShelf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		commonLogic(request, response);
	}

	/**
	 *  本の編集が完了したとき実行する。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		commonLogic(request, response);
	}

	private void commonLogic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AccountBean accountInfo = (AccountBean) request.getSession().getAttribute("accountInfo");

		List<ReadingRecBean> readingRecList = new ShowReadingRecDAO().findAll(accountInfo.getAccountID());

		//セッションスコープに保存。
		request.getSession().setAttribute("readingRecList", readingRecList);

		request.getRequestDispatcher("WEB-INF/jsp/bookShelf.jsp").forward(request, response);

	}
}