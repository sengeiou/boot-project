
Tomcat
tar -zxvf apache-tomcat-8.5.24.tar.gz // 解压压缩包  
 mv apache-tomcat-8.5.24 tomcat
  /usr/local/tomcat/bin/startup.sh
  
  /root/xzm/tomcat/bin/startup.sh
  /root/xzm/tomcat/bin/shutdown.sh 
  
 保存按esc 然后冒号:
我输入的是WQ
W：write，写入

Q：quit，退出  


配置Tomcat的环境变量
在/etc/profile文件后再追加一条TOMCAT的环境变量
# 在/etc/profile文件末尾追加TOMCAT的环境变量
export CATALINA_HOME=/usr/local/java/apache-tomcat-8.5.23
(CATALINA是Tomcat的启动程序，Tomcat的启动脚本都是使用CATALINA_HOME作为变量，
所以这里我们要设置CATALINA_HOME)
使用source命令完成是配置生效
source /etc/profile
	配置节点
	  <Context path="" docBase="/xzm/tomcat/web/index.html"  reloadable="true" />

##将Tomcat配置为服务  

# 把tomcat的脚本文件拷一份到/etc/init.d目录
cp /usr/local/java/apache-tomcat-8.5.23/bin/catalina.sh /etc/init.d/tomcat8
cp /usr/local/tomcat8/bin/catalina.sh /etc/init.d/tomcat8
# 并把改脚本授权给所有用户执行
chmod 755 /etc/init.d/tomcat8
拷贝的脚本并不能直接使用，还需要修改添加一些配置。
vi /etc/init.d/tomcat8
添加chkconfig和description两行注释。有这两行注释才能支持chkconfig命令配置服务；
在文件头最上面
#chkconfig: 2345 10 90
#description: tomcat8 service
export JAVA_HOME=/usr/local/jdk1.8.0_161
export CATALINA_HOME=/usr/local/tomcat8
使用chkconfig --add命令添加服务	  
chkconfig --add tomcat8
service tomcat8 start和service tomcat8 stop命令来启动和停止tomcat服务。


SpringBoot部署war 
在Tomcat的server.xml下可以配置一下节点试试
<Context docBase="deom" path="" reloadable="false" source="org.eclipse.jst.jee.server:项目名"/>

centos6启动方式
# 启动sshd服务
service sshd start
# 设置sshd服务开机启动
chkconfig sshd start
centos7启动方式
# 开启服务
systemctl start sshd.service
# 设置开机启动
systemctl enable sshd.service

# 查看内核版本
uname -r 