//https://www.sejuku.net/blog/24926
//https://magazine.techacademy.jp/magazine/9246

package model;

/**
 * パスワードのパターンマッチングを行う。
 * 英字の大文字、小文字、数字で4桁以上のパスワードになっているか確認する。
 * 戻り値； 
 */
public class ValidPassWord{
	
	public static boolean check(String password){
		
		return password.matches("[a-zA-Z0-9]{4,}"); 
	}
}