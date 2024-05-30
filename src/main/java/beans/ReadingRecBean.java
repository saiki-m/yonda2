//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」


package beans;

import java.io.Serializable;

public class ReadingRecBean implements Serializable{
  private int readingRecID;
  private String title;
  private String author;
  private String readStatus;
  private int count;
  private int point;
  private String impression;
  
  
  public ReadingRecBean() { }
    
  //ログイン時に本棚の内容を取得
  public ReadingRecBean(int readingRecID, String title, String author, String readStatus, int count, int point, String impression) {
    this.readingRecID = readingRecID;
	this.title = title;
    this.author = author;
    this.readStatus = readStatus;
    this.count = count;
    this.point = point;
    this.impression = impression;
    
  }
  
  //本棚に本を新規登録
  public ReadingRecBean(String title, String author, String readStatus, int count, int point, String impression) {
	    this.title = title;
	    this.author = author;
	    this.readStatus = readStatus;
	    this.count = count;
	    this.point = point;
	    this.impression = impression;
	    
	  }
  
  

  //ゲッターとセッター
  public int getReadingRecID() { return readingRecID; }
  public void setReadingRecID(int readingRecID) { this.readingRecID = readingRecID; }
  
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  
  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }
  
  public String getReadStatus() { return readStatus; }
  public void setReadStatus(String readStatus) { this.readStatus = readStatus; }
  
  public int getCount() { return count; }
  public void setCount(int count) { this.count = count; }

  public int getPoint() { return point; }
  public void setPoint(int point) { this.point = point; }
 
  public String getImpression() { return impression; }
  public void setImpression(String impression) { this.impression = impression; }
 
}