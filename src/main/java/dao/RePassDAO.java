//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ConfigDB;

/**
 * データベースに保存されているパスワードを再設定する
 */
public class RePassDAO{
	
	public void rePass(String password, int accountID) {
		
		ConfigDB.ReadJDBC_Driver();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
			// SELECT文を準備
			String sql = "UPDATE アカウント SET パスワード=? WHERE アカウントID=? ";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
			pStmt.setString(1, password);
			pStmt.setInt(2, accountID);
			
			pStmt.executeUpdate();
			conn.commit();     
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}