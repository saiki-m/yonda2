package servlet;

import java.io.IOException;

import beans.AccountBean;
import dao.AccountEntryDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AccountEntry")
public class AccountEntry extends HttpServlet {
  private static final long serialVersionUID = 1L; 

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/accountEntry.jsp");
      dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String mailAd = request.getParameter("mailAd");
    String secret_q = request.getParameter("secret_q");
    
    //Accountインスタンスaccountに入力内容を保存
    AccountBean account = new AccountBean(name, password, mailAd, secret_q);
     
    AccountEntryDAO dao = new AccountEntryDAO();
    boolean newAccount = dao.create(account);   //dao.create(account)がTrueで、アカウント登録される。
	
    //登録OK
    if(newAccount) {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/accountResult.jsp");
        dispatcher.forward(request, response); 
	}
	
    //登録できないとき
	else {
		request.setAttribute("errorMsg", "すべての項目を正しく入力してください");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/accountEntry.jsp");
        dispatcher.forward(request, response);
    }
	
  }
}