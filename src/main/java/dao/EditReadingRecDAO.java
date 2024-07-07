//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ReadingRecBean;
import model.ConfigDB;

public class EditReadingRecDAO{
	
	//本棚に本を追加
	public boolean update(ReadingRecBean rec) {
		
		//親クラスConfigDBのメソッドを利用
		ConfigDB.ReadJDBC_Driver();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
			// SELECT文を準備
			String sql = "UPDATE 読書状況 SET タイトル = ?, 作者 = ?, 読書状況 = ?, 回数 = ?, 点数 = ?, 感想 = ? WHERE 読書状況ID = ? ";
    		     
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
			
			pStmt.setString(1, rec.getTitle());
			pStmt.setString(2, rec.getAuthor());
			pStmt.setString(3, rec.getReadStatus());
			pStmt.setInt(4, rec.getCount());
			pStmt.setInt(5, rec.getPoint());
			pStmt.setString(6, rec.getImpression());
			pStmt.setInt(7, rec.getReadingRecID());
			
			// INSERT文を実行
			pStmt.executeUpdate();
			
		    return true;
		}  
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}	    
}