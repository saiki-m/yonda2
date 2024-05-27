CREATE TABLE プロフィール (プロフィールID INTEGER  NOT NULL  AUTO_INCREMENT, 
                           性別 VARCHAR(2),
                           生年月日 DATE,
                           職業 VARCHAR(100), 
                           在住都道府県 VARCHAR(100), 
                           パーソナルタグ VARCHAR(100), 
                           興味のあるジャンル VARCHAR(100), 
                           好きな作家 VARCHAR(100), 
                           お気に入り1位 VARCHAR(100), 
                           お気に入り2位 VARCHAR(100), 
                           お気に入り3位 VARCHAR(100),
                           
                           PRIMARY KEY (プロフィールID)
);


INSERT INTO プロフィール(性別, 生年月日, 職業, 在住都道府県, パーソナルタグ, 
                         興味のあるジャンル, 好きな作家, 
                         お気に入り1位, お気に入り2位, お気に入り3位)
     VALUES ('男', '20000101', '学生', '福岡', 'ミステリー好き', 'ミステリー', '東野圭吾', 
             '容疑者Xの献身', 'マスカレード・ホテル', '探偵ガリレオ'),
            ('女', '20000101', '学生', '大阪', '読書家、純愛', '恋愛', '辻村深月', 
             '傲慢と善良', '君の膵臓をたべたい', '阪急電車'),
            ('男', '20000101', '学生', '福岡', 'ミステリー好き', 'ミステリー', '東野圭吾', 
             '容疑者Xの献身', 'マスカレード・ホテル', '探偵ガリレオ3'),
            ('男', '20000101', '学生', '福岡', 'ミステリー好き', 'ミステリー', '東野圭吾', 
             '容疑者Xの献身', 'マスカレード・ホテル', '探偵ガリレオ4'),
             ('男', '20000101', '学生', '福岡', 'ミステリー好き', 'ミステリー', '東野圭吾', 
             '容疑者Xの献身', 'マスカレード・ホテル', '探偵ガリレオ5'),
             ('男', '20000101', '学生', '福岡', 'ミステリー好き', 'ミステリー', '東野圭吾', 
             '容疑者Xの献身', 'マスカレード・ホテル', '探偵ガリレオ6');
            



CREATE TABLE アカウント (アカウントID INTEGER  NOT NULL  AUTO_INCREMENT,
                         アカウント名 VARCHAR(100)  NOT NULL,
                         パスワード VARCHAR(100) NOT NULL,
                         メールアドレス VARCHAR(100)  NOT NULL,
                         秘密の質問 VARCHAR(100)  NOT NULL,
                         プロフィールID INTEGER  NOT NULL,
                         
                         PRIMARY KEY (アカウントID),                                            -- 主キーの設定
                         FOREIGN KEY (プロフィールID) REFERENCES プロフィール(プロフィールID)   -- 外部キーの設定
                         );
                         
                         
                         
INSERT INTO アカウント(アカウント名, パスワード, メールアドレス, 秘密の質問, プロフィールID)
     VALUES ('test1', 11, 'test1@gmail.com', 'マスカレード・ホテル', 1),
            ('test2', 22, 'test2@gmail.com', '福岡大学', 2),
            ('test3', 33, 'test3@gmail.com', 'カレー', 3),
            ('test4', 44, 'test4@gmail.com', 'アイス', 4),
            ('test5', 55, 'test5@gmail.com', '片縄小学校', 5),
            ('test6', 66, 'test6@gmail.com', '告白', 6),
            


CREATE TABLE ジャンル (ジャンルID  INTEGER  NOT NULL  AUTO_INCREMENT,
                       ジャンル VARCHAR(100)  NOT NULL,
                       
                       PRIMARY KEY (ジャンルID)
                       );
                       
INSERT INTO ジャンル(ジャンル)
     VALUES ('ミステリー'), ('SF'), ('恋愛'), ('ファンタジー'), ('歴史'),
            ('政治'), ('経済'), ('ライトノベル'), ('青春'), ('児童');
                                   

            
CREATE TABLE 作者 (作者ID INTEGER  NOT NULL  AUTO_INCREMENT, 
                   作者 VARCHAR(100)  NOT NULL,
                   
                   PRIMARY KEY (作者ID)
);

INSERT INTO 作者(作者)
     VALUES ('東野 圭吾'), ('湊 かなえ'), ('有川 浩'), 
            ('辻村 深月'), ('宮部 みゆき'), ('池井戸 潤'),
            ('J・D・サリンジャー');
            
            
            
CREATE TABLE 訳者 (訳者ID INTEGER  NOT NULL  AUTO_INCREMENT,
                   訳者 VARCHAR(100)  NOT NULL,
                   
                   PRIMARY KEY (訳者ID) 
);



INSERT INTO 訳者(訳者)
     VALUES ('なし'), 
            ('村上春樹'), 
            ('鴻巣 友季子'), 
            ('工藤 精一郎'), 
            ('福田 恆存'), 
            ('村岡 花子'),
            ('河野 万里子');



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
                   
                   
                   
INSERT INTO 書籍(タイトル, ジャンルID, 作者ID, 
                 訳者ID, 出版社, 媒体, 金額, 版数)
     VALUES ('容疑者Xの献身', 1, 1, 1, '文藝春秋', '文庫本', 100, 1),
            ('傲慢と善良', 3, 4, 1, '朝日新聞出版', '単行本', 1600, 1),
            ('告白', 1, 2, 1, '双葉社', '電子書籍', 650, 3)
            ('キャッチャー・イン・ザ・ライ', 9, 7, 2, '白水社', '電子書籍', 650, 3)
            ;
                 

CREATE TABLE 読書記録 (記録ID INTEGER  NOT NULL  AUTO_INCREMENT,
                       書籍ID INTEGER  NOT NULL,
                       アカウントID INTEGER  NOT NULL,
                       感想 VARCHAR(100),
                       入手日 DATE,
                       開始日 DATE,
                       終了日 DATE,
                       回数 INTEGER(100), 
                       点数 INTEGER(100),
                       読書状況 VARCHAR(100),
                       メモ VARCHAR(100),
                       公開 BOOLEAN,
                       
                       PRIMARY KEY (記録ID),
                       FOREIGN KEY (書籍ID) REFERENCES 書籍(書籍ID),
                       FOREIGN KEY (アカウントID) REFERENCES アカウント(アカウントID) 
                       );


INSERT INTO 読書記録(書籍ID, アカウントID, 感想, 入手日, 開始日, 
                     終了日, 回数, 点数, 読書状況, メモ, 公開)
     VALUES (1, 1, '面白かった！', '2024-01-01', '2024-01-02', '2024-02-01',
             1, 8, '読み終わった', 'テスト', True 
            );