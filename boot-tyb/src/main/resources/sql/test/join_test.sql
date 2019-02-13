
 DROP TABLE IF EXISTS student;
CREATE TABLE student (
  id INTEGER (11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(40) NOT NULL,
  age INT(40) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





DROP TABLE IF EXISTS mark;
CREATE TABLE mark (
  id INTEGER (11) NOT NULL AUTO_INCREMENT,
  mark int(40) NOT NULL,
  studentid INTEGER(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 INSERT INTO student values (1,'小王',16);
 INSERT INTO student values (2,'小红',45);
 INSERT INTO student values (3,'张明',45);
 INSERT INTO student values (4,'小李子',87);
 INSERT INTO student values (5,'王强',58);


 INSERT INTO mark values (1,61,2);
 INSERT INTO mark values (2,45,2);
 INSERT INTO mark values (3,58,3);


#  一、内连接-inner jion :
#  最常见的连接查询可能是这样，查出学生的名字和成绩：
 select s.name,m.mark from student s,mark m where s.id=m.studentid;
#  上面就是我们最常见的inner join，即内连接，把符合student.id=mark.studentid 条件的元组才选出来，也可以写成：
 select s.name,m.mark from student s inner join mark m on s.id=m.studentid;


#  二、左连接-left join:
#  左连接是把左边的表的元组全部选出来：
 select s.name,m.mark from student s left join mark m on s.id=m.studentid;


#  三、右连接-right join:
#  右连接就是把右边表的数据全部取出，不管左边的表是否有匹配的数据：
 select s.name,m.mark from student s right join mark m on s.id=m.studentid;

#  四、全连接-full join:
#  把左右两个表的数据都取出来，不管是否匹配：
#  select s.name,m.mark from student s full join mark m on s.id=m.studentid;