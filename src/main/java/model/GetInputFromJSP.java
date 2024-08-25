//https://www.sejuku.net/blog/24926
//https://magazine.techacademy.jp/magazine/9246

package model;

import java.io.IOException;

import beans.AccountBean;
import beans.ProfileBean;
import dao.ShowProfileDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * データベースからプロフィール情報を取得する。
 */
public class GetInputFromJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		AccountBean accountInfo = (AccountBean)request.getSession().getAttribute("accountInfo");
		
		int accountID = accountInfo.getAccountID();
		
		//プロフィール情報を取得
		ProfileBean profile = new ShowProfileDAO().show(accountID);
		
		request.getSession().setAttribute("profile", profile); 
	}
}