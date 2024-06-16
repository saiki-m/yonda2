//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;
import java.sql.Date;

import beans.AccountBean;
import beans.ProfileBean;
import dao.ProfileEditDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  request.setCharacterEncoding("UTF-8");
	  String edit = request.getParameter("edit");
	  
	  //マイページの「プロフィール」ボタンを押したとき
	  if(edit == null) {
		  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/profile.jsp");
	      dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	  }
	  
	  //プロフィールページの「編集」ボタンを押したとき
	  else if(edit.equals("done")){
		  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/profileEdit.jsp");
	      dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	  }
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  
	  String[] inputInfo = {"gender", "birthday", "profession", "prefectures", "keyword",
			  			"genru", "author", "book_1", "book_2", "book_3"};

	  for(int i = 0; i < inputInfo.length; i++) {
	      inputInfo[i] = request.getParameter(inputInfo[i]);
	  }
	    

	  Date Birthday = java.sql.Date.valueOf(inputInfo[1]);
	    
	  ProfileBean profile = new ProfileBean(Birthday, inputInfo);
	  
	  HttpSession session = request.getSession();
		
	  AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
		
	  ProfileEditDAO dao = new ProfileEditDAO();
	  dao.update(profile, accountInfo);
	  
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/profile.jsp");
      dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	  
  }
}