#查询city为上海的数据
# table是我们的表名，column是我们想要查询的字段／列，
# column可以用 * 代替，指代全部字段，意为从table表查询所有数据。
SELECT   companyFullName FROM dataanalyst WHERE city='上海';
SELECT   * FROM dataanalyst WHERE city='上海';


#
SELECT  * FROM dataanalyst WHERE city='上海' AND positionName='数据分析师';
# 查找城市为上海，或者职位名称是数据分析师的数据，它们是并集。
SELECT  * FROM dataanalyst  WHERE city='上海' OR positionName='数据分析师';

# 当我们涉及到非常复杂的与或逻辑判断，应该怎么办？
# 比如即满足条件AB，又要满足条件C，或者是满足条件DE。
# 此时需要用括号明确逻辑判断的优先级。

#  查找出上海的数据分析师或者是北京的产品经理。
# 当有括号时，会优先进行括号内的判断，当有多个括号时，对最内层括号先进行判断，然后依次往外
SELECT *FROM dataanalyst WHERE (city='上海' AND positionName='数据分析师') OR (city='北京' AND positionName='数据产品经理');

# 当我们要查询多个条件，比如北京上海广州深圳南京这些城市，难道一个个用and关联起来？这太麻烦了，我们可以使用 in 。
SELECT *FROM dataanalyst WHERE city IN ('北京','上海','广州','深圳','南京');  #这个最优选择语句
SELECT *FROM dataanalyst WHERE city ='北京' OR city ='上海'OR city ='广州'OR city ='深圳' OR city='南京';

# 当我们遇到字段数据类型是数值时，也可以使用符号> 、>=、< 、<=、!= 进行逻辑判断，!= 指的是不等于，等价于 <> 。
# 上例是筛选出公司ID >= 10000的职位 且小于50000，为数值时，不需要像字符串一样加引号。
SELECT *FROM dataanalyst WHERE companyId  >=10000 AND companyId<=50000;

#当我们需要取区间数值时，使用 between and 包括数值两端的边界，等同于 companyId >=10000 and companyId <= 20000
SELECT *FROM dataanalyst WHERE companyId BETWEEN 10000 AND 20000;

#如果要模糊查找，能用like。 含义是在positionName列查找包含「数据分析」字段的数据，%代表的是通配符，
# 含义是无所谓「数据分析」前面后面是什么内容。如果是 '数据分析%' ，则代表字段必须以数据分析开头，无所谓后面是什么。
SELECT *FROM  dataanalyst WHERE positionName LIKE '%数据分析%';
# 除了上面所讲，还有一个常用的语法是not，代表逻辑的逆转，常见not in、not like、not null等。

#接下来我们学习group by，它是数据分析中常见的语法，
# 目的是将数据按组／维度划分。类似于Excel中的数据透视表，我们以city为例。
SELECT  *  FROM dataanalyst GROUP BY  city;

# 使用count函数，统计计数了每个城市拥有的职位数量。括号里面的1代表以第一列为计数标准
SELECT city ,count(1) FROM dataanalyst GROUP BY city;
#查出结果
# 上海	980
# 北京	4177
# 南京	83
# 厦门	30
# 天津	20
# 广州	335
# 成都	135
# 杭州	407
# 武汉	69
# 深圳	527
# 苏州	37
# 西安	51
# 长沙	25

#当我们遇到重复数据怎么办？在DataAnalyst 这张表中，
# 北京职位包含重复的职位ID(positionId字段)，我们需要去重。 2575733
# 北京的数据一下子少了2000，多余的重复值被排除在外 distinct 是去重函数，
# distinct positionId 会只计算唯一的positionId个数。
# 日常工作中，活跃用户数、文章UV，都是用distinct 计算获得，这是唯一标示符ID的重要作用
# count，还有max，min，sum，avg等函数，也叫做聚合函数。用法和Excel没什么区别
SELECT city,count(DISTINCT positionId)  FROM dataanalyst  GROUP BY   city;

SELECT city, sum(DISTINCT positionId)  FROM dataanalyst  GROUP BY  city;

#当我们在group by 添加多个字段，它将以多维的形式进行数据聚合。 查询10
SELECT  city,workYear,count(DISTINCT positionId)  FROM dataanalyst GROUP BY  city,workYear;

# 比如我想统计各个城市中有多少数据分析职位，其中，电商领域的职位有多少，在其中的占比？
# industryField是公司的行业领域，虽然我们能用where like 计算出有几个电商的数据分析师，
# 但是占比的计算会比较麻烦，此时可以用if。 1表示true  0表示false
SELECT  if(industryField LIKE '%电子商务%',0,1 ) FROM dataanalyst;

