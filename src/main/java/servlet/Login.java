//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import beans.ReadingRecBean;
import dao.LoginDAO;
import dao.ReadingRecAddDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
      dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 入力した名前、パスワードを取得
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    
    //入力情報をaccountインスタンスに保存。
    AccountBean account = new AccountBean(name, password);
    
    //データベースに接続。アカウントIDを見つけて取得する。
    LoginDAO dao = new LoginDAO();
	AccountBean accountID = dao.findAccountID(name, password);
	
	// アカウントIDが見つからず、取得できなかったとき。
	// ログイン失敗
	if (accountID == null) { 
		
		request.setAttribute("errorMsg", "ユーザ名、パスワードを正しく入力してください");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	}   
	
	//アカウントIDが見つかったとき
    //ログイン成功
    else {
    	//セッションスコープに保存。 マイページや本棚でEL式を使うため。
    	HttpSession session = request.getSession();
    	session.setAttribute("account", account);
    	
    	//本棚に表示する読書記録の一覧を取得。
    	ReadingRecAddDAO dao2 = new ReadingRecAddDAO();
    	List<ReadingRecBean> readingRecList = dao2.findAll();
    	
    	//「bookShelf.jsp」、「ReadingRecAdd.java」で使うため、セッションスコープに保存。
    	session.setAttribute("readingRecList", readingRecList);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp");
        dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
    	
    }
	
  }
}