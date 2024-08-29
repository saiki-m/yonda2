//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import model.ConfigDB;

public class EditReadingRecDAO{
	
	//本棚に本を追加
	public void update(Map<String, String> info, int readingRecId) {
		
		//親クラスConfigDBのメソッドを利用
		ConfigDB.ReadJDBC_Driver();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
			// SELECT文を準備
			String sql = "UPDATE 読書状況 SET タイトル = ?, 作者 = ?, 読書状況 = ?, 回数 = ?, 点数 = ?, 感想 = ? WHERE 読書状況ID = ? ";
    		     
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, info.get("title"));
			pStmt.setString(2, info.get("author"));
			pStmt.setString(3, info.get("readStatus"));
			pStmt.setInt(4, Integer.parseInt(info.get("count")));
			pStmt.setInt(5, Integer.parseInt(info.get("point")));
			pStmt.setString(6, info.get("impression"));
			pStmt.setInt(7, readingRecId);
			
			// INSERT文を実行
			pStmt.executeUpdate();
			
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	    
}