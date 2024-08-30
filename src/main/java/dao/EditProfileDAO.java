//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import static model.ConfigDB.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

//アカウント情報をアカウントテーブルに新規登録するDAO
//サンプルデータがアカウントテーブルに登録されていなかったらエラーになる。
//configDB.javaを継承
public class EditProfileDAO {

	public void update(Map<String, String> info, Date birthday, int accountID) {

		ReadJDBC_Driver();

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE プロフィール SET 性別 = ?, 生年月日 = ?, 職業 = ?, 在住都道府県 = ?, "
					+ "パーソナルタグ = ?, 興味のあるジャンル = ?, 好きな作家 = ?, お気に入り1位 = ?,"
					+ " お気に入り2位 = ?, お気に入り3位 = ? WHERE アカウントID = ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, info.get("gender"));
			pStmt.setDate(2, birthday);
			pStmt.setString(3, info.get("profession"));
			pStmt.setString(4, info.get("prefectures"));
			pStmt.setString(5, info.get("keyword"));
			pStmt.setString(6, info.get("genru"));
			pStmt.setString(7, info.get("author"));
			pStmt.setString(8, info.get("book_1"));
			pStmt.setString(9, info.get("book_2"));
			pStmt.setString(10, info.get("book_3"));
			pStmt.setInt(11, accountID);

			pStmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}