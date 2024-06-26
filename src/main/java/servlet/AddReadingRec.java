//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚に読書記録を追加する

package servlet;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import beans.ReadingRecBean;
import dao.AddReadingRecDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddReadingRec")
public class AddReadingRec extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
		dispatcher.forward(request, response);   //フォワードはjspフォルダ内に置く
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count2 = 0;
		int point2 = 0;
		
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String readStatus = request.getParameter("readStatus");
		String count = request.getParameter("count");
		String point = request.getParameter("point");
		String impression = request.getParameter("impression");
		
		count2 = Integer.parseInt(count);
		point2 = Integer.parseInt(point);
		
		//入力情報をインスタンスに保存
		ReadingRecBean readingRec = new ReadingRecBean(title, author, readStatus, count2, point2, impression);
		
		HttpSession session = request.getSession();
		AccountBean accountInfo = (AccountBean) session.getAttribute("accountInfo");
		
		//データベースyondaの読書状況に読書記録追加
		AddReadingRecDAO dao = new AddReadingRecDAO();
		boolean Rec = dao.create(readingRec, accountInfo.getAccountID());
		
		//追加できたとき
		if(Rec) {
		
			//登録済みの読書記録を取得
			List<ReadingRecBean> readingRecList = dao.findAll(accountInfo.getAccountID());
			
			//@SuppressWarnings("unchecked")  //一行下のコードの警告対策。「ReadingRecBean」だと警告は出ないが、Listがついてると出てしまう。
			//List<ReadingRecBean> recList = (List<ReadingRecBean>)session.getAttribute("readingRecList");
			
			//リストの一番後ろに追加。
			//recList.add(readingRec);
			
			//「readingRecList」のように、取得先と同じ名前で保存
			session.setAttribute("readingRecList", readingRecList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAddResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "追加できませんでした");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp");
			dispatcher.forward(request, response);
		}
	}
}