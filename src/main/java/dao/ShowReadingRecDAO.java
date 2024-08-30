//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import static model.ConfigDB.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReadingRecBean;

public class ShowReadingRecDAO{
	
	/**
	 * 読書記録の一覧を取得
	 * @param accountID   ログイン中のアカウントID
	 * @return 読書記録の一覧
	 */
	public List<ReadingRecBean> findAll(int accountID) {
		
		ReadJDBC_Driver();
		
		List<ReadingRecBean> readingRecList = new ArrayList<>();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT 読書状況ID, タイトル, 作者, 読書状況, 回数, 点数, 感想 FROM 読書状況 WHERE アカウントID = ?";
			
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, accountID);
			
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容を
			// record2インスタンスに設定し、readingRecListインスタンスに追加
			while (rs.next()) {
				int ID = rs.getInt("読書状況ID");
				String title = rs.getString("タイトル");
				String author = rs.getString("作者");
				String readStatus = rs.getString("読書状況");
				int count = rs.getInt("回数");
				int point = rs.getInt("点数");
				String impression = rs.getString("感想");
				
				ReadingRecBean record = new ReadingRecBean(ID, title, author, 
						readStatus, count, point, impression);
				
				readingRecList.add(record);
			}
			
			return readingRecList;
			
	    }   
	    catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}