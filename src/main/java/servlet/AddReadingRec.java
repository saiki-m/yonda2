//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚に読書記録を追加する

package servlet;

import java.io.IOException;
import java.util.Map;

import beans.AccountBean;
import dao.AddReadingRecDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetParameterFromJSP;

@WebServlet("/AddReadingRec")
public class AddReadingRec extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPath = "WEB-INF/jsp/readingRecAddResult.jsp";
		
		Map<String, String> info = GetParameterFromJSP.get(request, "title", "author", "readStatus", "count", "point", "impression");
		
		AccountBean accountInfo = (AccountBean) request.getSession().getAttribute("accountInfo");
		
		//データベースyondaの読書状況に読書記録追加
		new AddReadingRecDAO().create(info, accountInfo.getAccountID());
		
		request.getRequestDispatcher(nextPath).forward(request, response);
	}
}