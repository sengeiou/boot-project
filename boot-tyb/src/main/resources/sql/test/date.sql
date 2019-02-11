CREATE TABLE `tmysql_test_lianxu_3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `sts` datetime DEFAULT NULL COMMENT '登录时间',
  `ets` datetime DEFAULT NULL COMMENT '离线时间',
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
#   测试数据为：

INSERT INTO `tmysql_test_lianxu_3` VALUES (1, 1, '2014-1-1 21:00:00', '2014-1-2 07:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (3, 2, '2014-1-1 09:00:00', '2014-1-1 15:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (4, 2, '2014-1-2 09:00:00', '2014-2-1 16:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (5, 1, '2014-1-4 10:00:00', '2014-1-4 18:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (6, 1, '2014-1-5 12:00:00', '2014-1-5 13:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (7, 2, '2014-1-10 00:00:00', '2014-1-10 06:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (8, 2, '2014-1-11 13:00:00', '2014-1-11 18:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (10, 2, '2014-1-12 12:00:00', '2014-1-12 18:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (11, 1, '2014-1-8 06:00:00', '2014-1-8 16:00:00');
INSERT INTO `tmysql_test_lianxu_3` VALUES (12, 2, '2014-1-11 21:00:00', '2014-1-12 06:00:00');



SELECT uid, days, COUNT(*) AS num
FROM (SELECT uid,
        @cont_day :=
        (CASE
         WHEN (@last_uid = uid AND DATEDIFF(login_dt, @last_dt) = 1) THEN
           (@cont_day + 1)
         ELSE
           1
         END) AS days,
        (@cont_ix := (@cont_ix + IF(@cont_day = 1, 1, 0))) AS cont_ix,
        @last_uid := uid,
        @last_dt := login_dt
      FROM (SELECT uid, DATE(sts) AS login_dt
            FROM tmysql_test_lianxu_3
            ORDER BY uid, sts) AS t,
        (SELECT @last_uid := '',
           @last_dt  := '',
           @cont_ix  := 0,
           @cont_day := 0) AS t1) AS t2
GROUP BY uid, days;





# SELECT * FROM (SELECT * FROM (
#                                SELECT uid, max(days) lianxu_days, min(login_day) start_date,max(login_day) end_date
#                                FROM (SELECT uid,
#                                        @cont_day :=
#                                        (CASE
#                                         WHEN (@last_uid = uid AND DATEDIFF(created_ts, @last_dt)=1) THEN
#                                           (@cont_day + 1)
#                                         WHEN (@last_uid = uid AND DATEDIFF(created_ts, @last_dt)<1) THEN
#                                           (@cont_day + 0)
#                                         ELSE
#                                           1
#                                         END) AS days,
#                                        (@cont_ix := (@cont_ix + IF(@cont_day = 1, 1, 0))) AS cont_ix,
#                                        @last_uid := uid,
#                                        @last_dt := created_ts login_day
#                                      FROM (SELECT uid, DATE(created_ts) created_ts FROM plan_stage WHERE uid !=0 ORDER BY uid, created_ts) AS t,
#                                        (SELECT @last_uid := '', @last_dt  := '', @cont_ix  := 0, @cont_day := 0) AS t1
#                                     ) AS t2 GROUP BY uid, cont_ix HAVING lianxu_days > 10
#                              ) tmp ORDER BY lianxu_days DESC) ntmp GROUP BY uid;