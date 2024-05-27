CREATE TABLE ジャンル (ジャンルID  INTEGER  NOT NULL  AUTO_INCREMENT,
                       ジャンル VARCHAR(100)  NOT NULL,
                       
                       PRIMARY KEY (ジャンルID)
                       );
                       
INSERT INTO ジャンル(ジャンル)
     VALUES ('ミステリー'), ('SF'), ('恋愛'), ('ファンタジー'), ('歴史'),
            ('政治'), ('経済'), ('ライトノベル'), ('青春'), ('児童');
                                   