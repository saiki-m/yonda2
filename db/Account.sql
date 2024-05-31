CREATE TABLE アカウント (アカウントID INTEGER  NOT NULL AUTO_INCREMENT,
アカウント名 VARCHAR(100)  NOT NULL UNIQUE,
パスワード VARCHAR(100) NOT NULL,
メールアドレス VARCHAR(100)  NOT NULL,
秘密の質問 VARCHAR(100)  NOT NULL,
プロフィールID INTEGER,
PRIMARY KEY (アカウントID),
FOREIGN KEY (プロフィールID) REFERENCES プロフィール(プロフィールID)
);

INSERT INTO アカウント(アカウント名, パスワード, メールアドレス, 秘密の質問, プロフィールID)
     VALUES ('test1', 11, 'test1@gmail.com', 'マスカレード・ホテル', 1),
            ('test2', 22, 'test6@gmail.com', '告白', 2);