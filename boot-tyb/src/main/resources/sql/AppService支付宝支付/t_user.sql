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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `phone` varchar(30) DEFAULT NULL COMMENT '',
  `password` varchar(50) DEFAULT NULL COMMENT '',
  `username` varchar(20) DEFAULT NULL COMMENT '',
  `sex` int(2) DEFAULT NULL COMMENT '',
  `age` int (5) DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO t_user(id, phone, password, username, sex, age) VALUES (1, '18907447909','xzm123456','xzm1102207843',1,25);



DROP TABLE IF EXISTS `t_token`;
CREATE TABLE `t_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `phone` varchar(30) DEFAULT NULL COMMENT '',
  `token` varchar(50) DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `userId` int(11) DEFAULT NULL COMMENT '',
  `phone` varchar(50) DEFAULT NULL COMMENT '',
  `payMoney` DECIMAL(20) DEFAULT NULL COMMENT '',
  `payGoods` varchar(20) DEFAULT NULL COMMENT '',
  `payStatus` int(5) DEFAULT NULL COMMENT '',
  `payTime` int(20) DEFAULT NULL COMMENT '',
  `payWay` int (10) DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
