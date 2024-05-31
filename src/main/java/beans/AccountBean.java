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
	    this.accountID = accountID;
	    this.name = name;
	    this.password = password;
	    this.mailAd = mailAd;
	    this.secret_q = secret_q;
  }
  
  
  //ゲッターとセッター
  public int getAccountID() { return accountID; }
  public void setAccountID(int accountID) { this.accountID = accountID; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
  
  public String getMailAd() { return mailAd; }
  public void setMailAd(String mailAd) { this.mailAd = mailAd; }
  
  public String getSecret_q() { return secret_q; }
  public void setSecret_q(String secret_q) { this.secret_q = secret_q; }
  
  public int getProfileID() { return profileID; }
  public void setProfileID(int profileID) { this.profileID = profileID; }
  
}