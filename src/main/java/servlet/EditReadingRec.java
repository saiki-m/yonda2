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
import jakarta.servlet.http.HttpSession;

@WebServlet("/EditReadingRec")
public class EditReadingRec extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
	    dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	  
  	}
	  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	// リクエストパラメータを取得
    String loopIndex = request.getParameter("LoopIndex");
    
    int index = Integer.parseInt(loopIndex);
    String readingRecID_BySave = request.getParameter("Save");
    
    HttpSession session = request.getSession();
	
    @SuppressWarnings("unchecked")  //一行下のコードの警告対策。「ReadingRecBean」だと警告は出ないが、Listがついてると出てしまう。
	List<ReadingRecBean> recList = (List<ReadingRecBean>)session.getAttribute("readingRecList");
	
    if(readingRecID_BySave == null) {
	    ReadingRecBean Record = recList.get(index);
	    
	    request.setAttribute("Record", Record);
		request.setAttribute("LoopIndex", loopIndex);
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditReadingRec.jsp");
	    dispatcher.forward(request, response);
    }
  //編集後実行。「保存する」ボタン押したとき。
    else {
  	  String title = request.getParameter("title");
  	  String author = request.getParameter("author");	    
  	  String readStatus = request.getParameter("readStatus");
  	  String count = request.getParameter("count");
  	  String point = request.getParameter("point");
  	  String impression = request.getParameter("impression");
  	  
  	  int readingRecID = Integer.parseInt(readingRecID_BySave);
  	  int count2 = Integer.parseInt(count);
  	  int point2 = Integer.parseInt(point);
  	 
  	  ReadingRecBean Record = new ReadingRecBean(readingRecID, title, author, readStatus, count2, point2, impression);
  	         
  	  EditReadingRecDAO dao = new EditReadingRecDAO();
  	  //主キーである「itemID」を利用して更新する
  	  dao.update(Record);
  	  
  	  //https://magazine.techacademy.jp/magazine/18607#sec3
  	  recList.set(index, Record);

  	  
  	  request.setAttribute("Msg", "編集完了!");
  		
  	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/bookShelf.jsp");
        dispatcher.forward(request, response);
  	  
    }
  }
}