#============================ 数据库操作===========================

CREATE DATABASE  mydb1;
SHOW  DATABASES ;
#创建一个使用utf-8字符集的mydb2数据库。
CREATE  DATABASE  mydb2 CHARACTER SET  utf8;

#创建一个使用utf-8字符集，并带校对规则的mydb3数据库。
CREATE  DATABASE  mydb3 CHARACTER SET utf8 COLLATE  utf8_general_ci;

#查看前面创建的mydb2数据库的定义信息
SHOW  CREATE  DATABASE  mydb3;

#删除前面创建的mydb1数据库
DROP DATABASE  mydb1;

#查看服务器中的数据库，并把其中某一个库的字符集修改为gb2312;
ALTER  DATABASE  mydb2 CHARACTER SET  gb2312;
SHOW CREATE DATABASE mydb2;

#使用当前数据库 mydb1,即想对当前数据库进行操作之前使用的命令
USE  mydb2;

#============================ 1>  表的创建演示===========================

CREATE  TABLE  employer_user (
  id int,
  name varchar(40),
  sex varchar(4),
  birthday date,
  entry_date date,
  job varchar(40),
  salary decimal(8,2),
  resume text
);

#查看库的所有表(查看库里的表要先打开库)
SHOW  TABLES ;

# 查看表的创建细节
SHOW  CREATE  TABLE  employee;
#看表结构
DESC  employee;
#============================  2>对表的基本操作：增、删、改、查====================

#在上面员工表的基本上增加一个image列。
ALTER  TABLE  employee  ADD   sex VARCHAR(20);
ALTER  TABLE  employee  ADD  COLUMN  images VARCHAR(204);
# 删除sex列
ALTER  TABLE  employee  DROP  images;

#修改job列，使其长度为60。
ALTER  TABLE  employee MODIFY  job VARCHAR(60);

#表名改为user。
RENAME TABLE  employee TO  user;
RENAME TABLE  user TO  employee;

#修改表的字符集为utf-8
ALTER  TABLE  employee CHARACTER SET  utf8;

#列名name修改为username
ALTER  TABLE   employee  CHANGE   COLUMN    name   username  VARCHAR(30) ;

#删除表
drop table user;



#============================  2>增加、插入记录的 sql 语句详细：===================

/**
 如果某列值为空 则插在mysql时
 */
INSERT  INTO  employee(id,name,birthday,entry_date,job,salary,resume)
values  (1,'aaa','1980-09-09','1980-09-09','bbb',90,'aaaaa');


#SELECT *FROM mydb2.employee;
#插入数据的细节1
#如果没有指定哪些列（字段）需要插入，则要指定全部字段值
INSERT INTO employee values(1,'aaa','1980-09-09','1980-09-09','bbb',90,'aaaaa','男');

#插入数据的细节2
insert into employee values('1','aaa','1980-09-09','1980-09-09','bbb','90','aaaaa','女');

# 插入数据的细节3(插入中文)
# 要告诉mysql客户采用gb2312编码
SHOW VARIABLES  LIKE  'chara%';
SET  CHARACTER_SET_CLIENT =gb2312;
INSERT  INTO  employee(id, name)  VALUES ('3','校长');

# 要想查看时不乱码

SHOW VARIABLES LIKE 'chara%';
SET CHARACTER_SET_RESULTS =gb2312;
SELECT * FROM employee;


#============================   4>删除记录的 sql 语句详细===================
#删除表中名称为’校长’的记录。
DELETE  FROM employee  WHERE   name='校长';

#删除表中所有记录。
DELETE  FROM  user;
# 使用truncate删除表中记录。
TRUNCATE  TABLE  user;

#============================   5>修改记录的 sql 语句详细 ===================
#将所有员工薪水修改为5000元。
UPDATE  employee SET  salary='5000';

#将姓名为’校长’的员工薪水修改为3000元。
UPDATE  employee SET salary='3000' WHERE name='校长';

#将姓名为’校长‘的员工薪水修改为4000元,job改为管理学生。
UPDATE  employee SET  salary='4000',job='管理学生' WHERE name='校长';

#将’校长‘的薪水在原有基础上增加3000元。
UPDATE  employee SET  salary=salary+3000 WHERE name='校长';

# # 更新要注意的问题 将校长降级为班主任 同时薪水也降低为6000    这条语句暂时有点问题
# UPDATE  employee SET  name='班主任',salary='6000',birthday='1988-06' WHERE name='校长';
# UPDATE  WHERE id=1;
