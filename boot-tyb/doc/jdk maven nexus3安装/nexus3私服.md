原文链接=http://www.54tianzhisheng.cn/2017/10/14/Nexus3-Maven/
https://www.sonatype.com/download-oss-sonatype 下载 linux 最新版本，直接下载速度可能很慢，建议用迅雷下载会快很多的。
tar -zxvf nexus-3.6.0-02-unix.tar.gz -C  /usr/local/
设置RUN_AS_USER=root
那我们按照它的指示设置RUN_AS_USER=root
命令行：vi ./bin/nexus
vim /etc/sysconfig/iptables
###开放端口
-A INPUT -p tcp -m state --state NEW -m tcp --dport 8081 -j ACCEPT
nexus3默认端口是:8081
nexus3默认账号是:admin
nexus3默认密码是:admin123
./nexus start & 运行服务
http://localhost:8081/nexus/
###设置开机自启动
ln -s /usr/local/nexus-3.6.0-02/bin/nexus /etc/init.d/nexus3
chkconfig --add nexus3
chkconfig nexus3 on
