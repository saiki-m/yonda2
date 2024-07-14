//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚に読書記録を追加する

package servlet;

import java.io.IOException;
import java.util.List;

import beans.ReadingRecBean;
import dao.EditReadingRecDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditReadingRec")
public class EditReadingRec extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
			dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
			
		}
	   
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int count = 0;
			int point = 0;
			
			Integer index = Integer.parseInt( request.getParameter("LoopIndex") );
			String readingRecID_BySave = request.getParameter("Save");
			
			
			@SuppressWarnings("unchecked")  //一行下のコードの警告対策。「ReadingRecBean」だと警告は出ないが、Listがついてると出てしまう。
			List<ReadingRecBean> recList = (List<ReadingRecBean>)request.getSession().getAttribute("readingRecList");
			
			if(readingRecID_BySave == null) {
			
				ReadingRecBean Record = recList.get(index);
				
				request.setAttribute("Record", Record);
				request.setAttribute("LoopIndex", index);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditReadingRec.jsp");
				dispatcher.forward(request, response);
				
			}else {
				//「保存する」ボタンを押したとき実行。
				int readingRecID = Integer.parseInt(readingRecID_BySave);
				
				String title = request.getParameter("title");
				String author = request.getParameter("author");	    
				String readStatus = request.getParameter("readStatus");
				
				try {
					
					count = Integer.parseInt( request.getParameter("count") );
				}catch(NumberFormatException e){
					request.setAttribute("errorMsg", "0以上の数字を入力してください。");
					
//					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditReadingRec.jsp");
//					dispatcher.forward(request, response);
				}
				
				try {
					point = Integer.parseInt( request.getParameter("point") );
				
				}catch(NumberFormatException e){
					request.setAttribute("errorMsg", "0以上の数字を入力してください。");
					
//					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditReadingRec.jsp");
//					dispatcher.forward(request, response);
					
				}
				String impression = request.getParameter("impression");
				
				ReadingRecBean Record = new ReadingRecBean(readingRecID, title, author, readStatus, count, point, impression);
				
				
				new EditReadingRecDAO().update(Record);
				
				//https://magazine.techacademy.jp/magazine/18607#sec3
				recList.set(index, Record);
				
				
				request.setAttribute("Msg", "編集完了!");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/bookShelf.jsp");
				dispatcher.forward(request, response);
			}
		}
}	