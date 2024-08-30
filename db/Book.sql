/* 書籍テーブルの定義 */

CREATE TABLE 書籍 (書籍ID INTEGER  NOT NULL  AUTO_INCREMENT,
                   タイトル VARCHAR(100)  NOT NULL,
                   ジャンルID INTEGER  NOT NULL,
                   作者ID INTEGER  NOT NULL,
                   訳者ID INTEGER  NOT NULL,
                   出版社 VARCHAR(100),
                   媒体 VARCHAR(100),
                   金額 INTEGER,
                   版数 INTEGER,
                   
                   PRIMARY KEY (書籍ID), 
                   FOREIGN KEY (ジャンルID) REFERENCES ジャンル(ジャンルID),
                   FOREIGN KEY (作者ID) REFERENCES 作者(作者ID),
                   FOREIGN KEY (訳者ID) REFERENCES 訳者(訳者ID)  
                   );
                   
                   
/* 書籍テーブルのサンプルデータ */

INSERT INTO 書籍(タイトル, ジャンルID, 作者ID, 
                 訳者ID, 出版社, 媒体, 金額, 版数)
     VALUES ('容疑者Xの献身', 1, 1, 1, '文藝春秋', '文庫本', 100, 1),
            ('傲慢と善良', 3, 4, 1, '朝日新聞出版', '単行本', 1600, 1),
            ('告白', 1, 2, 1, '双葉社', '電子書籍', 650, 3),
            ('キャッチャー・イン・ザ・ライ', 9, 7, 2, '白水社', '電子書籍', 650, 3);
                 