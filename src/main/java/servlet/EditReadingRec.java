//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚の読書記録を編集する

package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import beans.ReadingRecBean;
import dao.EditReadingRecDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GetParameterFromJSP;

@WebServlet("/EditReadingRec")
public class EditReadingRec extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/readingRecAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer index = Integer.parseInt(request.getParameter("LoopIndex"));
		String readingRecID_BySave = request.getParameter("Save");

		@SuppressWarnings("unchecked") //一行下のコードの警告対策。「ReadingRecBean」だと警告は出ないが、Listがついてると出てしまう。
		List<ReadingRecBean> recList = (List<ReadingRecBean>) request.getSession().getAttribute("readingRecList");

		if (readingRecID_BySave == null) {

			ReadingRecBean Record = recList.get(index);

			request.setAttribute("Record", Record);
			request.setAttribute("LoopIndex", index);

			request.getRequestDispatcher("WEB-INF/jsp/EditReadingRec.jsp").forward(request, response);

		} else {
			//「保存する」ボタンを押したとき実行。
			int readingRecID = Integer.parseInt(readingRecID_BySave);

			Map<String, String> info = GetParameterFromJSP.get(request, "title", "author", "readStatus", "count", "point", "impression");
			
			new EditReadingRecDAO().update(info, readingRecID);

			request.setAttribute("Msg", "編集完了!");

			request.getRequestDispatcher("/BookShelf").forward(request, response);
		}
	}
}