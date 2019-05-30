wget http://mirrors.shu.edu.cn/apache/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.tar.gz
###解压
tar vxf apache-maven-3.5.2-bin.tar.gz
###移动
mv apache-maven-3.5.2 /usr/local/maven3
###配置
vim  /etc/profile中添加以下几行
MAVEN_HOME=/usr/local/maven3
export MAVEN_HOME
export PATH=${PATH}:${MAVEN_HOME}/bin
###使环境变量生效。
source /etc/profile
###验证
mvn -version 