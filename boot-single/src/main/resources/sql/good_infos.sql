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
DROP TABLE IF EXISTS `good_infos`;
CREATE TABLE `good_infos` (
  `tg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `tg_title` varchar(50) DEFAULT NULL COMMENT '标题',
  `tg_price` DECIMAL(8) DEFAULT NULL COMMENT '价格',
  `tg_unit` varchar(20) DEFAULT NULL COMMENT '单价',
  `tg_order` varchar(255) DEFAULT NULL COMMENT '订单',
  `tg_type_id` INT(11) DEFAULT NULL COMMENT '订单类型Id',
  PRIMARY KEY (`tg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT good_infos(tg_title, tg_price, tg_unit, tg_order, tg_type_id) VALUES ('袜子', 23,'23.0','袜子袜子袜子',11);
INSERT good_infos(tg_title, tg_price, tg_unit, tg_order, tg_type_id) VALUES ('鞋子', 45,'45.0','鞋子鞋子鞋子鞋子',12);
INSERT good_infos(tg_title, tg_price, tg_unit, tg_order, tg_type_id) VALUES ('裤子', 80,'80.0','裤子裤子裤子裤子',13);

