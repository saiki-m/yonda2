//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.AccountBean;



//アカウント情報をアカウントテーブルに新規登録するDAO
//サンプルデータがアカウントテーブルに登録されていなかったらエラーになる。
//configDB.javaを継承
public class ProfileEditDAO extends ConfigDB{

	
  public void update(AccountBean account) {
	  
	//親クラスConfigDBのメソッドを利用
	//JDBCドライバーを読み込む
		ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
      
    	
      // SELECT文を準備
      String sql = "UPDATE アカウント SET 氏名 = ?, メールアドレス = ?, 住所 = ?  WHERE アカウントID = ? ";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getName());
      pStmt.setString(2, account.getMailAd());
      pStmt.setString(3, account.getHomeAddress());
      pStmt.setInt(4, account.getAccountID());

      pStmt.executeUpdate();
      conn.commit();
          
    }  
      //try文の中でエラーが出たとき実行する
    catch (SQLException e) {
      e.printStackTrace();   
    }
    
    
  }
}