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
		
		String nextURL = "WEB-INF/jsp/rePassResult.jsp";

		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if(password.equals(confirmPassword)){
			
			Integer accountID = (Integer)request.getSession().getAttribute("accountID");
			new RePassDAO().rePass(password, accountID);   //パスワードを再設定する。			
		}
		else {
			request.setAttribute("errorMsg", "同じパスワードを入力してください");
			nextURL = "WEB-INF/jsp/rePass.jsp"; 	
		}
		
		request.getRequestDispatcher(nextURL).forward(request, response);
	}
}