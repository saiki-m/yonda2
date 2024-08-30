/* 読書状況テーブルの定義 */

CREATE TABLE 読書状況 (読書状況ID INTEGER  NOT NULL AUTO_INCREMENT,
                       アカウントID INTEGER NOT NULL, 
                       タイトル VARCHAR(100)  NOT NULL,
                       作者 VARCHAR(100) NOT NULL,
                       読書状況 VARCHAR(100)  NOT NULL,
                       入手日 DATE,
                       開始日 DATE,
                       終了日 DATE,
                       回数 INTEGER,
                       点数 INTEGER,
                       メモ VARCHAR(1000),
                       感想 VARCHAR(3000),
                       公開 BOOLEAN,
                       
                       PRIMARY KEY (読書状況ID),
                       FOREIGN KEY (アカウントID) REFERENCES アカウント(アカウントID)
                       );

/* 読書状況テーブルのサンプルデータ */
INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("容疑者Xの献身", "東野圭吾", "感想を書いた");
     
INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("傲慢と善良", "辻村深月", "いま読んでいる");
     
INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("告白", "湊かなえ", "読み終わった");
     
INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("キャッチャー・イン・ザ・ライ", "J・D・サリンジャー", "いま読んでいる");
     
INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("老人と海", "アーネスト・ヘミングウェイ", "積読");

INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("沈黙", "遠藤周作", "感想を書いた");     
     
INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("わかったさんのクッキー", "寺村輝夫", "読み終わった");

INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("星の王子さま", "アントワーヌ・ド・サン＝テグジュペリ", "感想を書いた");

INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("戦争は女の顔をしていない", "スヴェトラーナ・アレクシエーヴィチ", "読み終わった");
       
INSERT INTO 読書状況(タイトル, 作者, 読書状況)
     VALUES ("夜明けのすべて", "瀬尾まいこ", "読みたい");
     
     