//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RePassIdDAO extends ConfigDB{
  
	
  
  public Integer findAccountID(String name, String mailAd, String secret_q) {
	  
	//親クラスConfigDBのメソッドを利用
		ReadJDBC_Driver();
		
		int accountID = 0;
	
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備
      String sql = "SELECT アカウントID FROM アカウント WHERE アカウント名=? AND メールアドレス=? AND 秘密の質問=?";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, name);
      pStmt.setString(2, mailAd);
      pStmt.setString(3, secret_q);
      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
	      // 結果表に格納されたレコードの内容をaccountIDに追加 
	      while (rs.next()) {
	        accountID = rs.getInt("アカウントID");
	      }
	      
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
    
	return accountID;
        
  }
}