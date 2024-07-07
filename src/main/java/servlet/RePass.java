package servlet;

import java.io.IOException;

import dao.RePassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RePass")
public class RePass extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	/**
	 *	パスワードを再設定する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "WEB-INF/jsp/rePass.jsp";
		
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		int accountID= Integer.parseInt(request.getParameter("accountID"));
		
		if(password.equals(password2)){
			
			new RePassDAO().rePass(password, accountID);   //パスワードを再設定する。
			
			path = "WEB-INF/jsp/rePassResult.jsp"; 	
		}
		else {
			request.setAttribute("errorMsg", "同じパスワードを入力してください");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}