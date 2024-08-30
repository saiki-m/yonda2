
/* アカウントテーブルの定義 */

CREATE TABLE アカウント (アカウントID INTEGER  NOT NULL AUTO_INCREMENT,
アカウント名 VARCHAR(100)  NOT NULL UNIQUE,
パスワード VARCHAR(100) NOT NULL,
メールアドレス VARCHAR(100)  NOT NULL,
秘密の質問 VARCHAR(100)  NOT NULL,
PRIMARY KEY (アカウントID)
);

/* アカウントテーブルのサンプルデータ */

INSERT INTO アカウント(アカウント名, パスワード, メールアドレス, 秘密の質問)
     VALUES ('test1', 11, 'test1@gmail.com', 'マスカレード・ホテル'),
            ('test2', 22, 'test6@gmail.com', '告白');