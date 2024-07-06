//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteReadingRecDAO extends ConfigDB{
  
	public void delete(int readingRecID) {
		 
		//親クラスConfigDBのメソッドを利用
		ReadJDBC_Driver();
	    
	    // データベースへ接続
	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	
	      String sql = "DELETE FROM 読書状況 WHERE 読書状況ID=? ";
	        
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      //WHERE文の?に代入
	      pStmt.setInt(1, readingRecID);
	      //SQL実行
	      pStmt.executeUpdate();
			      
	    }  
	      //tryの中でエラーが出たら、catchのみ実行する
	    catch (SQLException e) {
	      e.printStackTrace();
	    }           
	}    
}