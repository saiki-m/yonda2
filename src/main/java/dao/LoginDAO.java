//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AccountBean;
import model.ConfigDB;

/**
 * 	ログイン画面からマイページに移動するとき起動するクラス。
 *  該当するアカウントがあれば、そのアカウント情報を取得する。
 */
public class LoginDAO{
  
	/**
	 *	データベースから
	 * 	アカウント名とパスワードの組み合わせで一致するデータを探す。
	 * 
	 * @param name			アカウント名
	 * @param password		パスワード名
	 * @return	アカウント情報（アカウントID、アカウント名、パスワード名、
	 * 					メールアドレス、秘密の質問）を格納しているインスタンス
	 */
	public AccountBean findAccount(String name, String password) {
		
		ConfigDB.ReadJDBC_Driver();
    
	    // データベースへ接続
	    try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
    	
	    	AccountBean account = null;
	    	
	        // アカウントテーブルからアカウント名が一致し、パスワードも一致するアカウントIDを表示。
	        String sql = "SELECT アカウントID, アカウント名, パスワード, メールアドレス, 秘密の質問 FROM アカウント WHERE アカウント名=? AND パスワード=?";
	        
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	        //WHERE文の?に代入
	        pStmt.setString(1, name);
	        pStmt.setString(2, password);

      
		    // SELECTを実行し、結果表を取得
		    ResultSet rs = pStmt.executeQuery();
      
	        // 結果表にあるアカウントIDをaccountIDインスタンスに保存。
	        if(rs.next()) {
		        int ID = rs.getInt("アカウントID");
		        String accountName = rs.getString("アカウント名");
		        String pass = rs.getString("パスワード");
		        String mailAd = rs.getString("メールアドレス");
		        String secret_q = rs.getString("秘密の質問");
		        
		        account = new AccountBean(ID, accountName, pass, mailAd, secret_q);
	        }

	        return account;
	    
	    }  
	    catch (SQLException e) {
	    	e.printStackTrace();
	    
	    	return null;
	    }
    
	}
}