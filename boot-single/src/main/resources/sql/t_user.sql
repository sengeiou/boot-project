/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-04-04 16:31:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `t_name` varchar(30) DEFAULT NULL COMMENT '名称',
  `t_age` int(10) DEFAULT NULL COMMENT '年龄',
  `t_address` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `t_pwd` varchar(30) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('xzm', '25','上海','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('root', '23','上ht海','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('xzm', '25','上at海','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('root', '23','上ww海','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('xzm', '25','上海dd','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('root', '23','w','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('xzm', '25','awdwa','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('root', '23','上海','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('xzm', '25','htt','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('root', '23','上tht海','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('xzm', '25','ht','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('root', '23','ht','123456');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('xzm', '88','测试上海','2323');
INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('数据库11', '25','上海11','111111');
# INSERT INTO t_user(t_name, t_age, t_address, t_pwd) VALUES ('数据库22', '26','上海22','222222');
