/*従業員テーブルのデータ(第三章で作成)*/
INSERT INTO employee(employee_id,employee_name,age) Values(1,'山田太郎',30);

/*ユーザーマスタのデータ(アドミン権限)*/
INSERT INTO m_user(user_id,password,user_name,birthday,age,marriage,role) VALUES('yamada@xxx.co.jp','password','山田太郎','1990-01-01',28,false,'ROLE_ADMIN');
