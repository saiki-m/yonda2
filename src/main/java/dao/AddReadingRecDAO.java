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
import java.util.Map;

import beans.ReadingRecBean;

public class AddReadingRecDAO{
	
	public AddReadingRecDAO() {
		ReadJDBC_Driver();
	}

	//本棚に本を追加
	public void create(Map<String, String> info, int accountID) {
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "INSERT INTO 読書状況"
					+ "(アカウントID, タイトル, 作者, 読書状況, 回数, 点数, 感想)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
			pStmt.setInt(1, accountID);
			pStmt.setString(2, info.get("title"));
			pStmt.setString(3, info.get("author"));
			pStmt.setString(4, info.get("readStatus"));
			pStmt.setInt(5, Integer.parseInt(info.get("count")));  //jspのminとmaxで正の整数値以外(アルファベット、負の整数値など)の値が入らないため、try-catchを省略。
			pStmt.setInt(6, Integer.parseInt(info.get("point")));
			pStmt.setString(7, info.get("impression"));
			
			// INSERT文を実行（resultには追加された行数が代入される）
			pStmt.executeUpdate();
			
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//読書記録の一覧を取得
	public List<ReadingRecBean> findAll(int accountID) {
		
		List<ReadingRecBean> readingRecList = new ArrayList<>();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT 読書状況ID, タイトル, 作者, 読書状況, 回数, 点数, 感想"
					+ " FROM 読書状況 WHERE アカウントID = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, accountID);
			
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容を
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