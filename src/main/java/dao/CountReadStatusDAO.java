//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.ConfigDB;

/**
 * 	
 *  読書状況テーブルの「読書状況」の各合計を出す。
 */
public class CountReadStatusDAO{
	
	/**
	 * @param accountID		ログインするアカウントID
	 * @return				ログインするアカウントの読書状況のマップ
	 */
	public Map<String, Integer> count(int accountID) {
		
		ConfigDB.ReadJDBC_Driver();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
			String sql = "SELECT 読書状況 FROM 読書状況 WHERE アカウントID = ? ";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
			pStmt.setInt(1, accountID);
			
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			int noRegist = 0;	//未登録
			int wantRead = 0;	//読みたい
			int stackUpRead = 0;	//積読
			int nowReading = 0;		//いま読んでいる
			int finishRead = 0;		//読み終わった
			int writeImpression = 0;	//感想を書いた
			
			
	        while(rs.next()) {
	        	switch(rs.getString("読書状況")){
	        		
	        		case "未登録":
	        			noRegist++;
	        			break;
	        		case "読みたい":
	        			wantRead++;
	        			break;
	        		case "積読":
	        			stackUpRead++;
	        			break;
	        		case "いま読んでいる":
	        			nowReading++;
	        			break;
	        		case "読み終わった":
	        			finishRead++;
	        			break;
	        		case "感想を書いた":
	        			writeImpression++;
	        			
	        	}
	        }
	        
	        Map<String, Integer> readStatus = new HashMap<String, Integer>();
	        
	        readStatus.put("未登録", noRegist);
			readStatus.put("読みたい", wantRead);
			readStatus.put("積読", stackUpRead);
			readStatus.put("いま読んでいる", nowReading);
			readStatus.put("読み終わった",finishRead);
			readStatus.put("感想を書いた", writeImpression);
	        
	        return readStatus;
	    
	    }  
	    catch (SQLException e) {
	    	e.printStackTrace();
	    
	    	return null;
	    }   
	}
}