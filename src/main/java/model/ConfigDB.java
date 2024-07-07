//https://www.sejuku.net/blog/24926
//https://magazine.techacademy.jp/magazine/9246

package model;

public class ConfigDB{
	
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/yonda";
	public static final String DB_USER = "root";
	public static final String DB_PASS = "moo0921too";
	
	public static void ReadJDBC_Driver() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");    //MySQL用のJDBCドライバを読み込む
		}
		catch (ClassNotFoundException e) {    
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
	}
}