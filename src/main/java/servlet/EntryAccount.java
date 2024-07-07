package servlet;

import java.io.IOException;

import dao.EntryAccountDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *   アカウント新規登録
 */
@WebServlet("/EntryAccount")
public class EntryAccount extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/accountEntry.jsp");
		dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String[] a = {"name", "password", "mailAd", "secret_q"};
		
		for(int i = 0; i < a.length; i++) {
			a[i] = request.getParameter(a[i]);
		}    
		
		new EntryAccountDAO().create(a);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/accountResult.jsp");
		dispatcher.forward(request, response);
	}
}