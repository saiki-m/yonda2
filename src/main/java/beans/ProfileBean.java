//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」

package beans;

import java.io.Serializable;
import java.sql.Date;

public class ProfileBean implements Serializable{
  private int profileID;
  private Date birthday;
  private String gender;
  private String profession;
  private String prefectures;
  private String keyword;
  private String genru_1;
  private String genru_2;
  private String genru_3;
  private String author_1;
  private String author_2;
  private String author_3;
  private String book_1;
  private String book_2;
  private String book_3;
  private String[] strProfileInfo;
  

  
  public ProfileBean() { }
  
  //プロフィール登録用
  public ProfileBean(Date birthday, String gender,
		             String profession, String prefectures, String keyword, 
		             String genru_1, String genru_2, String genru_3,
		             String author_1, String author_2, String author_3,
		             String book_1, String book_2, String book_3) {
    
    this.birthday = birthday;
    this.gender = gender;
    this.profession = profession;
    this.prefectures = prefectures;
    this.keyword = keyword;
    this.genru_1 = genru_1;
    this.genru_2 = genru_2;
    this.genru_3 = genru_3;
    this.author_1 = author_1;
    this.author_2 = author_2;
    this.author_3 = author_3;
    this.book_1 = book_1;
    this.book_2 = book_2;
    this.book_3 = book_3;
 
  }
  
  public ProfileBean(Date birthday, String[] strProfileInfo) {
	  this.birthday = birthday;
	  this.strProfileInfo = strProfileInfo;
  }
  
  //ゲッターとセッター
  public int getProfileID() { return profileID; }
  public void setProfileID(int profileID) { this.profileID = profileID; }
  
  public Date getBirthday() { return birthday; }
  public void setBirthday(Date birthday) { this.birthday = birthday; }
  
  public String getGender() { return gender; }
  public void setGender(String gender) { this.gender = gender; }
  
  public String getProfession() { return profession; }
  public void setProfession(String profession) { this.profession = profession; }
  
  public String getPrefectures() { return prefectures; }
  public void setPrefectures(String prefectures) { this.prefectures = prefectures; }
  
  public String getKeyword() { return keyword; }
  public void setKeyword(String keyword) { this.keyword = keyword; }
  
  public String getGenru_1() { return genru_1; }
  public void setGenru_1(String genru_1) { this.genru_1 = genru_1; }
  
  public String getGenru_2() { return genru_2; }
  public void setGenru_2(String genru_2) { this.genru_2 = genru_2; }
  
  public String getGenru_3() { return genru_3; }
  public void setGenru_3(String genru_3) { this.genru_3 = genru_3; }
  
  public String getAuthor_1() { return author_1; }
  public void setAuthor_1(String author_1) { this.author_1 = author_1; }

  public String getAuthor_2() { return author_2; }
  public void setAuthor_2(String author_2) { this.author_2 = author_2; }
  
  public String getAuthor_3() { return author_3; }
  public void setAuthor_3(String author_3) { this.author_3 = author_3; }
  
  public String getBook_1() { return book_1; }
  public void setBook_1(String book_1) { this.book_1 = book_1; }
  
  public String getBook_2() { return book_2; }
  public void setBook_2(String book_2) { this.book_2 = book_2; }
  
  public String getBook_3() { return book_3; }
  public void setBook_3(String book_3) { this.book_3 = book_3; }
  
  public String[] getStrProfileInfo() { return strProfileInfo; }
  public void setStrProfileInfo(String[] strProfileInfo) { this.strProfileInfo = strProfileInfo; }
}