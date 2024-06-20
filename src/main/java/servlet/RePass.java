package servlet;

import java.io.IOException;

import dao.RePassDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RePass")
public class RePass extends HttpServlet {
  private static final long serialVersionUID = 1L; 

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	String forwardPass = null;
	
	// リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    
    String password = request.getParameter("password");
    String password2 = request.getParameter("password2");
    int accountID= Integer.parseInt(request.getParameter("accountID"));
    
    //パスワードが一致していたら
    if(password.equals(password2)){
    	
        RePassDAO dao = new RePassDAO();
    	dao.rePass(password, accountID);   //パスワードを再設定する。
    	
    	forwardPass = "WEB-INF/jsp/rePassResult.jsp"; 	
    }   
    
    else {
    	request.setAttribute("errorMsg", "同じパスワードを入力してください");
    	
    	forwardPass = "WEB-INF/jsp/rePass.jsp";
    } 
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPass);
    dispatcher.forward(request, response); 
  }
}