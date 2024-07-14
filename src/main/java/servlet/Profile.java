package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.selectProfile;

/**
 *  メニューバーの「プロフィール」を押したとき、プロフィールページに移動する。
 *  プロフィール編集後、プロフィールページに移動するとき使うクラス。	 
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		selectProfile.select(request, response);
	
		request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(request, response);
	}  
}