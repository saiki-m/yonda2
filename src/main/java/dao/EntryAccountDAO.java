//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;
import static model.ConfigDB.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EntryAccountDAO{
	
	public EntryAccountDAO(){
		//JDBCドライバーを読み込む。newでインスタンス生成されたらこのメソッド実行される。
		ReadJDBC_Driver();
	}
	
	public void create(Map<String, String> account) {
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備。プロフィールIDはNULLのまま。プロフィール編集したときに更新する。
			String sql = "INSERT INTO アカウント"
					+ "(アカウント名, パスワード, メールアドレス, 秘密の質問)"
					+ "VALUES (?, ?, ?, ?)";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
				pStmt.setString(1, account.get("name"));
				pStmt.setString(2, account.get("password"));
				pStmt.setString(3, account.get("mailAd"));
				pStmt.setString(4, account.get("secret_q"));
			
			// INSERT文を実行（resultには追加された行数が代入される）
			pStmt.executeUpdate();
			
			pStmt.getMaxRows();
			
			insertAccountID_IntoProfile();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private void insertAccountID_IntoProfile() {
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "INSERT INTO プロフィール(アカウントID) VALUES (?)";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
			pStmt.setInt(1, getRegistAccountID());
			
			// INSERT文を実行（resultには追加された行数が代入される）
			pStmt.executeUpdate();
			
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private int getRegistAccountID() {
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS) ) {
				
			int accountID = 0;

			//アカウントテーブルに登録されるアカウントIDはオートインクリメントのため、MAX関数で取得。	
			String sql = "SELECT MAX(アカウントID) AS アカウントID FROM アカウント";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				accountID = rs.getInt("アカウントID");
			}
			
			return accountID;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}	
	}
}