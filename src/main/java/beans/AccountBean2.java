//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」


package beans;

import java.io.Serializable;
import java.sql.Date;

/**
 * フィールドにprofileBeanオブジェクトを入れる。has-aの関係。
 * 
 */
public class AccountBean2 implements Serializable{
	
	private int accountID;
	private String name;
	private String password;
	private String mailAd;
	private String secret_q;
	private ProfileBean profile;
	
	
	public AccountBean2() { }
	
	//アカウント登録用
	public AccountBean2(String name, String password, String mailAd, String secret_q) {
		this.name = name;
		this.password = password;
		this.mailAd = mailAd;
		this.secret_q = secret_q; 
	}
	
	//ログイン用
	public AccountBean2(int accountID, String name, String password, String mailAd, String secret_q) {
	    this.accountID = accountID;
	    this.name = name;
	    this.password = password;
	    this.mailAd = mailAd;
	    this.secret_q = secret_q;
	}
	
	
	//ゲッター
	public int getAccountID() { return accountID; }
	
	public String getName() { return name; }
	
	public String getPassword() { return password; }
	
	public String getMailAd() { return mailAd; }
	
	public String getSecret_q() { return secret_q; }
	
	public ProfileBean getProfile() { return profile; }
	
	
	//ProfileBeanのゲッター
	public int getProfileID() {return profile.getProfileID();}

	public String getGender() {return profile.getGender();}

	public Date getBirthday() {return profile.getBirthday();}

	public String getProfession() {return profile.getProfession();}

	public String getPrefectures() {return profile.getPrefectures();}

	public String getKeyword() {return profile.getKeyword();}

	public String getGenru() {return profile.getGenru();}

	public String getAuthor() {return profile.getAuthor();}

	public String getBook_1() {return profile.getBook_1();}

	public String getBook_2() {return profile.getBook_2();}

	public String getBook_3() {return profile.getBook_3();}

	public String[] getStrProfileInfo() {return profile.getStrProfileInfo();}

}