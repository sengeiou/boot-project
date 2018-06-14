rpm -ivh jdk-8u151-linux-x64.rpm   这是rpm文件方式解压缩安装

tar -zxvf jdk-8u60-linux-x64.tar.gz    这是tar压缩包方式解压缩安装（Java目录）


vi /etc/profile                  进入profile文件的编辑模式 （可以通过xftp直接新建文件然后再编辑）



 在最后边追加一下内容(**配置的时候一定要根据自己的目录情况而定哦！**)

 这种就可以了
 #JDK环境变量
 export JAVA_HOME=/xzm/jdk1.8.0_161
 export JRE_HOME=/$JAVA_HOME/jre
 export CLASSPATH=.:$JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
 export PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin


  source /etc/profile 使配置生效