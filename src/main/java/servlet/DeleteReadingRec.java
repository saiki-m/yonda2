//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚に読書記録を追加する

package servlet;

import java.io.IOException;
import java.util.List;

import beans.ReadingRecBean;
import dao.ReadingRecDeleteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteReadingRec")
public class DeleteReadingRec extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
		dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String loopIndex = request.getParameter("LoopIndex");
		
		//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
		int index = Integer.parseInt(loopIndex);
		
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<ReadingRecBean> readingRecList = (List<ReadingRecBean>)session.getAttribute("readingRecList");
		
		int readingRecID = readingRecList.get(index).getReadingRecID();
		
		ReadingRecDeleteDAO dao = new ReadingRecDeleteDAO();
		
		if(dao.delete(readingRecID)) { request.setAttribute("Msg", "削除しました!"); }
		else { request.setAttribute("errorMsg", "削除できませんでした"); }
		
		//https://magazine.techacademy.jp/magazine/18607#sec3
		readingRecList.remove(index);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/bookShelf.jsp");
		dispatcher.forward(request, response); 
		
	}
}