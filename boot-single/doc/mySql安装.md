####Linux之一次性安装开发工具命令：
- yum groupinstall Development tools
、卸载系统自带的Mariadb
rpm -qa|grep mariadb         //查询出已安装的mariadb
yum -y remove 文件名 
#方式一
## 1.安装mysql的yum源
mysql57-community-release-el6-9.noarch  文件安装形式
wget https://dev.mysql.com/get/mysql57-community-release-el6-9.noarch.rpm
b.安装用来配置mysql的yum源的rpm包
- rpm -Uvh mysql57-community-release-el6-9.noarch.rpm

- 或 yum localinstall -y mysql57-community-release-el6-9.noarch.rpm

##2.安装mysql
yum install mysql-community-server





#方式二
1、安装客户端和服务器端
rpm -qal |grep mysql  查看mysql安装目录文件
确认mysql是否已安装：
yum list installed mysql*
rpm -qa | grep mysql*
查看是否有安装包：
yum list mysql*
安装mysql客户端：
yum install mysql
安装mysql 服务器端：

yum install mysql-server
yum install mysql-devel

2、启动、停止设置
数据库字符集设置
mysql配置文件/etc/my.cnf中加入
default-character-set=utf8
character-set-server=utf8
启动mysql服务：
service mysqld start
或者/etc/init.d/mysqld start
设置开机启动：
chkconfig --add mysqld
查看开机启动设置是否成功

chkconfig --list | grep mysql*
mysqld 0:关闭 1:关闭 2:启用 3:启用 4:启用 5:启用 6:关闭
停止mysql服务：
service mysqld stop

3、登录及忘记修改密码
创建root管理员：
mysqladmin -u root password 666666
登录：
mysql -u root -p
如果忘记密码，则执行以下代码
service mysqld stop
mysqld_safe --user=root --skip-grant-tables
mysql -u root
use mysql
update user set password=password("xzm348701") where user="root";
flush privileges;

4、允许远程访问设置
开放防火墙的端口号
mysql增加权限：mysql库中的user表新增一条记录host为“%”，user为“root”。
use mysql;
UPDATE user SET `Host` = '%' WHERE `User` = 'root' LIMIT 1;
flush privileges;
%表示允许所有的ip访问


5、mysql的几个重要目录
(a)数据库目录
/var/lib/mysql/
(b)配置文件
/usr/share /mysql（mysql.server命令及配置文件）
(c)相关命令
/usr/bin（mysqladmin mysqldump等命令）
(d)启动脚本
/etc/rc.d/init.d/（启动脚本文件mysql的目录）
