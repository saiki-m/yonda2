package servlet;

import java.io.IOException;

import beans.AccountBean;
import dao.RePassDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RePass")
public class RePass extends HttpServlet {
  private static final long serialVersionUID = 1L; 

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    
    String password = request.getParameter("password");
    String password2 = request.getParameter("password2");
    
    AccountBean account5 = new AccountBean(password);
	
    //パスワードが一致していたら
    if(password.equals(password2)){
    	//セッションスコープからインスタンスを取得。
    	//RePassIdDAOで取得したアカウントIDを使用。
    	HttpSession session = request.getSession();
        AccountBean accountID = (AccountBean)session.getAttribute("accountID");
        
        RePassDAO dao = new RePassDAO();
    	dao.rePass(account5, accountID);   //パスワードを再設定する。
    	
    	//不要となったセッションスコープ内のインスタンスを削除
    	session.removeAttribute("accountID");
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/rePassResult.jsp");
        dispatcher.forward(request, response);
    	
    }
    
    
    else {
    	request.setAttribute("errorMsg", "同じパスワードを入力してください");
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/rePass.jsp");
        dispatcher.forward(request, response);
    } 
  }
}