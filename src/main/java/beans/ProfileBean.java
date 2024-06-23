//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」

package beans;

import java.io.Serializable;
import java.sql.Date;

public class ProfileBean implements Serializable{
	private int profileID;
	private String gender;
	private Date birthday;
	private String profession;
	private String prefectures;
	private String keyword;
	private String genru;
	private String author;
	private String book_1;
	private String book_2;
	private String book_3;
	private String[] strProfileInfo;
	
	
	public ProfileBean() { }
	
	
	//プロフィール登録用
	public ProfileBean(String gender, Date birthday, String profession, String prefectures,
			String keyword, String genru, String author, String book_1, String book_2, String book_3) {
		
		this.gender = gender;
		this.birthday = birthday;
		this.profession = profession;
		this.prefectures = prefectures;
		this.keyword = keyword;
		this.genru = genru;
		this.author = author;
		this.book_1 = book_1;
		this.book_2 = book_2;
		this.book_3 = book_3;
	}
	
	
	public ProfileBean(Date birthday, String[] strProfileInfo) {
		this.birthday = birthday;
		this.strProfileInfo = strProfileInfo;
	}

	//ゲッター
	public int getProfileID() {return profileID;}

	public String getGender() {return gender;}

	public Date getBirthday() {return birthday;}

	public String getProfession() {return profession;}

	public String getPrefectures() {return prefectures;}

	public String getKeyword() {return keyword;}

	public String getGenru() {return genru;}

	public String getAuthor() {return author;}

	public String getBook_1() {return book_1;}

	public String getBook_2() {return book_2;}

	public String getBook_3() {return book_3;}

	public String[] getStrProfileInfo() {return strProfileInfo;}
	
}