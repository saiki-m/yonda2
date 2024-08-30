/* 訳者テーブルの定義 */
CREATE TABLE 訳者 (訳者ID INTEGER  NOT NULL  AUTO_INCREMENT,
                   訳者 VARCHAR(100)  NOT NULL,
                   
                   PRIMARY KEY (訳者ID) 
);


/* 訳者テーブルのサンプルデータ */
INSERT INTO 訳者(訳者)
     VALUES ('なし'), 
            ('村上春樹'), 
            ('鴻巣 友季子'), 
            ('工藤 精一郎'), 
            ('福田 恆存'), 
            ('村岡 花子'),
            ('河野 万里子');
