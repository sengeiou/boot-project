/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.48 : Database - dp-lte-boot
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = '' */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`tyb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tyb`;

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `tyb_han_dan_pai_hang`;

/*   private String title;
        private String productType;
        private String orderTime;
        private String point;
        private String profit;*/
CREATE TABLE `tyb_han_dan_pai_hang` (
  `id`          bigint(100)  NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(20)        DEFAULT NULL COMMENT '讲师名称',
  `product_type` VARCHAR(50)        DEFAULT NULL COMMENT '产品类型',
  `order_time`   VARCHAR(200)       DEFAULT NULL COMMENT '喊单时间',
  `point`       VARCHAR(500)       DEFAULT NULL COMMENT '盈利单位',
  `profit`      VARCHAR(11)        DEFAULT NULL COMMENT '盈利点',
  #   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  #   `updata_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updata_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8  COMMENT = '老师喊单排行表';

/*Data for the table `sys_menu` */
INSERT INTO tyb_han_dan_pai_hang (title, product_type, order_time, point, profit)
VALUES ('鬼师老师', '现货铜', '23:05', '31512', '454.3%'),
  ('德利老师', '现货银', '23:05', '31512', '232.3%'),
  ('鬼师老师', '白金铜', '12:05', '21312', '345.3%'),
  ('小徐老师', '现货铜', '08:05', '12122', '45.3%'),
  ('小王老师', '现货银', '09:05', '34334', '343.3%'),
  ('鬼师老师', '现货铜', '23:05', '23223', '220.3%'),
  ('大大老师', '现货铜', '10:05', '56766', '78.3%'),
  ('小王老师', '现货铜', '11:05', '67887', '89.3%'),
  ('嘻嘻老师', '现货铜', '23:05', '45434', '56.3%'),
  ('大兵老师', '现货铜', '21:05', '12131', '23.3%');

/*
创建脚本
1.PRIMARY  KEY（主键索引）
mysql>ALTER  TABLE  `table_name`  ADD  PRIMARY  KEY (  `column`  )
2.UNIQUE(唯一索引)
mysql>ALTER  TABLE  `table_name`  ADD  UNIQUE (`column` )
3.INDEX(普通索引)
mysql>ALTER  TABLE  `table_name`  ADD  INDEX index_name (  `column`  )
4.FULLTEXT(全文索引)
mysql>ALTER  TABLE  `table_name`  ADD  FULLTEXT ( `column` )
5.多列索引 多列索引
mysql>ALTER  TABLE  `table_name`  ADD  INDEX index_name (  `column1`,  `column2`,  `column3`  )*/

/*普通索引：最基本的索引，没有任何限制
唯一索引：与"普通索引"类似，不同的就是：索引列的值必须唯一，但允许有空值。
主键索引：它 是一种特殊的唯一索引，不允许有空值。
全文索引：仅可用于 MyISAM 表，针对较大的数据，生成全文索引很耗时好空间。
组合索引：为了更多的提高mysql效率可建立组合索引，遵循”最左前缀“原则。*/

/*  private String nickname;
        private String mobile;
        private String photo;
        private int ispush;*/
CREATE TABLE `tyb_user` (
  `id` INT(100)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nick_name` VARCHAR(20)  DEFAULT NULL COMMENT '用户昵称',
  `phone`   VARCHAR(20)  DEFAULT NULL COMMENT '电话号码',
  `password` VARCHAR(40)  DEFAULT NULL COMMENT '用户密码 MD5加密串',
  `phone_url`    VARCHAR(300)  DEFAULT NULL COMMENT '头像链接',
  `push_status`    INT(1)      DEFAULT 1 COMMENT '是否推送 默认1推送 0不推送',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() comment '创建时间',
  `updata_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
   unique key `phone_index` (`phone`) using btree comment '唯一索引',
   PRIMARY KEY (`id`)
)
  ENGINE = InnoDB AUTO_INCREMENT = 1  DEFAULT CHARSET = utf8 COMMENT = '用户信息表';
/*unique index 'phone_index'(phone) using btree , 错误语法*/
#xzm123456加密而成
INSERT INTO tyb_user (nick_name, phone, password, phone_url, push_status)
  VALUE ('小徐投资', '18907447909','81fe6fadfa9dbc75264f5bcb7b2f73ac',null , 1);

update tyb_user set phone_url ='https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/avatar/user1.png' where phone
                                                                                                              =18907447909;
update tyb_user set phone_url ='http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/avatar/user1.jpg' where phone =
                                                                                                              18574403920;
CREATE TABLE `tyb_user_group` (
  `id`     INT(11)     NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group`  int(1)       DEFAULT 1 COMMENT '用户等级默认 1级 1 2 3 等级（分别黄金 白银 青铜）',
  `user_phone` VARCHAR(11)  DEFAULT NULL COMMENT '用户的手机号',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `updata_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT = '用户等级表';
INSERT INTO tyb_user_group (`group`, user_phone) VALUE (1, '18907447909');


CREATE TABLE `tyb_zi_xun` (
  `id`        INT(11)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type`      int(2)   DEFAULT 1 COMMENT '1财经要闻 2研究报告 3独家解读 4市场动态',
  `title`     VARCHAR(50)     DEFAULT 1 COMMENT '用户等级默认 1级',
  `description`    VARCHAR(200) DEFAULT NULL COMMENT '手机号',
  `url`    VARCHAR(100) DEFAULT NULL COMMENT 'app前端webView跳转的url',
  `create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `updata_time` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT = '新闻咨询表';

INSERT INTO tyb_zi_xun (type, title, description, url)
  VALUE
  (1, '美股全线高开道指涨逾100点Sprint股价开盘大跌','【美股全线高开道指涨逾100点 Sprint股价开盘大跌10%】东方财富网30日讯，美东时间周一，美股三大股指集体高开，道指涨逾100点',''),
  (1, '中国4月官方制造业PMI为51.4% 非制造业PMI为54.8%','【中国4月官方制造业PMI为51.4%】东方财富网30日讯，国家统计局公布数据显示，中国4月官方制造业PMI为51.4%，连续21个月位于荣',''),
  (1, '香港恒生指数高开高走收涨1.74% 同股不同权制度今起','【香港恒生指数高开高走收涨1.74%】香港恒生指数高开高走，随后震荡拉升，截止收盘，恒生指数涨1.74%，报30808.45点。同股不同权制.',''),
  (1, '港交所主席史美伦：5月中会见中国证监会商讨CDR等议','【港交所主席史美伦：5月中会见中国证监会商讨CDR等议题】内地在今年初着手推出CDR，吸引海外挂牌的科技巨企回国。港交所新任主席史美伦承认',''),
  (1, '证监会副主席方星海：金融业对外开放有风险 但能管理','【证监会副主席方星海：金融业对外开放有风险 但能管理好】证监会副主席方星海在回答清华大学教授李稻葵“中国金融领域包括证券界是不是做好了充分准',''),
  (1, '2017年中国上市公司500强榜单出炉！你们家公司排第','【2017年中国上市公司500强榜单出炉！你们家公司排第几？】A股上市公司2017年年报已全部披露，中国上市公司500强榜单也随之揭晓。',''),
  (1, '李克强：力争三季度末小微企业融资成本有较明显降低','【李克强：力争三季度末小微企业融资成本有较明显降低】李克强总理在4月25日的国务院常务会议上说，力争到三季度末小微企业融资成本有较明显降低',''),
  (1, '5月市场策略前瞻：A股纳入MSCI临近传递四大信号','【5月市场策略前瞻：A股纳入MSCI临近传递四大信号 机会大于风险】中金公司表示，尽管当前市场悲观情绪弥漫，对增长、市场前景偏谨慎的观点占主...',''),
  (2, '外资可控股境内券商 合资券商牌照松绑：狼来了','【外资可控股境内券商合资券商牌照松绑：狼来了？未必】自中国加入WTO以来，在金融行业叫嚣的“狼来了”，今日终于在证券行业全面打开了大门：',''),
  (2, '一行两会设正负面清单 严管金融机构股东','【一行两会设正负面清单 严管金融机构股东】4月27日，人民银行、银保监会和证监会联合印发了《关于加强非金融企业投资金融机构监管的指导意见》',''),
  (3, '93券商资管业务收入全榜单：一线梯队大洗牌 东方证券','【93券商资管业务收入全榜单：一线梯队大洗牌 东方证券第一】从东方证券年报披露的数据来看，其资产管理规模增长得很快，大增602.84亿。按类...',''),
  (3, '中国城市规划设计研究院院长谈雄安规划：让它成为生活','【中国城市规划设计研究院院长谈雄安规划：让它成为生活城市】国城市规划设计研究院院长杨保军称，当下中国大城市病蔓延，根子在于过于注重城市的经济..',''),
  (4, '银保监会：警惕一些保险从业人员违规销售非保险金融产','【银保监会：警惕一些保险从业人员违规销售非保险金融产品】中国银行保险监督管理委员会日前发布提示，近期一些保险从业人员假借介绍保险产品名义，向',''),
  (4, '滴滴“投资人”称被快车司机殴打 当事司机账户已被冻','【滴滴“投资人”称被快车司机殴打 当事司机账户已被冻结】昨天，一则《我被滴滴司机打得左眼软组织塌陷》的文章引起网友广泛关注。当事人张先生在接','');


CREATE TABLE `tyb_live_Top` (
  `id` INT(11)  NOT NULL AUTO_INCREMENT COMMENT '直播室id',
  `title` VARCHAR(10)  DEFAULT NULL COMMENT '名称',
  `live_url`   VARCHAR(200)  DEFAULT NULL COMMENT '跳转链接',
  `dian_zan_count` int(20)  DEFAULT NULL COMMENT '总点赞人数',
  `ad_text`    VARCHAR(10)  DEFAULT NULL COMMENT '广告按钮文字',
  `ad_url`    VARCHAR(200)      DEFAULT null COMMENT '广告按钮跳转的链接',
  `online_count`    int(20)      DEFAULT null COMMENT '直播室在线总人数',
  `handan_rate`    float(20)      DEFAULT null COMMENT '直播室喊单成功率',
  `ying_li`    float(20)      DEFAULT null COMMENT '直播室盈利点',
  `main_img`  VARCHAR(300)      DEFAULT null COMMENT '直播室主图',
  `sub_img`   VARCHAR(300)      DEFAULT null COMMENT '直播室字图',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() comment '创建时间',
  `updata_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB AUTO_INCREMENT = 1  DEFAULT CHARSET = utf8 COMMENT = '首页顶部直播室';
insert into tyb_live_Top(title, live_url, dian_zan_count, ad_text,ad_url, online_count,
                         handan_rate, ying_li, main_img, sub_img) value ('第一直播室',null,55213,'我要跟单',null,10034,0.93,
                                                                         3445.33,null,null ),
  ('第二财经室',null,34416,'我要跟单',null,34343,0.83,
   2645.67,null,null ),
  ('第三解读室',null,13213,'我要查看',null,23233,0.65,
   1245.14,null,null );


update tyb_live_Top set
  main_img='
http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/home/live_main_img.png' ,
  sub_img='
http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/home/live_main_img.png'
where id = 1;
update tyb_live_Top set
  main_img='http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/home/live_sub_img2.png' ,
  sub_img='http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/home/live_sub_img2.png'
where id = 2;
update tyb_live_Top set
  main_img='http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/home/live_sub_img3.jpeg' ,
  sub_img='http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/home/live_sub_img3.jpeg'
where id = 3;


CREATE TABLE `tyb_important_message` (
  `id`     INT(11)     NOT NULL AUTO_INCREMENT COMMENT 'id',
  `time`  datetime   NOT NULL DEFAULT current_timestamp() comment '时间',
  `autoid` VARCHAR(11)  DEFAULT NULL COMMENT '用户的手机号',
  `preValue` VARCHAR(11)  DEFAULT NULL COMMENT '前值',
  `annValue` VARCHAR(11)  DEFAULT NULL COMMENT '实值',
  `day` VARCHAR(11)  DEFAULT NULL COMMENT '用户的手机号',
  `name` VARCHAR(11)  DEFAULT NULL COMMENT '名称',
  `importence` VARCHAR(40)  DEFAULT NULL COMMENT '重要信息提示',
  `question` VARCHAR(40)  DEFAULT NULL COMMENT '重要话题',
  `imageUrl` VARCHAR(100)  DEFAULT NULL COMMENT '用户的手机号',
  `goodPers` int(11)  DEFAULT NULL COMMENT '用户的手机号',
  `badPers` int(11)  DEFAULT NULL COMMENT '用户的手机号',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `updata_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT = '直播首页重要消息表';
insert into tyb_important_message(time, autoid, preValue, day, name, importence, question, annValue, imageUrl, goodPers, badPers) value
  ('2018-05-06 11:12:44','12','31','34','哈哈','2','黄金正处”卧薪尝胆“时期 有望触及五年高点','43','http://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/home/live_sub_img2.png'
  ,56,67);

CREATE TABLE `tyb_teacher` (
  `id`     INT(11)     NOT NULL AUTO_INCREMENT COMMENT 'id',
  `thumb`  VARCHAR(100)   DEFAULT  null comment '老师头像',
  `teacher_name` VARCHAR(11)  DEFAULT NULL COMMENT '老师名字',
  `dian_zan_count` int(11)  DEFAULT NULL COMMENT '点赞数量',
  `hdcgl` float(11)  DEFAULT NULL COMMENT 'xxx',
  `profit` float(11)  DEFAULT NULL COMMENT '盈利率',
  `gen_dan_count` VARCHAR(40)  DEFAULT NULL COMMENT '跟单人数',
  `pin_zhong` VARCHAR(40)  DEFAULT NULL COMMENT '是哪一种品种 /长江银',
  `cang_wei` float(11)  DEFAULT NULL COMMENT '仓位数',
  `dian_wei` float(11)  DEFAULT NULL COMMENT '点位数',
  `shou_yi` float(11)  DEFAULT NULL COMMENT '收益率',
  `content` varchar(200)  DEFAULT NULL COMMENT '内容简介',
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `updata_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB  AUTO_INCREMENT = 200  DEFAULT CHARSET = utf8  COMMENT = '老师表';
insert into tyb_teacher(thumb, teacher_name, dian_zan_count, hdcgl, profit, gen_dan_count, pin_zhong, cang_wei, dian_wei, shou_yi, content) value
  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher1.jpg', '殷昕桐',53243, 12.6,95.2,34355,
    '现货铜',45.2,121.2,211.7,'分享国际理财资讯，将自己的投资经验和观念与大家一起分享'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher2.png', '王瑜铖',43243, 34.3,90.4,23378,
    '黄金',41.2,123.4,232.2,'多年从事外汇，国际现货行情分析，个人投资多年。专注投资交流和投资操作指导工作。'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher3.jpg',  '于昌佚',56577, 78.3,56.4,56568,
    '美原油',23.2,322.4,534.3,'入行7年载，有自己的专业团队支撑。专注于教导投资贵金属，美原油，外汇，各种金融投资产品的技术指导'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher4.jpg','彭金诚',342335, 56.3,90.4,23378,
    '黄金',56.2,566.4,777.6,'主要从事现货黄金、白银、原油、沥青投资的分析与研究工作， 实战经验丰富，擅长各种技术指标的综合运用，结合消息面的解读，在行情分析及实际操盘上形成了一套行之有效的交易方式。'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher5.jpg','王瑜铖',43243, 78.3,90.4,44434,
    '黄金',79.2,333.4,345.8,'于2008年进入证劵股票市场,恰逢遇上金融危机全面爆发,2009年转入贵金属投资。入行时至今日，脚踏实地的成为了一名经验老道的黄金分析师。'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher6.jpg','靳婼汐',23243, 54.3,90.4,55677,
    '黄金',56.2,123.4,845.3,'多家知名财经网站特约撰稿人，擅长于各技术指引！对行情有独特的个人看法。'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher7.jpg','超绝金评',34246, 76.3,90.4,34656,
    '黄金',66.2,123.4,545.8,'金融分析师，现从事贵金属（金银）交易，原油（wti）投资，外汇及指数等投资分析指导，在现货领域有长期实际的操作交易经验，深刻掌握K线、RSI、MACD等技术指标。'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher8.jpg','李韬展',53244, 89.3,90.4,23233,
    '黄金',78.2,545.4,546.7,'擅长运用三大系统—K线系统、江恩理论、指标系统判断进场以及出场点， 发布的观点在行业内具有一定的权威性'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher9.png','梁孟梵',63243, 43.3,90.4,54344,
    '黄金',56.2,156.6,676.6,'主要从事黄金白银原油行情研究。每天行情波折不断，我所能做的就是用我多年的研究经验，给大家帮助。'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher10.jpg','叶知洲',97243, 56.3,90.4,34545,
    '黄金',67.6,233.4,454.1,'笔者叶世诚是金融投资分析师，从事金融行业多年，研究国际局势和热点事件'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher11.jpg','李多颖',43243, 45.3,90.4,23254,
    '黄金',67.4,343.8,232.4,'出身于金融班科，从事股票，期货，证券，贵金属投资理财分析工作； 拥有多年在大宗商品市场的实战经验'),

  ('https://xzm1102207843.oss-cn-beijing.aliyuncs.com/tyb/teacher/teacher12.jpg','聚才鑫',53246, 76.3,90.4,12133,
    '黄金',77.2,565.7,121.7,'国家知名分析师，专注国际现货白银、黄金、原油分析。以独特的投资见解和极具实战价值的高质量博文而闻名，
    获得用户的极大认可。');

CREATE TABLE `tyb_user_gen_dan` (
  `id` INT(100)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_phone` VARCHAR(20)  DEFAULT NULL COMMENT '用户手机号',
  `teacher_id`    int(11)  DEFAULT NULL COMMENT '老师id',
  PRIMARY KEY (`id`),
  KEY `idx_user_phone` (`user_phone`),
  constraint`FK_user_phone` foreign key(`user_phone`) references `tyb_user`(`phone`) on delete no action on update no action

)  ENGINE = InnoDB AUTO_INCREMENT = 1  DEFAULT CHARSET = utf8 COMMENT = '用户跟单(订阅)表';

insert   into tyb_user_gen_dan(user_phone, teacher_id) value
  ('18907447909',201),
  ('18907447909',202),
  ('18907447909',205),
  ('18907447909',206),
  ('18907447909',209),
  ('18574403920',201),
  ('18574403920',205);

CREATE TABLE `tyb_teacher_han_dan` (
  `id`     INT(11)     NOT NULL AUTO_INCREMENT COMMENT '喊单编号',
  `kc_time`  datetime  DEFAULT current_timestamp() comment '开仓时间',
  `lei_xing` VARCHAR(5)  DEFAULT NULL COMMENT '买入还是卖出',
  `cang_wei` int(11)  DEFAULT NULL COMMENT '仓位数',
  `cang_wei_type` varchar(11)  DEFAULT NULL COMMENT '保留字段',
  `ping_zhong` varchar(11)  DEFAULT NULL COMMENT '品种类型',
  `kai_cang_jia` float(10)  DEFAULT NULL COMMENT '跟单人数',
  `zhi_sun_jia` float(10)  DEFAULT NULL COMMENT '是哪一种品种 /长江银',
  `zhi_yin_jia` float(10)  DEFAULT NULL COMMENT '仓位数',
  `remark` varchar(200)  DEFAULT NULL COMMENT '备注(老师对当前喊单的自我评价及风险评估)',
  `kai_cang_ce_lv` INT(11)  DEFAULT NULL COMMENT '开仓策略',
  `type` varchar(200)  DEFAULT NULL COMMENT '保留字段',
  `room_id` float(11)  DEFAULT NULL COMMENT '直播室(房间)ID',
/*  `teacher_name` varchar(200)  DEFAULT NULL COMMENT '老师名字',*/
  `status` int(2)  DEFAULT NULL COMMENT '前端平仓时加载不同item, 0表示已经平仓,1表示吗买入或者卖出',
  `teacher_id` int(11)  DEFAULT NULL COMMENT '老师id',
  `ping_cang_time` datetime  DEFAULT current_timestamp()  COMMENT '平仓时间',
  `ping_cang_jia` varchar(10)  DEFAULT NULL COMMENT '平仓价',
  `hl_dian` float(11)  DEFAULT NULL COMMENT '保留字段',
  `profit` float(11)  DEFAULT NULL COMMENT '收益率',
  /*`thumb` varchar(200)  DEFAULT NULL COMMENT '老师头像',*/
  `create_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `updata_time` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`),
  constraint`FK_teacher_id` foreign key(`teacher_id`) references `tyb_teacher`(`id`) on delete no action on update no action
) ENGINE = InnoDB  AUTO_INCREMENT = 1000  DEFAULT CHARSET = utf8 COMMENT='老师喊单表';

insert into tyb_teacher_han_dan
(kc_time, lei_xing, cang_wei, cang_wei_type, ping_zhong, kai_cang_jia, zhi_sun_jia, zhi_yin_jia, remark, kai_cang_ce_lv, type, room_id, status, teacher_id, ping_cang_time, ping_cang_jia, hl_dian, profit) value
  (now(),'买入',3543.2,null ,'长江油',23234.5,12134.7,11132,'行情快速下跌，企稳于264-265.5附近',null,null,1,
  1,201,null,null,null,67.3),
  (now(),'卖出',3543.2,null ,'现货铜',43234.1,12134.7,11132,'行情快速上跌，企稳于343-265.5附近',null,null,1,
   1,202,null,null,null,67.3),
  (now(),'平仓',3543.2,null ,'长江金',33234.3,12134.7,11132,'行情快速上跌，企稳于421-555.5附近',null,null,1,
   0,205,now(),43456.7,null,67.3),
  (now(),'平仓',3543.2,null ,'长江油',23234.7,12134.7,11132,'行情快速下跌，企稳于264-344.5附近','平','暂时保留字段',1,
   0,206,now(),34556.5,1111,67.3),
  (now(),'买入',2543,null ,'长江油',12122.6,12134.7,11132,'行情快速下跌，企稳于364-265.5附近',null,null,1,
   1,209,null,null,null,67.3);

#测试脚本sql
# select  id, user_phone, teacher_id from tyb_user_gen_dan where user_phone ='18907447909';
# select * from tyb_teacher where id in (201,202,205,206,209);
# select * from tyb_teacher where (id = 201 or id=202 or id =205 or id= 206 or id= 209);
# select * from tyb_teacher_han_dan where (teacher_id = 201 or teacher_id=202 or teacher_id =205 or teacher_id= 206 or teacher_id= 209);
# select * from tyb_teacher WHERE (id=? or id=? or id=? )

CREATE TABLE `tyb_user_kai_hu` (
  `id`  int(11)     not null auto_increment comment 'id',
  `user_name`  varchar(11)   default  null comment '用户姓名',
  `id_card` varchar(18)  default null comment '身份证号',
  `phone` varchar(11)  default null comment '手机号',
  `platform_code` varchar(11)  default null comment '开户机构代码/如:shxh(上海新华交易所)',
  `platform_name` varchar(11)  default null comment '开户机构名称',
  `create_time` datetime not null default current_timestamp() comment '创建时间',
  `updata_time` datetime not null default current_timestamp() comment '修改时间',
  primary key (`id`),
   key `idx_phone` (phone) using btree comment '手机号和身份证和开户码的组合索引',
   key `idx_id_card_phone_platform_code` (`id_card`,`phone`,platform_code) using btree comment '手机号和身份证和开户码的组合索引'
) ENGINE = InnoDB  AUTO_INCREMENT = 1  DEFAULT CHARSET = utf8  COMMENT = '开户表';

# 考虑到一个用户可能开多个交易所 这里采用普通索引的方式
#  ALTER TABLE tyb_user_kai_hu ADD UNIQUE key (`platform_code`);
#  ALTER TABLE `tyb_user_kai_hu` ADD UNIQUE key ( `column1`, `column2`, `column3` )
insert into tyb_user_kai_hu(user_name, id_card, phone, platform_code, platform_name) value
  ('徐宗萌','430821199309191615','18907447909','shxh','新华上海贵金属交易中心');
#测试脚本sql
# select * from tyb_user_kai_hu where phone ='18907447909';
# select * from tyb_user_kai_hu where id_card ='430821199309191615';
# select * from tyb_user_kai_hu where id_card ='430821199309191615' and phone='18907447909';

# INSERT INTO user_group(group,mobile) VALUE (3,'18574403920');
# /*!40101 SET SQL_MODE=@OLD_SQL_MODE */;  香港恒生指数高开高走收涨1.74% 同股不同权制度今起
# /*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
# /*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
# /*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;





#select id, kc_time, lei_xing, cang_wei, cang_wei_type, ping_zhong, kai_cang_jia, zhi_sun_jia, zhi_yin_jia, remark, kai_cang_ce_lv, type, room_id, status, teacher_id, ping_cang_time, ping_cang_jia, hl_dian, profit, create_time, updata_time from tyb_teacher_han_dan where ( teacherId=201 or teacherId=202 )