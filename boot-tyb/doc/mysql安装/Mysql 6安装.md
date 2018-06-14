##Linux之一次性安装开发工具：yum groupinstall Development tools 

sudo rpm -ivh /目录/jdk-7-linux-x64.rpm 可以指定安装目录
rpm -qa|grep mysql #查看mysql是否安装，如果已经安装需要卸载，如果是
yum -y remove mysql-libs-5.1.71-1.el6.x86_64 
mv /xzm/tomcat  /usr/local 移动文件到指定目录
mv命令既可以重命名，又可以移动文件或文件夹。
例子：将目录A重命名为B
mv A B
 #卸载
cd /usr/local/ #指定目录
tar -xvf mysql-5.7.18-1.el6.x86_64.rpm-bundle.tar
 #解压
rpm -ivh mysql-community-common-5.7.18-1.el6.x86_64.rpm
rpm -ivh mysql-community-libs-5.7.18-1.el6.x86_64.rpm
如果提示错误
Failed dependencies:
	libc.so.6(GLIBC_2.14)(64bit) is needed by mysql-community-libs-5.7.18-1.el7.x86_64
可依次尝试 yum list glibc*
          yum install glibc.i686  
          yum install libstdc++.i686
rpm -ivh mysql-community-client-5.7.18-1.el6.x86_64.rpm
yum install perl #安装server时需要的依赖包
yum install numactl #安装server时需要的依赖包
yum install libaio #安装时需要的依赖包
rpm -ivh mysql-community-server-5.7.18-1.el6.x86_64.rpm
service mysqld start #启动mysqld服务
netstat -tlunp #查看服务所需端口
cat /var/log/mysqld.log | more #查看日志，找初始密码
cat /etc/issue #查看系统版本
getconf LONG_BIT #查看系统位数

error: Failed dependencies:
        libnuma.so.1()(64bit) is needed by MySQL-server-5.6.28-1.el6.x86_64
        libnuma.so.1(libnuma_1.1)(64bit) is needed by MySQL-server-5.6.28-1.el6.x86_64
        libnuma.so.1(libnuma_1.2)(64bit) is needed by MySQL-server-5.6.28-1.el6.x86_64
缺失依赖包
[root@mysqlmaster mysqlinstall]# yum install numactl
查看随机密码
cat /var/log/mysqld.log | grep password

2）使用root登录
#mysql -u root -p
set global validate_password_policy=0; 设置安全级别
alter user 'root'@'localhost' identified by 'xzm348701'; #设置root的密码为Mysql@123456
use mysql;
update user set user.Host='%' where user.User='root';
flush privileges;
exit;
/sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT #配置端口3306
/etc/rc.d/init.d/iptables save #保存配置
/etc/init.d/iptables restart #重启防火墙iptables


## 建立数据库
SHOW DATABASES;

USE mysql;
SHOW TABLES;
CREATE DATABASE tyb;
修改数据库编码
alter database +数据库名称  default character set utf8 collate utf8_general_ci;
 show create database +数据库名称;，来查看确认是否更改成功。可以看到已经是utf8格式了。





SELinux 开启和关闭 可以防止（貌似是centos7新出） 可以防止某些软件安装不上或者服务运行不起来
2016年07月29日 14:31:46
阅读数：37718
查看SELinux状态：

1、/usr/sbin/sestatus -v      ##如果SELinux status参数为enabled即为开启状态

SELinux status:                 enabled

2、getenforce                 ##也可以用这个命令检查

关闭SELinux：

1、临时关闭（不用重启机器）：

setenforce 0                  ##设置SELinux 成为permissive模式

                              ##setenforce 1 设置SELinux 成为enforcing模式

2、修改配置文件需要重启机器：

修改/etc/selinux/config 文件

将SELINUX=enforcing改为SELINUX=disabled

重启机器即可

netstat -ntlp 查看进程
 
lsof -i tcp:80
 
列出所有端口
 
netstat -ntlp

netstat -tunpl

查看端口是否可访问：telnet ip 端口号 
（如本机的35465：telnet localhost 35465）

如果想开放端口（如：8889）

（1）通过vi /etc/sysconfig/iptables 进入编辑增添一条-A INPUT -p tcp -m tcp --dport 8889 -j ACCEPT 即可
 -I INPUT -p tcp --dport 6379  -j ACCEPT 
（2）执行 /etc/init.d/iptables restart 命令将iptables服务重启

（3）保存 /etc/rc.d/init.d/iptables save