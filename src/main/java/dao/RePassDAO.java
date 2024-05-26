//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.AccountBean;

public class RePassDAO extends ConfigDB{
  
	
  public void rePass(AccountBean account, AccountBean account2) {
	   
	//親クラスConfigDBのメソッドを利用
		ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備
      String sql = "UPDATE アカウント SET パスワード=? WHERE アカウントID=? ";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getPassword());
      pStmt.setInt(2, account2.getAccountID());
      
      pStmt.executeUpdate();
      conn.commit();
         
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
    }
    
    
  }
}