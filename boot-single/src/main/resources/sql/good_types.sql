


DROP TABLE IF EXISTS `good_types`;
CREATE TABLE `good_types` (
  `tgt_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `tgt_name` varchar(30) DEFAULT NULL COMMENT '名称',
  `tgt_is_show` CHAR(1) DEFAULT NULL COMMENT '是否显示',
  `tgt_order` INT(2) DEFAULT NULL COMMENT '订单分类信息',
  PRIMARY KEY (`tgt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# INSERT good_types()
