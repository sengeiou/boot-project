#  查询时间，友好提示
SELECT  date_format(create_time,'%Y-%m-%d') AS day FROM test_sign_history;

#  时间戳类型
# SELECT  from_unixtime(create_time,)
select from_unixtime(create_time, '%Y-%m-%d') AS days FROM test_sign_history;

# #  一个sql返回多个总数
# SELECT  count(*) ALL ;
# count(case when status = 1 then status end) status_1_num,
#
#  时间戳类型

#求数字的连续范围。
select min(number) start_range,max(number) end_range FROM
  (
    SELECT number,rn,number-rn diff FROM
    (
      SELECT number,@number:=@number+1 rn FROM test_number,(SELECT @number:=0) AS number
    ) b

  ) c GROUP BY diff;


#              统计每天的每小时用户签到情况
select
  hs,
  sum(case when create_times='2016-12-11' then cc else 0 end) 123s,
  sum(case when create_times='2016-12-12' then cc else 0 end) 12Sign,
  sum(case when create_times='2016-12-13' then cc else 0 end) 13Sign,
  sum(case when create_times='2016-12-14' then cc else 0 end) 14Sign,
  sum(case when create_times='2016-12-15' then cc else 0 end) 15Sign,
  sum(case when create_times='2016-12-16' then cc else 0 end) 16Sign,
  sum(case when create_times='2016-12-17' then cc else 0 end) 17Sign
from
  (
    select
      date_format(create_time,'%Y-%m-%d') create_times,
      hour(create_time) hs,
      count(*) cc
    from test_sign_history
    group by
      date_format(create_time,'%Y-%m-%d') ,
      hour(create_time)
  ) aa
group by hs with rollup;











