//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ProfileBean;
import model.ConfigDB;


//アカウント情報をアカウントテーブルに新規登録するDAO
//サンプルデータがアカウントテーブルに登録されていなかったらエラーになる。
//configDB.javaを継承
public class EditProfileDAO{
	
	public void update(ProfileBean profileInfo, int accountID) {
		
		ConfigDB.ReadJDBC_Driver();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
			// SELECT文を準備
			String sql = "UPDATE プロフィール SET 性別 = ?, 生年月日 = ?, 職業 = ?, 在住都道府県 = ?, "
					+ "パーソナルタグ = ?, 興味のあるジャンル = ?, 好きな作家 = ?, お気に入り1位 = ?,"
					+ " お気に入り2位 = ?, お気に入り3位 = ? WHERE アカウントID = ? ";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//WHERE文の?に代入
			for(int i = 0; i < (profileInfo.getStrProfileInfo().length + 1); i++) {
				//生年月日のとき
				if(i == 1) {
					pStmt.setDate(i+1, profileInfo.getBirthday());
					continue; 
				}
				
				//アカウントIDのとき
				if(i == profileInfo.getStrProfileInfo().length) {
					pStmt.setInt(i+1, accountID);
					break;
				}
				
				pStmt.setString(i+1, profileInfo.getStrProfileInfo()[i]);
			}
			
			pStmt.executeUpdate();
			conn.commit();
		}  
		catch (SQLException e) {
			e.printStackTrace();   
		}
	}
}