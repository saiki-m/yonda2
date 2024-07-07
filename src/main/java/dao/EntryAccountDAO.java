//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConfigDB;

public class EntryAccountDAO{
	
	public EntryAccountDAO(){
		//JDBCドライバーを読み込む。newでインスタンス生成されたらこのメソッドが実行される。
		ConfigDB.ReadJDBC_Driver();
	}
	
	public void create(String[] account) {
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
			// SELECT文を準備。プロフィールIDはNULLのまま。プロフィール編集したときに更新する。
			String sql = "INSERT INTO アカウント(アカウント名, パスワード, メールアドレス, 秘密の質問)\r\n"
					+ "VALUES (?, ?, ?, ?)";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
			for(int i = 0; i < account.length; i++) {
				pStmt.setString(i+1, account[i]);
			}
			
			// INSERT文を実行（resultには追加された行数が代入される）
			pStmt.executeUpdate();
			
			insertAccountID_IntoProfile();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertAccountID_IntoProfile() {
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
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
	
	public int getRegistAccountID() {
		
		int accountID = 0;

		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS) ) {
				
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