//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚に読書記録を追加する

package servlet;

import java.io.IOException;
import java.util.List;

import beans.ReadingRecBean;
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
    
    HttpSession session = request.getSession();
	
    @SuppressWarnings("unchecked")  //一行下のコードの警告対策。「ReadingRecBean」だと警告は出ないが、Listがついてると出てしまう。
	List<ReadingRecBean> recList = (List<ReadingRecBean>)session.getAttribute("readingRecList");
	
    ReadingRecBean Record = recList.get(index);
    
    request.setAttribute("Record", Record);
	request.setAttribute("LoopIndex", loopIndex);
    
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditReadingRec.jsp");
    dispatcher.forward(request, response);
	
  }
}