package servlet;

import java.io.IOException;
import java.util.Map;

import dao.EntryAccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetParameterFromJSP;
import model.ValidPassWord;

/**
 *   アカウント新規登録
 */
@WebServlet("/EntryAccount")
public class EntryAccount extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワードはjspフォルダ内に置く
		request.getRequestDispatcher("WEB-INF/jsp/accountEntry.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextURL = "WEB-INF/jsp/accountResult.jsp";
		
		Map<String, String> info = GetParameterFromJSP.get(request, "name", "password", "mailAd", "secret_q");
	
		if(ValidPassWord.check(info.get("password"))) {
			new EntryAccountDAO().create(info);
			
		}else {
			request.setAttribute("errorMsg", "英字の大文字、小文字、数字を組み合わせて、4桁以上のパスワードを作成してください。");
			nextURL = "WEB-INF/jsp/accountEntry.jsp";
		}
		
		request.getRequestDispatcher(nextURL).forward(request, response);
		
	}
}