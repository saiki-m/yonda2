//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;
import java.sql.Date;

import beans.AccountBean;
import beans.ProfileBean;
import dao.EditProfileDAO;
import dao.ShowProfileDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "WEB-INF/jsp/profile.jsp";
		
		request.setCharacterEncoding("UTF-8");
		String edit = request.getParameter("edit");
		
		if("done".equals(edit)) {
			//プロフィールページの「編集」ボタンを押したとき
			path = "WEB-INF/jsp/profileEdit.jsp";
		}
		else {
			HttpSession session = request.getSession();
			AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
			
			int accountID = accountInfo.getAccountID();
			
			ShowProfileDAO dao = new ShowProfileDAO();
			ProfileBean profile = dao.show(accountID);
			
			session.setAttribute("profile", profile); 
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "WEB-INF/jsp/profile.jsp";
		
		Date Birthday = null; 
		
		request.setCharacterEncoding("UTF-8");
		
		String[] strInfo = {"gender", "birthday", "profession", "prefectures", "keyword",
				"genru", "author", "book_1", "book_2", "book_3"};
		
		for(int i = 0; i < strInfo.length; i++) {
			strInfo[i] = request.getParameter(strInfo[i]);
		}
		
		try {			
			Birthday = java.sql.Date.valueOf(strInfo[1]);
		}
		catch(IllegalArgumentException e){
			
			request.setAttribute("errorMsg", "生年月日を正しく入力してください。  例）2000-01-23");
			path = "WEB-INF/jsp/profileEdit.jsp";
		}
		
		ProfileBean profile = new ProfileBean(Birthday, strInfo);
		
		HttpSession session = request.getSession();
		
		AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
		ProfileBean beforeProfile = (ProfileBean)session.getAttribute("profile");
		
		int accountID = accountInfo.getAccountID();
		
		beforeProfile.setGender(strInfo[0]);
		beforeProfile.setBirthday(Birthday);
		beforeProfile.setProfession(strInfo[2]);
		beforeProfile.setPrefectures(strInfo[3]);
		beforeProfile.setKeyword(strInfo[4]);
		beforeProfile.setGenru(strInfo[5]);
		beforeProfile.setAuthor(strInfo[6]);
		beforeProfile.setBook_1(strInfo[7]);
		beforeProfile.setBook_2(strInfo[8]);
		beforeProfile.setBook_3(strInfo[9]);
		
		
		EditProfileDAO dao = new EditProfileDAO();
		dao.update(profile, accountID);
		
		request.setAttribute("Msg", "更新しました！");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
		
	}
}