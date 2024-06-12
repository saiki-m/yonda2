package servlet;

import java.io.IOException;

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
    
    String[] a = {"name", "password", "mailAd", "secret_q"};
    
    for(int i = 0; i < a.length; i++) {
    	a[i] = request.getParameter(a[i]);
    }    
     
   
    AccountEntryDAO dao = new AccountEntryDAO();
    boolean newAccount = dao.create(a);   
    
    //登録OK
    if(newAccount) {
    	
//    	DefaultProfileDAO dao2 = new DefaultProfileDAO();
//    	dao2.DefaultCreate();
//    	
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