SELECT  companyFullName, if(industryField LIKE '%电子商务%',0,1) FROM dataanalyst GROUP BY  city;


# 上面的公式利用if判断出哪些是电商行业的数据分析师，哪些不是。if函数中间的字段代表为true时返回的值，不过因为包含重复数据，
# 我们需要将其改成positionId。图片中第二个count我漏加distinct了。之后，用它与group by 组合就能达成目的了。

SELECT   city,
  count(DISTINCT positionId),
  count(DISTINCT if(industryField LIKE '%电子商务%',positionId,NULL))
FROM  dataanalyst
 GROUP BY city;

# 第一列数字是职位总数，第二列是电商领域的职位数，相除就是占比。记住，count是不论0还是1都会纳入计数，
# 所以第三个参数需要写成null，代表不是电商的职位就排除在计算之外。

# 上海	979	166
# 北京	2347	289
# 南京	83	24
# 厦门	30	3
# 天津	20	4
# 广州	335	71
# 成都	135	37
# 杭州	406	62
# 武汉	69	17
# 深圳	527	84
# 苏州	37	2
# 西安	38	4
# 长沙	25	8


# 接下来是新的问题，如果我想找出各个城市，数据分析师岗位数量在500以上的城市有哪些，应该怎么计算？有两种方法，
# 第一种，是使用having语句，它对聚合后的数据结果进行过滤。

SELECT city,count(DISTINCT positionId)  FROM dataanalyst GROUP BY city HAVING count(DISTINCT positionId)>=500;

# 我们将第一次查询获得的城市职位数的结果，看作一张新的表，利用as 将它命名为t1( table1 的简写)，
# 将职位数命名为一个新的字段counts。然后外面再套一层select 过滤出counts >=500。
# 这种查询方式就叫嵌套子查询，使用场景比较广泛，where 后面也能跟子查询。
SELECT  city,count(DISTINCT positionId) AS  counts FROM dataanalyst
GROUP BY city
ORDER BY  counts ; #DESC 将序  ASC升序 默认 ORDER BY函数默认升序

#我们再来熟悉SQL的常用函数，首先是时间。因为我们的练习数据中没有时间，首先用now创建出一个时间字段。获取当前系统时间
SELECT  now();

#week函数获得当前第几周，month函数获得当前第几个月。其余还包括，quarter，year，day，hour，minute。
select date(now());
select week(now());
select month(now());
select year(now());

#除了以上的日期表达，也可以使用dayofyear、weekofyear 的形式计算。它和上面的部分函数等价。
select week(now(),0);

#怎么对时间进行加减法呢？这时候靠date_add函数出马。 我们可以改变1为负数，达到减法的目的，
# 也能更改day为week、year等，进行其他时间间隔的运算。
# 如果是求两个时间的间隔，则是datediff(date1,date2)或者timediff(time1,time2)。
SELECT  date_add(date(now()),INTERVAL 1 DAY);

#最后是数据清洗类的函数。表示从salary字段开始取值 第二位
SELECT  left(salary,8) FROM dataanalyst;
#首先利用locate函数查找第一个k所在的位置。
SELECT  locate('k',salary),salary FROM dataanalyst;
#然后使用left函数截取薪水的下限。
SELECT  left(salary,locate('k',salary)),salary FROM dataanalyst;

#为了获得薪水的上限，要用substr函数，或者mid，两者等价。
#薪水上限的开始位置是「-」位置往后推一位。截取长度是整个字符串减去「-」所在位置，
# 刚好是后半段我们需要的内容，不过这个内容是包含「K」的，所以最后结果还得再减去1
SELECT  left(salary,locate('k',salary)-1) AS  bottomSalary,
  substr(salary,locate('-',salary)+1,length(salary)-locate('-',salary)-1) AS topSalary,+
    salary FROM dataanalyst
  WHERE salary NOT LIKE '%以上%';

SELECT   city ,workYear,avg((bottomSalary+topSalary)/2) AS  avgSalary
FROM (SELECT left(salary,locate('k',salary)-1) AS  bottomSalary,
  substr(salary,locate('-',salary)+1,length(salary)-locate('-',salary)-1)AS   topSalary,
        city,positionId,workYea
      FROM dataanalyst
  WHERE salary NOT LIKE '%以上%')  AS  t1

GROUP BY city,workYear ORDER BY  city ,avgSalary;


# select city,workYear,avg((bottomSalary+topSalary)/2) as avgSalary
# from (select left(salary,locate("K",salary)-1) as bottomSalary,
#              substr(salary,locate("-",salary)+1,length(salary)- locate("-",salary)-1) as topSalary,
#         city,positionId,workYear
#       from DataAnalyst
#       where salary not like '%以上%') as t1
# group by city,workYear
# order by city,avgSalary