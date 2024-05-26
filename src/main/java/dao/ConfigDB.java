//https://www.sejuku.net/blog/24926
//https://magazine.techacademy.jp/magazine/9246

package dao;

public class ConfigDB{
  
   final String JDBC_URL = "jdbc:mysql://localhost:3306/yonda";
   final String DB_USER = "root";
   final String DB_PASS = "moo0921too";
   
   
   public void ReadJDBC_Driver() {
	 //MySQL用のJDBCドライバを読み込む
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
     }
     //JDBCドライバが読み込めないとき実行する    
     catch (ClassNotFoundException e) {
         throw new IllegalStateException("JDBCドライバを読み込めませんでした");
     }
	    
   }
}

