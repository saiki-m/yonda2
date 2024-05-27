CREATE TABLE 作者 (作者ID INTEGER  NOT NULL  AUTO_INCREMENT, 
                   作者 VARCHAR(100)  NOT NULL,
                   
                   PRIMARY KEY (作者ID)
);

INSERT INTO 作者(作者)
     VALUES ('東野 圭吾'), ('湊 かなえ'), ('有川 浩'), 
            ('辻村 深月'), ('宮部 みゆき'), ('池井戸 潤'),
            ('J・D・サリンジャー');
