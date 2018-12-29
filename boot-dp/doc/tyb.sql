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
CREATE DATABASE /*!32312 IF NOT EXISTS */`dp-lte-boot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dp-lte-boot`;

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `tyb_Handan_pai_hang`;

/*   private String title;
        private String productType;
        private String orderTime;
        private String point;
        private String profit;*/
CREATE TABLE `tyb_Handan_pai_hang` (
  `id`          INT(100)  NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  `title`       VARCHAR(20)        DEFAULT NULL
  COMMENT '讲师名称',
  `productType` VARCHAR(50)        DEFAULT NULL
  COMMENT '产品类型',
  `orderTime`   VARCHAR(200)       DEFAULT NULL
  COMMENT '喊单时间',
  `point`       VARCHAR(500)       DEFAULT NULL
  COMMENT '盈利单位',
  `profit`      VARCHAR(11)        DEFAULT NULL
  COMMENT '盈利点',
  #   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  #   `updata_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `updata_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '老师喊单排行表';

/*Data for the table `sys_menu` */
INSERT INTO tyb_Handan_pai_hang (title, productType, orderTime, point, profit)
VALUES ('鬼师老师', '现货铜', '23:05', '31512', '220.3%'),
  ('大兵老师', '现货铜', '21:05', '315212', '223.3%');

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
  `u_id`        INT(100)  NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  `u_nickname`  VARCHAR(20)        DEFAULT NULL
  COMMENT '用户昵称',
  `u_mobile`    VARCHAR(20)        DEFAULT NULL
  COMMENT '电话号码',
  `u_password`  VARCHAR(20)        DEFAULT NULL
  COMMENT '用户密码',
  `u_photo`     VARCHAR(20)        DEFAULT NULL
  COMMENT '头像链接',
  `u_ispush`    INT(1)             DEFAULT 1
  COMMENT '是否推送 默认1推送',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `updata_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  INDEX (u_mobile),
  PRIMARY KEY (`u_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '用户信息表';

INSERT INTO tyb_user (u_nickname, u_mobile, u_password, u_photo, u_ispush) VALUE ('小徐', '18907447909', 'xzm123456','url', '1');
INSERT INTO tyb_user (u_nickname, u_mobile, u_password, u_photo, u_ispush) VALUE ('老王', '18574403920', 'xzm123456','url', '0');


CREATE TABLE `tyb_user_group` (
  `id`          INT(100)  NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  `group`       int(1)             DEFAULT 1
  COMMENT '用户等级默认 1级',
  `mobile`      VARCHAR(11)        DEFAULT NULL
  COMMENT '手机号',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `updata_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '用户等级表';
INSERT INTO user_group (mobile) VALUE ('18907447909');


CREATE TABLE `tyb_cai_jing_yao_wen` (
  `id`          INT(100)  NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  `group`       int(1)             DEFAULT 1
  COMMENT '用户等级默认 1级',
  `mobile`      VARCHAR(11)        DEFAULT NULL
  COMMENT '手机号',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `updata_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '用户等级表';

INSERT INTO tyb_user_group (mobile) VALUE ('18907447909');
# INSERT INTO user_group(group,mobile) VALUE (3,'18574403920');
# /*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
# /*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
# /*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
# /*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
