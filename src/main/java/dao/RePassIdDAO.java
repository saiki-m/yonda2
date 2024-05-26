//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AccountBean;

public class RePassIdDAO extends ConfigDB{
  
	
  //63行目の「return accountID」ができるよう初期設定しておく。
  AccountBean accountID = null;
  
  public AccountBean findAccountID(AccountBean account) {
	  
	//親クラスConfigDBのメソッドを利用
		ReadJDBC_Driver();
	
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備
      String sql = "SELECT アカウントID FROM アカウント WHERE アカウント名=? AND メールアドレス=? AND 秘密の質問=?";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getName());
      pStmt.setString(2, account.getMailAd());
      pStmt.setString(3, account.getSecret_q());
      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
	      // 結果表に格納されたレコードの内容をaccountIDに追加 
	      while (rs.next()) {
	        int ID = rs.getInt("アカウントID");
	        accountID = new AccountBean(ID);
	      }
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    
  //アカウントIDを取得できたとき
  return accountID;      //accountIDインスタンスにアカウントIDが入っている状態。
  }
}