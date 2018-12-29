、卸载系统自带的Mariadb
rpm -qa|grep mariadb         //查询出已安装的mariadb
yum -y remove 文件名 
查看所有mysql文件相关  7以上
rpm -qa|grep -i mysql
[root@localhost rc.d]# cd /var/lib/
[root@localhost lib]# rm -rf mysql/
删除
rpm -ev MySQL-client-5.5.25a-1.rhel5
如果提示错误
rpm -ev MySQL-client-5.5.25a-1.rhel5 --nodeps
如果提示
error: %preun(xxxxxx) scriptlet failed, exit status 1
则用以下命令尝试：
rpm -e --noscripts MySQL-client-5.5.25a-1.rhel5
再次查找
find / -name mysql
或者
yum remove mysql-libs
查看日志
cat /var/log/mysqlg.log
类似的错误，都可以先试试彻底从centos中卸载mysql
依次执行以下命令安装
 tar -xvf mysql-5.7.18-1.el7.x86_64.rpm-bundle.tar
 rpm -ivh mysql-community-common-5.7.18-1.el7.x86_64.rpm
 rpm -ivh mysql-community-libs-5.7.18-1.el7.x86_64.rpm
 rpm -ivh mysql-community-client-5.7.18-1.el7.x86_64.rpm
 rpm -ivh mysql-community-server-5.7.18-1.el7.x86_64.rpm 这句不成功可尝试下面
 rpm -ivh mysql-community-server-5.7.18-1.el7.x86_64.rpm --force --nodeps
1）
然后启动
systemctl start mysqld
查看状态：
systemctl status mysqld
生成随机密码
cat /var/log/mysqld.log | grep password

2）使用root登录
#mysql -u root -p

3）修改密码 UPDATE user SET password = PASSWORD('xzm123456') WHERE user = 'xuzongmeng';
mysql>set password for root@localhost = password('xzm123456');
4）修改安全级别
mysql> set global validate_password_policy=0;//0最低，1中级，2最强验证级别
5）创建普通用户：
create user ‘jirauser’ identified by ‘jiara123a’
用户jirauser，密码jira123a
五、授权远程连接
mysql>GRANT ALL PRIVILEGES ON . TO ‘root’@’%’ IDENTIFIED BY ‘xzm123456’ WITH GRANT OPTION;
grant all privileges  on *.* to root@'%' identified by "xzm123456";
flush privileges;

GRANT ALL PRIVILEGES ON *.* TO root@"172.16.16.152" IDENTIFIED BY "xzm348701" WITH GRANT OPTION;
exit



2看看此数据库用户和对应ip情况
mysql> select host,user from mysql.user;
3查看当前用户
mysql> select current_user();
4. 查看当前用户权限
mysql> show grants for current_user();

4xxx. 查看当前用户权限
mysql> show grants for xuzongmeng@'%';

5新建一个用户
mysql> create user 'xuzongmeng'@'%' identified by 'xzm348701';
6. 授予权限
mysql> grant all privileges on *.* to 'xuzongmeng'@'%' identified by 'password' with grant option;
7. flush privileges;
8. exit
假如要 撤销授权(这不是步骤之一，只是记录下命令)
mysql> revoke all privileges on *.* from 'cuihe'@'%';


新ROOT密码时出错 
update user set password = '123456' where user ="root" //这样写是错的，
密码其实不是123456 应该为
update user set password = password ('123456') where user = "root" 