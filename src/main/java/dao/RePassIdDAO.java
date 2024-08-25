//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import model.ConfigDB;

/**
 *  アカウントがデータベース上にいるか確認する
 */
public class RePassIdDAO{
	
    public Integer findAccountID(Map<String, String> info) {
	  
    	ConfigDB.ReadJDBC_Driver();
	
        try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
    	
        	int accountID = 0;

        	// SELECT文を準備
        	String sql = "SELECT アカウントID FROM アカウント WHERE アカウント名=? AND メールアドレス=? AND 秘密の質問=?";
        	
        	PreparedStatement pStmt = conn.prepareStatement(sql);	    
        
        	//WHERE文の?に代入
        	pStmt.setString(1, info.get("name"));
        	pStmt.setString(2, info.get("mailAd"));
        	pStmt.setString(3, info.get("secret_q"));
	    
        	// SELECTを実行し、結果表を取得
        	ResultSet rs = pStmt.executeQuery();
        	
        	// 結果表に格納されたレコードの内容をaccountIDに追加 
        	if(rs.next()) {
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