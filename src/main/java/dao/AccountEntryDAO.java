//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountEntryDAO extends ConfigDB{

	
  public void create(String[] account) {
	  
	//親クラスConfigDBのメソッドを利用
	//JDBCドライバーを読み込む
		ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。プロフィールIDはNULLのまま。プロフィール編集したときに更新する。
      String sql = "INSERT INTO アカウント(アカウント名, パスワード, メールアドレス, 秘密の質問)\r\n"
      		        + "VALUES (?, ?, ?, ?)";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account[0]);
      pStmt.setString(2, account[1]);
      pStmt.setString(3, account[2]);
      pStmt.setString(4, account[3]);

      // INSERT文を実行（resultには追加された行数が代入される）
      pStmt.executeUpdate();
      
      insertAccountID_IntoProfile();
         
    }  
      //try文の中でエラーが出たとき実行する
    catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
  
  public boolean insertAccountID_IntoProfile() {
	  
	    ReadJDBC_Driver();
	    
	    // データベースへ接続
	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	
	      String sql = "INSERT INTO プロフィール(アカウントID) VALUES (?)";
	        
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	    //WHERE文の?に代入
	      pStmt.setInt(1, getRegistAccountID());
	      
	      // INSERT文を実行（resultには追加された行数が代入される）
	      int result = pStmt.executeUpdate();
	      if (result != 1) {
	        return false;
	      }
		      
	    }  
	      //try文の中でエラーが出たとき実行する
	    catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	    
	    //できたとき
	    return true;
	  }
  
  public int getRegistAccountID() {
	  
	    int accountID = 0;
		
	    ReadJDBC_Driver();
	    
	    // データベースへ接続
	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	      
	      //アカウントテーブルに登録されるアカウントIDはオートインクリメントのため、MAX関数で取得。	
	      String sql = "SELECT MAX(アカウントID) AS アカウントID FROM アカウント";
	        
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	   // SELECTを実行し、結果表を取得
	      ResultSet rs = pStmt.executeQuery();
	      
		      // 結果表にあるアカウントIDをaccountIDインスタンスに保存。
		      while (rs.next()) {
		          accountID = rs.getInt("アカウントID");
		      }
		      
	    }  
	      //try文の中でエラーが出たとき実行する
	    catch (SQLException e) {
	      e.printStackTrace();
	      return 0;
	    }
	    
	    //できたとき
	    return accountID;
	  }
  
}