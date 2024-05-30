//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚に読書記録を追加する

package servlet;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import beans.ReadingRecBean;
import dao.ReadingRecAddDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ReadingRecAdd")
public class ReadingRecAdd extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
	    dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
	  
  	}
	  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    String readStatus = request.getParameter("readStatus");
    
    //入力情報をインスタンスに保存
    ReadingRecBean readingRec = new ReadingRecBean(title, author, readStatus);
    
    HttpSession session = request.getSession();
    AccountBean accountInfo = (AccountBean) session.getAttribute("accountInfo");
	
    //データベースyondaの読書状況に読書記録追加
    ReadingRecAddDAO dao = new ReadingRecAddDAO();
    boolean Rec = dao.create(readingRec, accountInfo.getAccountID());
    
    //追加できたとき
	if(Rec) {
		
		//登録済みの読書記録を取得
		
		@SuppressWarnings("unchecked")  //一行下のコードの警告対策。「ReadingRecBean」だと警告は出ないが、Listがついてると出てしまう。
		List<ReadingRecBean> recList = (List<ReadingRecBean>)session.getAttribute("readingRecList");
		
		//リストの一番後ろに追加。
		recList.add(readingRec);
		
		//「readingRecList」のように、取得先と同じ名前で保存
		session.setAttribute("readingRecList", recList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAddResult.jsp");
        dispatcher.forward(request, response);
	    //request.getAttribute("addRec");
	}
	
	//追加できなかったとき
	else {
		request.setAttribute("errorMsg", "追加できませんでした");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
        dispatcher.forward(request, response);
    }
	
  }
}