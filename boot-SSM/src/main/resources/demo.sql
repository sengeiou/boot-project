/*
Date: 2017-04-11 19:49:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `sex` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'user', '123', '男');
INSERT INTO `t_user` VALUES ('2', '18907447909', 'xzm123456', '男');


DROP TABLE IF EXISTS `u_user_list`;
CREATE TABLE `u_user_list` (
  `u_id` INT (11) NOT NULL AUTO_INCREMENT,
  `u_UserName` varchar(40) NOT NULL,
  `u_Name` varchar(40) NOT NULL,
  `u_PassWord` varchar(20) NOT NULL,
  `u_PhoneNumber` varchar(20) NOT NULL,
  `u_Sex` varchar(4) NOT NULL,
  `u_Age` varchar(4) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `u_user_list` VALUES (1, 'xzm1102207843', '徐1萌', 'xzm123456', '18907447909', '男', '23');
INSERT INTO `u_user_list` VALUES (2, 'xzm1102207843', '徐2萌', 'xzm123456', '18907447909', '男', '22');
INSERT INTO `u_user_list` VALUES (3, 'xzm1102207843', '徐3萌', 'xzm123456', '18907447909', '男', '21');
INSERT INTO `u_user_list` VALUES (4, 'xzm1102207843', '徐4萌', 'xzm123456', '18907447909', '男', '20');
INSERT INTO `u_user_list` VALUES (5, 'xzm1102207843', '徐5萌', 'xzm123456', '18907447909', '男', '19');
INSERT INTO `u_user_list` VALUES (6, 'xzm1102207843', '徐6萌', 'xzm123456', '18907447909', '男', '18');


