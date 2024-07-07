//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ProfileBean;
import model.ConfigDB;


//アカウント情報をアカウントテーブルに新規登録するDAO
//サンプルデータがアカウントテーブルに登録されていなかったらエラーになる。
//configDB.javaを継承
public class ShowProfileDAO{
	
	public ProfileBean show(int accountID) {
		
		ConfigDB.ReadJDBC_Driver();
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(ConfigDB.JDBC_URL, ConfigDB.DB_USER, ConfigDB.DB_PASS)) {
			
			ProfileBean profile = null;
			
			// アカウントテーブルからアカウント名が一致し、パスワードも一致するアカウントIDを表示。
			String sql = "SELECT 性別, 生年月日, 職業, 在住都道府県, パーソナルタグ,"
					+ " 興味のあるジャンル, 好きな作家, お気に入り1位,"
					+ " お気に入り2位, お気に入り3位 FROM プロフィール WHERE アカウントID = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, accountID);
			
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表にあるアカウントIDをaccountIDインスタンスに保存。
			if(rs.next()) {
				String gender = rs.getString("性別");
				Date birthday = rs.getDate("生年月日");
				String profession = rs.getString("職業");
				String prefectures = rs.getString("在住都道府県");
				String keyword = rs.getString("パーソナルタグ");
				String genru = rs.getString("興味のあるジャンル");
				String author = rs.getString("好きな作家");
				String book_1 = rs.getString("お気に入り1位");
				String book_2 = rs.getString("お気に入り2位");
				String book_3 = rs.getString("お気に入り3位");
				
				profile = new ProfileBean(gender, birthday, profession, prefectures,
						keyword, genru, author, book_1, book_2, book_3);
			}
			
			return profile; 
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}