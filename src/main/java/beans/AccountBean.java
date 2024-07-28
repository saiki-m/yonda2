//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」

package beans;

import java.io.Serializable;

public class AccountBean implements Serializable{
	
	private int accountID;
	private String name;
	private String password;
	private String mailAd;
	private String secret_q;
	private int profileID;
	
	
	public AccountBean() { }
	
	//アカウント登録用
	public AccountBean(String name, String password, String mailAd, String secret_q) {
		
		this.name = name;
		this.password = password;
		this.mailAd = mailAd;
		this.secret_q = secret_q; 
	}
	
	//ログイン用
	public AccountBean(int accountID, String name, String password, String mailAd, String secret_q) {
		
		this(name, password, mailAd, secret_q);
		this.accountID = accountID;
	}

	
	//ゲッター
	public int getAccountID() { return accountID; }
	
	public String getName() { return name; }
	
	public String getPassword() { return password; }
	
	public String getMailAd() { return mailAd; }
	
	public String getSecret_q() { return secret_q; }
	
	public int getProfileID() { return profileID; }
}