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