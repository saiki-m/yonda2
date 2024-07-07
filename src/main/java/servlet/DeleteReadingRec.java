package servlet;

import java.io.IOException;
import java.util.List;

import beans.ReadingRecBean;
import dao.DeleteReadingRecDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 * 本棚から読書記録を削除する
 * 
 * //「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
 * //P298のコード10-13
 */
@WebServlet("/DeleteReadingRec")
public class DeleteReadingRec extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
		dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int index = Integer.parseInt( request.getParameter("LoopIndex") );
		
		@SuppressWarnings("unchecked")
		List<ReadingRecBean> readingRecList = (List<ReadingRecBean>)request.getSession().getAttribute("readingRecList");
		
		int readingRecID = readingRecList.get(index).getReadingRecID();
		
		//DAOクラスのdeleteメソッドで削除
		new DeleteReadingRecDAO().delete(readingRecID);
		
		request.setAttribute("Msg", "削除しました!"); 
		
		//https://magazine.techacademy.jp/magazine/18607#sec3
		//スコープ内の読書記録を削除
		readingRecList.remove(index);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/bookShelf.jsp");
		dispatcher.forward(request, response);
	}
}