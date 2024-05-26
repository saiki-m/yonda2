//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」


package beans;

import java.io.Serializable;

public class ReadingRecBean implements Serializable{
  private String title;
  private String author;
  private String readStatus;
  
  
  public ReadingRecBean() { }
    
  //本棚に本を新規登録
  public ReadingRecBean(String title, String author, String readStatus) {
    this.title = title;
    this.author = author;
    this.readStatus = readStatus;
    
  }
  
  

  //ゲッターとセッター
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  
  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }
  
  public String getReadStatus() { return readStatus; }
  public void setReadStatus(String readStatus) { this.readStatus = readStatus; }
  
  
}