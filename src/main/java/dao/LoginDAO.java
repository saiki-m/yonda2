//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AccountBean;

//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class LoginDAO extends ConfigDB{
  
  //６５行目の「return accountID」ができるよう初期設定しておく。
  AccountBean accountID = null;
  
  
  public AccountBean findAccountID(String name, String password) {
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。
      // アカウントテーブルからアカウント名が一致し、パスワードも一致するアカウントIDを表示。
      String sql = "SELECT アカウントID FROM アカウント WHERE アカウント名=? AND パスワード=?";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, name);
      pStmt.setString(2, password);

      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
	      // 結果表にあるアカウントIDをaccountIDインスタンスに保存。
	      while (rs.next()) {
	        int ID = rs.getInt("アカウントID");
	          accountID = new AccountBean(ID);
	      }
	      
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
    return null;   //Login.javaの35行目、dao.findAccountID(account)にnullが入る。
    }                
    
  //アカウントIDを取得できたとき
  return accountID;   //accountIDインスタンスにアカウントIDが入っている状態。
                          
  }
}