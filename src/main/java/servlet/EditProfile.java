//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import beans.AccountBean;
import dao.EditProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetParameterFromJSP;
import model.selectProfile;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 *  プロフィールページの「編集」ボタンを押したとき、プロフィール編集ページに移動する。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/profileEdit.jsp").forward(request, response);
	}  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextForwardPath = "WEB-INF/jsp/profile.jsp";
		
		
		Date Birthday = null; 
		
		Map<String, String> info = GetParameterFromJSP.get(request, "gender", "birthday",
				"profession", "prefectures", "keyword",
				"genru", "author", "book_1", "book_2", "book_3");
		
		try {			
			Birthday = java.sql.Date.valueOf(info.get("birthday"));
		}
		catch(IllegalArgumentException e){
			
			request.setAttribute("errorMsg", "生年月日を正しく入力してください。  例）2000-01-23");
			nextForwardPath = "WEB-INF/jsp/profileEdit.jsp";
		}
		
		AccountBean accountInfo = (AccountBean)request.getSession().getAttribute("accountInfo");
		
		int accountID = accountInfo.getAccountID();
		
		new EditProfileDAO().update(info, Birthday, accountID);
		
		request.setAttribute("Msg", "更新しました！");
		
		selectProfile.select(request, response);
		
		request.getRequestDispatcher(nextForwardPath).forward(request, response);
	}
}